import java.util.LinkedHashMap;
import java.util.Map;

public class GeradorAssembly {
  private final Map<String, String> literaisString = new LinkedHashMap<>();
  private int contadorString = 0;
  private int contadorRotulosInternos = 0;
  private CodigoIntermediario codigo;

  public String gerar(CodigoIntermediario codigo) {
    this.codigo = codigo;
    this.literaisString.clear();
    this.contadorString = 0;
    this.contadorRotulosInternos = 0;

    coletarLiteraisString();

    StringBuilder asm = new StringBuilder();
    asm.append("; Codigo Assembly NASM x86-64 gerado a partir do 3AC otimizado\n");
    asm.append("; Programa: ").append(codigo.getNomePrograma()).append("\n");
    asm.append("; Sintaxe compativel com NASM/JDoodle.\n\n");

    gerarData(asm);
    gerarText(asm);
    gerarRotinasRuntime(asm);

    return asm.toString();
  }

  private void coletarLiteraisString() {
    for (String instrucao : codigo.getInstrucoes()) {
      String linha = instrucao.trim();
      if (linha.startsWith("WRITE ")) {
        String valor = linha.substring(6).trim();
        if (ehLiteralString(valor) && !literaisString.containsKey(valor)) {
          literaisString.put(valor, "str_" + contadorString++);
        }
      }
    }
  }

  private void gerarData(StringBuilder asm) {
    asm.append("default rel\n");
    asm.append("section .data\n");
    asm.append("  newline db 10\n");
    asm.append("  bool_true db \"TRUE\", 0\n");
    asm.append("  bool_false db \"FALSE\", 0\n");
    asm.append("  int_buffer times 32 db 0\n");
    asm.append("  input_buffer times 64 db 0\n");

    for (Map.Entry<String, Tipo> entrada : codigo.getVariaveis().entrySet()) {
      String nome = entrada.getKey();
      Tipo tipo = entrada.getValue();

      if (tipo == Tipo.INTEGER) {
        asm.append("  ").append(nome).append(" dw 0\n");
      } else if (tipo == Tipo.BOOLEAN) {
        asm.append("  ").append(nome).append(" db 0\n");
      } else if (tipo == Tipo.STRING) {
        asm.append("  ").append(nome).append(" times 256 db 0\n");
      }
    }

    for (String temp : codigo.getTemporarios().keySet()) {
      asm.append("  ").append(temp).append(" dw 0\n");
    }

    for (Map.Entry<String, String> entrada : literaisString.entrySet()) {
      String literal = removerAspas(entrada.getKey());
      asm.append("  ").append(entrada.getValue()).append(" db \"")
          .append(escaparStringAssembly(literal)).append("\", 0\n");
    }

    asm.append("\n");
  }

  private void gerarText(StringBuilder asm) {
    asm.append("section .text\n");
    asm.append("global _start\n\n");
    asm.append("_start:\n");

    for (String instrucao : codigo.getInstrucoes()) {
      gerarInstrucao(asm, instrucao.trim());
    }

    asm.append("\n  ; Encerramento do programa Linux x86-64\n");
    asm.append("  mov rax, 60\n");
    asm.append("  xor rdi, rdi\n");
    asm.append("  syscall\n\n");
  }

  private void gerarInstrucao(StringBuilder asm, String linha) {
    if (linha.isEmpty()) return;

    if (linha.endsWith(":")) {
      asm.append(linha).append("\n");
      return;
    }

    if (linha.startsWith("GOTO ")) {
      asm.append("  jmp ").append(linha.substring(5).trim()).append("\n");
      return;
    }

    if (linha.startsWith("IF_FALSE ")) {
      gerarIfFalse(asm, linha);
      return;
    }

    if (linha.startsWith("READ ")) {
      gerarRead(asm, linha.substring(5).trim());
      return;
    }

    if (linha.startsWith("WRITE ")) {
      gerarWrite(asm, linha.substring(6).trim());
      return;
    }

    if (linha.contains(" = ")) {
      gerarAtribuicao(asm, linha);
      return;
    }

    asm.append("  ; Instrucao nao mapeada: ").append(linha).append("\n");
  }

  private void gerarIfFalse(StringBuilder asm, String linha) {
    String[] partes = linha.split("\\s+");
    if (partes.length != 4) {
      asm.append("  ; IF_FALSE invalido: ").append(linha).append("\n");
      return;
    }

    String condicao = partes[1];
    String rotulo = partes[3];

    carregarRax(asm, condicao);
    asm.append("  cmp rax, 0\n");
    asm.append("  je ").append(rotulo).append("\n");
  }

  private void gerarRead(StringBuilder asm, String variavel) {
    Tipo tipo = codigo.getTipo(variavel);

    if (tipo == Tipo.BOOLEAN) {
      asm.append("  call _read_boolean\n");
    } else if (tipo == Tipo.STRING) {
      asm.append("  lea rdi, [").append(variavel).append("]\n");
      asm.append("  call _read_string\n");
      return;
    } else {
      asm.append("  call _read_integer\n");
    }

    armazenarRax(asm, variavel);
  }

  private void gerarWrite(StringBuilder asm, String valor) {
    if (ehLiteralString(valor)) {
      String rotulo = literaisString.get(valor);
      asm.append("  lea rdi, [").append(rotulo).append("]\n");
      asm.append("  call _print_string\n");
      return;
    }

    Tipo tipo = codigo.getTipo(valor);

    if (tipo == Tipo.BOOLEAN) {
      carregarRax(asm, valor);
      asm.append("  call _print_boolean\n");
    } else if (tipo == Tipo.STRING) {
      asm.append("  lea rdi, [").append(valor).append("]\n");
      asm.append("  call _print_string\n");
    } else {
      carregarRax(asm, valor);
      asm.append("  call _print_integer\n");
    }
  }

  private void gerarAtribuicao(StringBuilder asm, String linha) {
    String[] partesAtribuicao = linha.split(" = ", 2);
    String destino = partesAtribuicao[0].trim();
    String expressao = partesAtribuicao[1].trim();
    String[] partes = expressao.split("\\s+");

    if (expressao.startsWith("~")) {
      gerarNegacaoLogica(asm, destino, expressao.substring(1));
      return;
    }

    if (expressao.startsWith("-") && expressao.length() > 1 && !ehInteiro(expressao)) {
      carregarRax(asm, expressao.substring(1));
      asm.append("  neg rax\n");
      armazenarRax(asm, destino);
      return;
    }

    if (partes.length == 1) {
      gerarAtribuicaoSimples(asm, destino, partes[0]);
      return;
    }

    if (partes.length == 3) {
      gerarOperacaoBinaria(asm, destino, partes[0], partes[1], partes[2]);
      return;
    }

    asm.append("  ; Atribuicao nao mapeada: ").append(linha).append("\n");
  }

  private void gerarAtribuicaoSimples(StringBuilder asm, String destino, String origem) {
    carregarRax(asm, origem);
    armazenarRax(asm, destino);
  }

  private void gerarOperacaoBinaria(StringBuilder asm, String destino, String esquerda, String operador, String direita) {
    switch (operador) {
      case "+":
        carregarRax(asm, esquerda);
        carregarRbx(asm, direita);
        asm.append("  add rax, rbx\n");
        armazenarRax(asm, destino);
        break;
      case "-":
        carregarRax(asm, esquerda);
        carregarRbx(asm, direita);
        asm.append("  sub rax, rbx\n");
        armazenarRax(asm, destino);
        break;
      case "*":
        carregarRax(asm, esquerda);
        carregarRbx(asm, direita);
        asm.append("  imul rax, rbx\n");
        armazenarRax(asm, destino);
        break;
      case "/":
        carregarRax(asm, esquerda);
        carregarRbx(asm, direita);
        asm.append("  cqo\n");
        asm.append("  idiv rbx\n");
        armazenarRax(asm, destino);
        break;
      case "AND":
        carregarRax(asm, esquerda);
        carregarRbx(asm, direita);
        asm.append("  and rax, rbx\n");
        armazenarRax(asm, destino);
        break;
      case "OR":
        carregarRax(asm, esquerda);
        carregarRbx(asm, direita);
        asm.append("  or rax, rbx\n");
        armazenarRax(asm, destino);
        break;
      case "<":
      case ">":
      case "<=":
      case ">=":
      case "==":
      case "<>":
        gerarComparacao(asm, destino, esquerda, operador, direita);
        break;
      default:
        asm.append("  ; Operador nao mapeado: ").append(operador).append("\n");
    }
  }

  private void gerarComparacao(StringBuilder asm, String destino, String esquerda, String operador, String direita) {
    String rotuloVerdadeiro = novoRotuloInterno("ASM_TRUE");
    String rotuloFim = novoRotuloInterno("ASM_END_CMP");

    carregarRax(asm, esquerda);
    carregarRbx(asm, direita);
    asm.append("  cmp rax, rbx\n");
    armazenarImediato(asm, destino, "0");
    asm.append("  ").append(saltoComparacao(operador)).append(" ").append(rotuloVerdadeiro).append("\n");
    asm.append("  jmp ").append(rotuloFim).append("\n");
    asm.append(rotuloVerdadeiro).append(":\n");
    armazenarImediato(asm, destino, "1");
    asm.append(rotuloFim).append(":\n");
  }

  private void gerarNegacaoLogica(StringBuilder asm, String destino, String operando) {
    String rotuloVerdadeiro = novoRotuloInterno("ASM_NEG_TRUE");
    String rotuloFim = novoRotuloInterno("ASM_NEG_END");

    carregarRax(asm, operando);
    asm.append("  cmp rax, 0\n");
    armazenarImediato(asm, destino, "0");
    asm.append("  je ").append(rotuloVerdadeiro).append("\n");
    asm.append("  jmp ").append(rotuloFim).append("\n");
    asm.append(rotuloVerdadeiro).append(":\n");
    armazenarImediato(asm, destino, "1");
    asm.append(rotuloFim).append(":\n");
  }

  private String saltoComparacao(String operador) {
    switch (operador) {
      case "<": return "jl";
      case ">": return "jg";
      case "<=": return "jle";
      case ">=": return "jge";
      case "==": return "je";
      case "<>": return "jne";
      default: return "je";
    }
  }

  private String novoRotuloInterno(String prefixo) {
    return prefixo + "_" + contadorRotulosInternos++;
  }

  private void carregarRax(StringBuilder asm, String operando) {
    if (ehInteiro(operando)) {
      asm.append("  mov rax, ").append(operando).append("\n");
      return;
    }

    Tipo tipo = codigo.getTipo(operando);
    if (tipo == Tipo.BOOLEAN && codigo.getVariaveis().containsKey(operando)) {
      asm.append("  movzx rax, byte [").append(operando).append("]\n");
    } else {
      asm.append("  movsx rax, word [").append(operando).append("]\n");
    }
  }

  private void carregarRbx(StringBuilder asm, String operando) {
    if (ehInteiro(operando)) {
      asm.append("  mov rbx, ").append(operando).append("\n");
      return;
    }

    Tipo tipo = codigo.getTipo(operando);
    if (tipo == Tipo.BOOLEAN && codigo.getVariaveis().containsKey(operando)) {
      asm.append("  movzx rbx, byte [").append(operando).append("]\n");
    } else {
      asm.append("  movsx rbx, word [").append(operando).append("]\n");
    }
  }

  private void armazenarRax(StringBuilder asm, String destino) {
    Tipo tipo = codigo.getTipo(destino);
    if (tipo == Tipo.BOOLEAN && codigo.getVariaveis().containsKey(destino)) {
      asm.append("  mov byte [").append(destino).append("], al\n");
    } else {
      asm.append("  mov word [").append(destino).append("], ax\n");
    }
  }

  private void armazenarImediato(StringBuilder asm, String destino, String valor) {
    Tipo tipo = codigo.getTipo(destino);
    if (tipo == Tipo.BOOLEAN && codigo.getVariaveis().containsKey(destino)) {
      asm.append("  mov byte [").append(destino).append("], ").append(valor).append("\n");
    } else {
      asm.append("  mov word [").append(destino).append("], ").append(valor).append("\n");
    }
  }

  private void gerarRotinasRuntime(StringBuilder asm) {
    asm.append("; ================================\n");
    asm.append("; Rotinas auxiliares Linux x86-64\n");
    asm.append("; ================================\n\n");

    asm.append("_print_string:\n");
    asm.append("  push rdi\n");
    asm.append("  mov rsi, rdi\n");
    asm.append("  xor rdx, rdx\n");
    asm.append(".len_string:\n");
    asm.append("  cmp byte [rsi + rdx], 0\n");
    asm.append("  je .write_string\n");
    asm.append("  inc rdx\n");
    asm.append("  jmp .len_string\n");
    asm.append(".write_string:\n");
    asm.append("  mov rax, 1\n");
    asm.append("  mov rdi, 1\n");
    asm.append("  syscall\n");
    asm.append("  call _print_newline\n");
    asm.append("  pop rdi\n");
    asm.append("  ret\n\n");

    asm.append("_print_integer:\n");
    asm.append("  push rbx\n");
    asm.append("  push rcx\n");
    asm.append("  push rdx\n");
    asm.append("  push rsi\n");
    asm.append("  lea rsi, [int_buffer + 31]\n");
    asm.append("  mov byte [rsi], 10\n");
    asm.append("  mov rcx, 10\n");
    asm.append("  xor rbx, rbx\n");
    asm.append("  cmp rax, 0\n");
    asm.append("  jge .check_zero\n");
    asm.append("  mov rbx, 1\n");
    asm.append("  neg rax\n");
    asm.append(".check_zero:\n");
    asm.append("  cmp rax, 0\n");
    asm.append("  jne .convert_loop\n");
    asm.append("  dec rsi\n");
    asm.append("  mov byte [rsi], '0'\n");
    asm.append("  jmp .maybe_sign\n");
    asm.append(".convert_loop:\n");
    asm.append("  xor rdx, rdx\n");
    asm.append("  div rcx\n");
    asm.append("  add dl, '0'\n");
    asm.append("  dec rsi\n");
    asm.append("  mov [rsi], dl\n");
    asm.append("  cmp rax, 0\n");
    asm.append("  jne .convert_loop\n");
    asm.append(".maybe_sign:\n");
    asm.append("  cmp rbx, 0\n");
    asm.append("  je .write_integer\n");
    asm.append("  dec rsi\n");
    asm.append("  mov byte [rsi], '-'\n");
    asm.append(".write_integer:\n");
    asm.append("  lea rdx, [int_buffer + 32]\n");
    asm.append("  sub rdx, rsi\n");
    asm.append("  mov rax, 1\n");
    asm.append("  mov rdi, 1\n");
    asm.append("  syscall\n");
    asm.append("  pop rsi\n");
    asm.append("  pop rdx\n");
    asm.append("  pop rcx\n");
    asm.append("  pop rbx\n");
    asm.append("  ret\n\n");

    asm.append("_print_boolean:\n");
    asm.append("  cmp rax, 0\n");
    asm.append("  je .print_false\n");
    asm.append("  lea rdi, [bool_true]\n");
    asm.append("  call _print_string\n");
    asm.append("  ret\n");
    asm.append(".print_false:\n");
    asm.append("  lea rdi, [bool_false]\n");
    asm.append("  call _print_string\n");
    asm.append("  ret\n\n");

    asm.append("_print_newline:\n");
    asm.append("  mov rax, 1\n");
    asm.append("  mov rdi, 1\n");
    asm.append("  lea rsi, [newline]\n");
    asm.append("  mov rdx, 1\n");
    asm.append("  syscall\n");
    asm.append("  ret\n\n");

    asm.append("_read_integer:\n");
    asm.append("  mov rax, 0\n");
    asm.append("  mov rdi, 0\n");
    asm.append("  lea rsi, [input_buffer]\n");
    asm.append("  mov rdx, 64\n");
    asm.append("  syscall\n");
    asm.append("  lea rsi, [input_buffer]\n");
    asm.append("  xor rax, rax\n");
    asm.append("  xor rbx, rbx\n");
    asm.append(".skip_spaces:\n");
    asm.append("  mov dl, [rsi]\n");
    asm.append("  cmp dl, ' '\n");
    asm.append("  je .advance_space\n");
    asm.append("  cmp dl, 10\n");
    asm.append("  je .advance_space\n");
    asm.append("  cmp dl, 13\n");
    asm.append("  je .advance_space\n");
    asm.append("  jmp .check_sign\n");
    asm.append(".advance_space:\n");
    asm.append("  inc rsi\n");
    asm.append("  jmp .skip_spaces\n");
    asm.append(".check_sign:\n");
    asm.append("  cmp byte [rsi], '-'\n");
    asm.append("  jne .parse_digits\n");
    asm.append("  mov rbx, 1\n");
    asm.append("  inc rsi\n");
    asm.append(".parse_digits:\n");
    asm.append("  mov dl, [rsi]\n");
    asm.append("  cmp dl, '0'\n");
    asm.append("  jb .finish_read\n");
    asm.append("  cmp dl, '9'\n");
    asm.append("  ja .finish_read\n");
    asm.append("  imul rax, rax, 10\n");
    asm.append("  movzx rdx, dl\n");
    asm.append("  sub rdx, '0'\n");
    asm.append("  add rax, rdx\n");
    asm.append("  inc rsi\n");
    asm.append("  jmp .parse_digits\n");
    asm.append(".finish_read:\n");
    asm.append("  cmp rbx, 0\n");
    asm.append("  je .read_done\n");
    asm.append("  neg rax\n");
    asm.append(".read_done:\n");
    asm.append("  ret\n\n");

    asm.append("_read_boolean:\n");
    asm.append("  call _read_integer\n");
    asm.append("  cmp rax, 0\n");
    asm.append("  setne al\n");
    asm.append("  movzx rax, al\n");
    asm.append("  ret\n\n");

    asm.append("_read_string:\n");
    asm.append("  ; RDI deve conter o endereco do buffer destino.\n");
    asm.append("  mov rsi, rdi\n");
    asm.append("  mov rax, 0\n");
    asm.append("  mov rdi, 0\n");
    asm.append("  mov rdx, 255\n");
    asm.append("  syscall\n");
    asm.append("  ret\n");
  }

  private boolean ehInteiro(String valor) {
    return valor != null && valor.matches("-?\\d+");
  }

  private boolean ehLiteralString(String valor) {
    return valor != null && valor.length() >= 2 && valor.startsWith("\"") && valor.endsWith("\"");
  }

  private String removerAspas(String literal) {
    if (ehLiteralString(literal)) {
      return literal.substring(1, literal.length() - 1);
    }
    return literal;
  }

  private String escaparStringAssembly(String valor) {
    return valor.replace("\\", "\\\\").replace("\"", "\\\"");
  }
}
