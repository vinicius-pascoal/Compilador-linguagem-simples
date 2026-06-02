# Erros detectados no projeto

Este arquivo lista problemas encontrados na análise estática das gramáticas e código Java, com sugestões para correção.

---

## 1) Arquivo: grammar/ProjetoILexer.g4

- COMMENT: `COMMENT: '/*' ( . | '\r' | '\n' )*? '*/' -> skip;` — Status: Resolvido (regra atualizada no lexer).

- CTE: `CTE: NUM_1_32767 | '0';` — Status: Resolvido (regra atualizada no lexer).
  - Observação: agora `CTE` aceita apenas `0` ou inteiros no intervalo 1..32767. Sequências de dígitos que não se encaixarem serão capturadas por `ERRO_CTE_2_BYTES` e tratadas como erro léxico/sintático.

- ERRO_CTE_2_BYTES: `ERRO_CTE_2_BYTES: DIGITO+;`
  - Problema: esta regra captura qualquer sequência de dígitos e conflita com `CTE`. A intenção (detecta constantes fora do intervalo) não é corretamente garantida pela forma atual.
  - Sugestão: remover essa regra e detectar inteiros fora de intervalo no `AnalisadorSemantico`, ou criar uma regra léxica específica mais precisa posicionada corretamente.

- Fragments por letra (A, B, D, E, ..., Y)
  - Problema: faltam fragments para algumas letras (ex.: `C, J, K, Q, X, Z`). Definição por letra é redundante e frágil.
  - Sugestão: remover fragments A..Z e usar `fragment LETRA: [a-zA-Z];` (já existe) ou declarar palavras-chave com classes case-insensitive (`[pP][rR][oO]...`).

- CADEIA: `CADEIA: '"' (~["\r\n])* '"';`
  - Problema: não aceita sequências com escape `\"` dentro da string.
  - Sugestão: caso queira suportar escapes, usar: `CADEIA: '"' ( '\\' . | ~["\\\r\n] )* '"' ;`.

# Erros de gramática e analisador sintático

Este arquivo lista apenas os problemas relacionados à gramática (lexer) e ao analisador sintático (parser), com sugestões de correção.

---

## Arquivo: [grammar/ProjetoILexer.g4](grammar/ProjetoILexer.g4)

- `COMMENT: '/*' ( . | '\r' | '\n' )*? '*/' -> skip;` — Status: Resolvido (regra atualizada no lexer).

- `CTE: NUM_1_32767 | '0';` — Status: Resolvido (regra atualizada no lexer).
  - Observação: números válidos (1..32767 e `0`) serão tokenizados como `CTE`. Números inválidos (ex.: `40000`, `012`) serão tokenizados como `ERRO_CTE_2_BYTES` e reportados por `Main.validarTokensLexicos`.

- `ERRO_CTE_2_BYTES: DIGITO+;`
  - Problema: captura qualquer sequência de dígitos e conflita com `CTE`; não garante detectar apenas números fora do intervalo.
  - Sugestão: remover esta regra do lexer e detectar overflow em `AnalisadorSemantico`, ou definir uma regra léxica precisa (por ex., números com comprimento maior que 5) posicionada após `CTE`.

- Fragments A..Y junto com `fragment LETRA`
  - Problema: existência de fragments por letra incompletos (faltam `C, J, K, Q, X, Z`) e redundância com `fragment LETRA: [a-zA-Z];`.
  - Sugestão: remover os fragments individuais A..Y e usar apenas `fragment LETRA: [a-zA-Z];` ou declarar palavras-chave de forma case-insensitive consistente.

- `CADEIA: '"' (~["\r\n])* '"';`
  - Problema: não aceita escapes como `\"` dentro de strings.
  - Sugestão: se for necessário suporte a escapes, usar `CADEIA: '"' ( '\\' . | ~["\\\r\n] )* '"' ;`.

---

## Arquivo: [grammar/ProjetoIParser.g4](grammar/ProjetoIParser.g4)

- `decls: VAR listDecl |;`
  - Problema: alternativa vazia escrita de forma menos clara e idiomática.
  - Sugestão: usar `decls: (VAR listDecl)?;` para maior legibilidade.

- `cmdIf` atualmente definido com duas alternativas (com e sem `ELSE`)
  - Problema: duplicação desnecessária.
  - Sugestão: unificar: `cmdIf: IF ABPAR expr FPAR cmdBase (ELSE cmdBase)?;`.

- Observação geral:
  - Prefira manter o lexer simples; regras complexas (validação de intervalo numérico, tamanho máximo de identificador) devem ser tratadas no analisador semântico (`AnalisadorSemantico`) para evitar conflitos léxicos.

---

Se quiser, posso aplicar esses ajustes automaticamente nas gramáticas e ajustar o `AnalisadorSemantico` para validar inteiros fora do intervalo. Deseja que eu faça as correções agora?
---

## Recomendações práticas sobre definição de tokens

- Preferência: manter o lexer simples e mover validações por intervalo para o semântico.

- Exemplo recomendado para inteiros:
  - Lexer: `CTE: DIGITO+;`
  - Semântico: ao visitar `CTE` em `AnalisadorSemantico`, converter `Integer.parseInt(token.getText())` e verificar `<= 32767`; lançar `ErroSemantico` se ultrapassar.

- Remover `ERRO_CTE_2_BYTES` do lexer:
  - Motivo: regra `DIGITO+` conflita com `CTE`; detectar overflow em semântica é mais robusto.

- Fragments por letra:
  - Motivo: fragments individuais A..Z adicionam complexidade e risco de omissão. Use `fragment LETRA: [a-zA-Z];` e trate palavras-chave no parser/semântica comparando `getText().toUpperCase()` se quiser case-insensitive.

- `CADEIA` com escapes (opcional):
  - Use `CADEIA: '"' ( '\\' . | ~["\\\r\n] )* '"' ;` se precisar suportar `\"`.

- `COMMENT` multilinha:
  - Se preferir ser explícito: `COMMENT: '/*' ( . | '\r' | '\n' )*? '*/' -> skip;`.

- Ordem e maior correspondência:
  - Confirme que tokens compostos (`OPREL` com `<=`, `>=`, `OPDIF '<>'`, `OPEQ '=='`) sejam definidos antes de tokens que podem corresponder a seus prefixos isolados. ANTLR segue regra da maior correspondência e, em empate, a primeira definida.

---
