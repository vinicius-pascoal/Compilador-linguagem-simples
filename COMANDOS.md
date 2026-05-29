# Comandos para iniciar
```powershell
java -jar .\lib\antlr-4.13.2-complete.jar -visitor -o .\generated .\grammar\ProjetoILexer.g4

Copy-Item .\generated\grammar\ProjetoILexer.tokens .\grammar\ProjetoILexer.tokens -Force

java -jar .\lib\antlr-4.13.2-complete.jar -visitor -o .\generated .\grammar\ProjetoIParser.g4

$files = Get-ChildItem .\generated, .\src -Recurse -Filter *.java | ForEach-Object { $_.FullName }
javac -encoding UTF-8 -cp ".;\.\lib\antlr-4.13.2-complete.jar" -d .\out $files

java -cp ".;\.\out;\.\lib\antlr-4.13.2-complete.jar" Main .\exemplos\input.txt

javac -cp ".;\.\out;\.\lib\antlr-4.13.2-complete.jar" -d .\out generated\<NomeClasse>.java
java -cp ".;\.\out;\.\lib\antlr-4.13.2-complete.jar" <NomeClasse>
```
