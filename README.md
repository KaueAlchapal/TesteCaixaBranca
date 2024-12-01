# Teste de Caixa Branca (Estático) - Apontamento de falhas

-- O Projeto está setado na branch Master do Reposiório -- 

Erros Encontrados

1. **Conexão ao Banco de Dados**
   - Método `conectarBD` não trata adequadamente falhas de conexão.
   - String de conexão expõe credenciais sensíveis no código.

2. **Falha de segurança no SQL Injection**
   - Consulta SQL no método `verificarUsuario` concatena diretamente os valores `login` e `senha`, expondo o banco a ataques.

3. **Tratamento de Exceções**
   - Blocos `catch` estão vazios, dificultando ver erros.

4. **Nome da Classe**
   - `User` pode ser ambíguo. Um nome mais específico é preferível, como `UserAuthentication`.

5. **Recursos não fechados**
   - `Connection`, `Statement` e `ResultSet` não são fechados após uso, causando vazamentos de recursos.


Melhorias/Alterações necessárias após análise: 
- Usar, talvez, Prepared Statements para evitar SQL Injection.
- Fechar os recursos no bloco `finally` ou usar `try-with-resources`.
- Implementar logs nos blocos `catch`.
- Armazenar credenciais em variáveis de ambiente ou arquivos de configuração seguros.
