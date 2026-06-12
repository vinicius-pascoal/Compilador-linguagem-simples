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
    asm.append("; Codigo Assembly NASM x86 32 bits gerado a partir do 3AC otimizado\n");
    asm.append("; Programa: ").append(codigo.getNomePrograma()).append("\n");
    asm.append("; Sintaxe compativel com NASM/JDoodle em modo 32 bits.\n\n");

    gerarData(asm);
    gerarText(asm);
    gerarRotinasRuntime(asm);

    return asm.toString();
  }

  private void coletarLiteraisString() {
    for (String instrucao : codigo.getInstrucoes()) {
      String linha = instrucao.trim();
      String valor = null;

      if (linha.startsWith("WRITE_STRING ")) {
        valor = linha.substring("WRITE_STRING ".length()).trim();
      } else if (linha.startsWith("WRITE ")) {
        valor = linha.substring(6).trim();
      }

      if (valor != null && ehLiteralString(valor) && !literaisString.containsKey(valor)) {
        literaisString.put(valor, "str_" + contadorString++);
      }
    }
  }

  private void gerarData(StringBuilder asm) {
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

    asm.append("\n  ; Encerramento do programa Linux x86 32 bits\n");
    asm.append("  mov eax, 1\n");
    asm.append("  xor ebx, ebx\n");
    asm.append("  int 0x80\n\n");
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

    if (linha.startsWith("WRITE_INTEGER ")) {
      gerarWrite(asm, linha.substring("WRITE_INTEGER ".length()).trim(), Tipo.INTEGER);
      return;
    }

    if (linha.startsWith("WRITE_BOOLEAN ")) {
      gerarWrite(asm, linha.substring("WRITE_BOOLEAN ".length()).trim(), Tipo.BOOLEAN);
      return;
    }

    if (linha.startsWith("WRITE_STRING ")) {
      gerarWrite(asm, linha.substring("WRITE_STRING ".length()).trim(), Tipo.STRING);
      return;
    }

    if (linha.startsWith("WRITE ")) {
      gerarWrite(asm, linha.substring(6).trim(), Tipo.INVALIDO);
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

    carregarEax(asm, condicao);
    asm.append("  cmp eax, 0\n");
    asm.append("  je ").append(rotulo).append("\n");
  }

  private void gerarRead(StringBuilder asm, String variavel) {
    Tipo tipo = codigo.getTipo(variavel);

    if (tipo == Tipo.BOOLEAN) {
      asm.append("  call _read_boolean\n");
    } else if (tipo == Tipo.STRING) {
      asm.append("  lea edi, [").append(variavel).append("]\n");
      asm.append("  call _read_string\n");
      return;
    } else {
      asm.append("  call _read_integer\n");
    }

    armazenarEax(asm, variavel);
  }

  private void gerarWrite(StringBuilder asm, String valor, Tipo tipoEsperado) {
    if (ehLiteralString(valor)) {
      String rotulo = literaisString.get(valor);
      asm.append("  lea edi, [").append(rotulo).append("]\n");
      asm.append("  call _print_string\n");
      return;
    }

    Tipo tipo = tipoEsperado;
    if (tipo == Tipo.INVALIDO) {
      tipo = codigo.getTipo(valor);
    }

    if (tipo == Tipo.BOOLEAN) {
      carregarEax(asm, valor);
      asm.append("  call _print_boolean\n");
    } else if (tipo == Tipo.STRING) {
      asm.append("  lea edi, [").append(valor).append("]\n");
      asm.append("  call _print_string\n");
    } else {
      carregarEax(asm, valor);
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
      carregarEax(asm, expressao.substring(1));
      asm.append("  neg eax\n");
      armazenarEax(asm, destino);
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
    carregarEax(asm, origem);
    armazenarEax(asm, destino);
  }

  private void gerarOperacaoBinaria(StringBuilder asm, String destino, String esquerda, String operador, String direita) {
    switch (operador) {
      case "+":
        carregarEax(asm, esquerda);
        carregarEbx(asm, direita);
        asm.append("  add eax, ebx\n");
        armazenarEax(asm, destino);
        break;
      case "-":
        carregarEax(asm, esquerda);
        carregarEbx(asm, direita);
        asm.append("  sub eax, ebx\n");
        armazenarEax(asm, destino);
        break;
      case "*":
        carregarEax(asm, esquerda);
        carregarEbx(asm, direita);
        asm.append("  imul eax, ebx\n");
        armazenarEax(asm, destino);
        break;
      case "/":
        carregarEax(asm, esquerda);
        carregarEbx(asm, direita);
        asm.append("  cdq\n");
        asm.append("  idiv ebx\n");
        armazenarEax(asm, destino);
        break;
      case "AND":
        carregarEax(asm, esquerda);
        carregarEbx(asm, direita);
        asm.append("  and eax, ebx\n");
        armazenarEax(asm, destino);
        break;
      case "OR":
        carregarEax(asm, esquerda);
        carregarEbx(asm, direita);
        asm.append("  or eax, ebx\n");
        armazenarEax(asm, destino);
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

    carregarEax(asm, esquerda);
    carregarEbx(asm, direita);
    asm.append("  cmp eax, ebx\n");
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

    carregarEax(asm, operando);
    asm.append("  cmp eax, 0\n");
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

  private void carregarEax(StringBuilder asm, String operando) {
    if (ehInteiro(operando)) {
      asm.append("  mov eax, ").append(operando).append("\n");
      return;
    }

    Tipo tipo = codigo.getTipo(operando);
    if (tipo == Tipo.BOOLEAN && codigo.getVariaveis().containsKey(operando)) {
      asm.append("  movzx eax, byte [").append(operando).append("]\n");
    } else {
      asm.append("  movsx eax, word [").append(operando).append("]\n");
    }
  }

  private void carregarEbx(StringBuilder asm, String operando) {
    if (ehInteiro(operando)) {
      asm.append("  mov ebx, ").append(operando).append("\n");
      return;
    }

    Tipo tipo = codigo.getTipo(operando);
    if (tipo == Tipo.BOOLEAN && codigo.getVariaveis().containsKey(operando)) {
      asm.append("  movzx ebx, byte [").append(operando).append("]\n");
    } else {
      asm.append("  movsx ebx, word [").append(operando).append("]\n");
    }
  }

  private void armazenarEax(StringBuilder asm, String destino) {
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
    asm.append("; Rotinas auxiliares Linux x86 32 bits\n");
    asm.append("; ================================\n\n");

    asm.append("_print_string:\n");
    asm.append("  push ebx\n");
    asm.append("  push ecx\n");
    asm.append("  push edx\n");
    asm.append("  push esi\n");
    asm.append("  mov esi, edi\n");
    asm.append("  xor edx, edx\n");
    asm.append(".len_string:\n");
    asm.append("  cmp byte [esi + edx], 0\n");
    asm.append("  je .write_string\n");
    asm.append("  inc edx\n");
    asm.append("  jmp .len_string\n");
    asm.append(".write_string:\n");
    asm.append("  mov eax, 4\n");
    asm.append("  mov ebx, 1\n");
    asm.append("  mov ecx, esi\n");
    asm.append("  int 0x80\n");
    asm.append("  call _print_newline\n");
    asm.append("  pop esi\n");
    asm.append("  pop edx\n");
    asm.append("  pop ecx\n");
    asm.append("  pop ebx\n");
    asm.append("  ret\n\n");

    asm.append("_print_integer:\n");
    asm.append("  push ebx\n");
    asm.append("  push ecx\n");
    asm.append("  push edx\n");
    asm.append("  push esi\n");
    asm.append("  lea esi, [int_buffer + 31]\n");
    asm.append("  mov byte [esi], 10\n");
    asm.append("  mov ecx, 10\n");
    asm.append("  xor ebx, ebx\n");
    asm.append("  cmp eax, 0\n");
    asm.append("  jge .check_zero\n");
    asm.append("  mov ebx, 1\n");
    asm.append("  neg eax\n");
    asm.append(".check_zero:\n");
    asm.append("  cmp eax, 0\n");
    asm.append("  jne .convert_loop\n");
    asm.append("  dec esi\n");
    asm.append("  mov byte [esi], '0'\n");
    asm.append("  jmp .maybe_sign\n");
    asm.append(".convert_loop:\n");
    asm.append("  xor edx, edx\n");
    asm.append("  div ecx\n");
    asm.append("  add dl, '0'\n");
    asm.append("  dec esi\n");
    asm.append("  mov [esi], dl\n");
    asm.append("  cmp eax, 0\n");
    asm.append("  jne .convert_loop\n");
    asm.append(".maybe_sign:\n");
    asm.append("  cmp ebx, 0\n");
    asm.append("  je .write_integer\n");
    asm.append("  dec esi\n");
    asm.append("  mov byte [esi], '-'\n");
    asm.append(".write_integer:\n");
    asm.append("  lea edx, [int_buffer + 32]\n");
    asm.append("  sub edx, esi\n");
    asm.append("  mov eax, 4\n");
    asm.append("  mov ebx, 1\n");
    asm.append("  mov ecx, esi\n");
    asm.append("  int 0x80\n");
    asm.append("  pop esi\n");
    asm.append("  pop edx\n");
    asm.append("  pop ecx\n");
    asm.append("  pop ebx\n");
    asm.append("  ret\n\n");

    asm.append("_print_boolean:\n");
    asm.append("  cmp eax, 0\n");
    asm.append("  je .print_false\n");
    asm.append("  lea edi, [bool_true]\n");
    asm.append("  call _print_string\n");
    asm.append("  ret\n");
    asm.append(".print_false:\n");
    asm.append("  lea edi, [bool_false]\n");
    asm.append("  call _print_string\n");
    asm.append("  ret\n\n");

    asm.append("_print_newline:\n");
    asm.append("  push ebx\n");
    asm.append("  push ecx\n");
    asm.append("  push edx\n");
    asm.append("  mov eax, 4\n");
    asm.append("  mov ebx, 1\n");
    asm.append("  mov ecx, newline\n");
    asm.append("  mov edx, 1\n");
    asm.append("  int 0x80\n");
    asm.append("  pop edx\n");
    asm.append("  pop ecx\n");
    asm.append("  pop ebx\n");
    asm.append("  ret\n\n");

    asm.append("_read_integer:\n");
    asm.append("  ; Le um inteiro da entrada padrao caractere por caractere.\n");
    asm.append("  ; Isso permite multiplos READ sequenciais em compiladores online.\n");
    asm.append("  push ebx\n");
    asm.append("  push ecx\n");
    asm.append("  push edx\n");
    asm.append("  push esi\n");
    asm.append("  push edi\n");
    asm.append("  push ebp\n");
    asm.append("  xor edi, edi\n");
    asm.append("  xor ebp, ebp\n");
    asm.append(".skip_spaces:\n");
    asm.append("  mov eax, 3\n");
    asm.append("  xor ebx, ebx\n");
    asm.append("  mov ecx, input_buffer\n");
    asm.append("  mov edx, 1\n");
    asm.append("  int 0x80\n");
    asm.append("  cmp eax, 1\n");
    asm.append("  jne .empty_input\n");
    asm.append("  mov al, [input_buffer]\n");
    asm.append("  cmp al, ' '\n");
    asm.append("  je .skip_spaces\n");
    asm.append("  cmp al, 9\n");
    asm.append("  je .skip_spaces\n");
    asm.append("  cmp al, 10\n");
    asm.append("  je .skip_spaces\n");
    asm.append("  cmp al, 13\n");
    asm.append("  je .skip_spaces\n");
    asm.append("  cmp al, '-'\n");
    asm.append("  jne .first_digit\n");
    asm.append("  mov ebp, 1\n");
    asm.append("  jmp .read_next_digit\n");
    asm.append(".first_digit:\n");
    asm.append("  cmp al, '0'\n");
    asm.append("  jb .finish_read\n");
    asm.append("  cmp al, '9'\n");
    asm.append("  ja .finish_read\n");
    asm.append("  movzx esi, al\n");
    asm.append("  sub esi, '0'\n");
    asm.append("  mov edi, esi\n");
    asm.append(".read_next_digit:\n");
    asm.append("  mov eax, 3\n");
    asm.append("  xor ebx, ebx\n");
    asm.append("  mov ecx, input_buffer\n");
    asm.append("  mov edx, 1\n");
    asm.append("  int 0x80\n");
    asm.append("  cmp eax, 1\n");
    asm.append("  jne .finish_read\n");
    asm.append("  mov al, [input_buffer]\n");
    asm.append("  cmp al, '0'\n");
    asm.append("  jb .finish_read\n");
    asm.append("  cmp al, '9'\n");
    asm.append("  ja .finish_read\n");
    asm.append("  imul edi, edi, 10\n");
    asm.append("  movzx esi, al\n");
    asm.append("  sub esi, '0'\n");
    asm.append("  add edi, esi\n");
    asm.append("  jmp .read_next_digit\n");
    asm.append(".finish_read:\n");
    asm.append("  mov eax, edi\n");
    asm.append("  cmp ebp, 0\n");
    asm.append("  je .restore_and_return\n");
    asm.append("  neg eax\n");
    asm.append("  jmp .restore_and_return\n");
    asm.append(".empty_input:\n");
    asm.append("  xor eax, eax\n");
    asm.append(".restore_and_return:\n");
    asm.append("  pop ebp\n");
    asm.append("  pop edi\n");
    asm.append("  pop esi\n");
    asm.append("  pop edx\n");
    asm.append("  pop ecx\n");
    asm.append("  pop ebx\n");
    asm.append("  ret\n\n");

    asm.append("_read_boolean:\n");
    asm.append("  call _read_integer\n");
    asm.append("  cmp eax, 0\n");
    asm.append("  setne al\n");
    asm.append("  movzx eax, al\n");
    asm.append("  ret\n\n");

    asm.append("_read_string:\n");
    asm.append("  ; EDI deve conter o endereco do buffer destino.\n");
    asm.append("  push ebx\n");
    asm.append("  push ecx\n");
    asm.append("  push edx\n");
    asm.append("  mov eax, 3\n");
    asm.append("  xor ebx, ebx\n");
    asm.append("  mov ecx, edi\n");
    asm.append("  mov edx, 255\n");
    asm.append("  int 0x80\n");
    asm.append("  pop edx\n");
    asm.append("  pop ecx\n");
    asm.append("  pop ebx\n");
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
