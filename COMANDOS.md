# Comandos para iniciar
```powershell
java -jar .\lib\antlr-4.13.2-complete.jar -visitor -o .\generated .\grammar\ProjetoILexer.g4
Copy-Item .\generated\grammar\ProjetoILexer.tokens .\grammar\ProjetoILexer.tokens -Force
java -jar .\lib\antlr-4.13.2-complete.jar -visitor -o .\generated .\grammar\ProjetoIParser.g4
javac -encoding UTF-8 -cp ".;.\lib\antlr-4.13.2-complete.jar" -d .\out (Get-ChildItem .\generated, .\src -Recurse -Filter *.java | ForEach-Object { $_.FullName })
java -cp ".;.\out;.\lib\antlr-4.13.2-complete.jar" Main .\exemplos\input.txt
```
