# Comandos para gerar, compilar e executar

Execute os comandos abaixo na raiz do projeto.

## 1. Gerar o lexer

```powershell
java -jar .\lib\antlr-4.13.2-complete.jar -visitor -o .\generated .\grammar\ProjetoILexer.g4
```

## 2. Copiar os tokens do lexer para a pasta da gramática

```powershell
Copy-Item .\generated\grammar\ProjetoILexer.tokens .\grammar\ProjetoILexer.tokens -Force
```

## 3. Gerar o parser

```powershell
java -jar .\lib\antlr-4.13.2-complete.jar -visitor -o .\generated .\grammar\ProjetoIParser.g4
```

## 4. Compilar o compilador

```powershell
$files = Get-ChildItem .\generated, .\src -Recurse -Filter *.java | ForEach-Object { $_.FullName }
javac -encoding UTF-8 -cp ".;.\lib\antlr-4.13.2-complete.jar" -d .\out $files
```

## 5. Executar o compilador

```powershell
java -cp ".;.\out;.\lib\antlr-4.13.2-complete.jar" Main .\exemplos\input.txt
```

## Arquivos gerados pela execução

Após a execução, os arquivos abaixo são gerados na pasta `generated/`:

```text
generated/testeCompilador_3ac.txt
generated/testeCompilador_3ac_otimizado.txt
generated/testeCompilador.asm
```

## Etapas executadas pelo Main

```text
1. Análise léxica
2. Análise sintática
3. Análise semântica
4. Geração de código intermediário 3AC
5. Otimização do 3AC
6. Geração de código final Assembly x86
```

## 6. Montar e executar o Assembly NASM x86 32 bits

O arquivo `generated/testeCompilador.asm` é gerado em sintaxe NASM x86 32 bits, compatível com ambientes online que montam com `nasm -f elf`, como o modo NASM 32-bit do JDoodle.

No Linux, rode:

```bash
nasm -f elf generated/testeCompilador.asm -o generated/testeCompilador.o
ld -m elf_i386 generated/testeCompilador.o -o generated/testeCompilador
./generated/testeCompilador
```

Como o programa de exemplo usa `READ(contador, limite)`, informe dois valores na entrada padrão. Exemplo:

```text
0
10
```

## Observações sobre o Assembly gerado

O gerador emite Assembly em sintaxe NASM x86 32 bits, com:

```text
section .data   -> variáveis, temporários, strings e buffers
section .text   -> instruções executáveis
```

Os tipos são mapeados assim:

```text
INTEGER -> dw
BOOLEAN -> db
STRING  -> buffer de 256 bytes
```

Na geração de saída, o 3AC agora diferencia os comandos de escrita por tipo:

```text
WRITE_INTEGER valor
WRITE_BOOLEAN valor
WRITE_STRING valor
```

Com isso, valores booleanos são impressos como `TRUE` ou `FALSE`, em vez de `1` ou `0`.

A rotina `_read_integer` também foi ajustada para ler caractere por caractere, permitindo múltiplos comandos `READ` em sequência em ambientes online baseados em entrada padrão.


## Observação para JDoodle

Se estiver usando JDoodle, selecione Assembly/NASM em modo 32 bits. O erro `impossible combination of address sizes` ocorre quando um código x86-64 é montado em modo 32 bits. Esta versão foi ajustada para usar apenas registradores de 32 bits (`eax`, `ebx`, `ecx`, `edx`, `esi`, `edi`) e chamadas Linux via `int 0x80`.
