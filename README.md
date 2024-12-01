# Teste de Caixa Branca (Estático) - Apontamento de Falhas

**Feito por:** Kauê Vinicius Alchapal

## **Erros Encontrados**

### **1. Conexão ao Banco de Dados**
- O método `conectarBD` não lida adequadamente com falhas de conexão.
- A string de conexão expõe credenciais sensíveis diretamente no código, o que representa um risco de segurança.

### **2. Vulnerabilidade a SQL Injection**
- A consulta SQL no método `verificarUsuario` concatena diretamente os valores de entrada `login` e `senha`, o que deixa o sistema suscetível a ataques de injeção de SQL.

### **3. Tratamento de Exceções**
- Os blocos `catch` estão vazios, dificultando a depuração de erros e o monitoramento do sistema.

### **4. Nome da Classe**
- A classe `User` possui um nome genérico. Um nome mais específico, como `UserAuthentication`, seria mais adequado.

### **5. Recursos não fechados**
- Objetos como `Connection`, `Statement` e `ResultSet` não são fechados corretamente após o uso, o que pode levar a vazamentos de recursos.



## **Melhorias/Alterações necessárias após análise**

- Substituir a concatenação direta de valores, talvez por **Prepared Statements** para evitar vulnerabilidades de SQL Injection.
- Implementar o fechamento adequado de recursos no bloco `finally` ou usar a estrutura **try-with-resources**.
- Adicionar logs aos blocos `catch` para capturar erros e facilitar a depuração.
- Armazenar as credenciais em variáveis de ambiente ou em um arquivo de configuração seguro para evitar exposição.

-

## **Grafo de Fluxo**
- O grafo foi criado para demonstrar o método `verificarUsuario`, que é parte crítica do sistema.  
(Adicione aqui a imagem do grafo, localizada na pasta do projeto, ou insira uma descrição do grafo caso necessário)




## **Complexidade Ciclomática**

A **complexidade ciclomática** do código foi calculada com a fórmula:  
**M = E - N + 2P**

Onde:
- **E** = Número de arestas: 8  
- **N** = Número de nós: 8  
- **P** = Número de componentes conectados: 1  

**Resultado:**  
A complexidade é **3**, indicando que existem **3 caminhos básicos independentes** no código.

---

## **Caminhos Básicos Identificados**
### **Caminho 1**
- Sequência: `1 → 2 → 3 → 4 → 5 → 6 → 7 → 8`  
- Descrição: Resultado encontrado no banco de dados e processado com sucesso.

### **Caminho 2**
- Sequência: `1 → 2 → 3 → 4 → 5 → 8`  
- Descrição: Resultado inexistente no banco de dados.

### **Caminho 3**
- Sequência: `1 → 2 → 3 → 4 → 8`  
- Descrição: Ocorre uma falha ou exceção durante a execução da consulta.






