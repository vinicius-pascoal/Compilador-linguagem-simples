# Comandos para iniciar
```powershell
java -jar .\lib\antlr-4.13.2-complete.jar -visitor -o .\generated .\grammar\ProjetoI.g4
javac -encoding UTF-8 -cp ".;.\lib\antlr-4.13.2-complete.jar" -d .\out (Get-ChildItem .\generated, .\src -Recurse -Filter *.java | ForEach-Object { $_.FullName })
java -cp ".;.\out;.\lib\antlr-4.13.2-complete.jar" Main .\exemplos\input.txt
```
