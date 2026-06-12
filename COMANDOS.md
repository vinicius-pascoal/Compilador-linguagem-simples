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
