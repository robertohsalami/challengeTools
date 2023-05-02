# ToolsChallenge
ToolsJava Challenge -  API de Pagamentos

**Para subir o projeto:**
 - No banco de dados MySQL criar o banco de dados db_pagamentos
 - Rodar a classe ApiPagamentoApplication
 - Apos rodar a classe, o projeto sobe e automaticamente a tabela pagamento é criada.

**Tecnologias usadas no projeto:**
- Spring Boot
- Java
- Flyway(versionamento e gerenciamento do banco de dados)
- Spring Data JPA
- API REST
- MySQL B.D.

**Endpoints da API:**
 - POST v1/pagamento (cria o pagamento)
 - GET v1/pagamento (consulta todos o pagamentos)
 - GET v1/pagamento/id (consulta pagamento por id da transaçao)
 - PUT v1/pagamento/estorno/id (faz estorno do pagamento por id da transação)
