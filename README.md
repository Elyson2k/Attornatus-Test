# DESAFIO BACKEND JAVA PARA ELOWARE

## ➤ DESAFIO JAVA

### ↠ Crie uma API simples usando spring para gerenciar PESSOAS. Esta API deve permitir:

· Criar uma pessoa

· Editar uma pessoa

· Consultar uma pessoa

· Listar pessoas

· Criar endereço para pessoa

· Listar endereços da pessoa

· Poder informar qual endereço é o principal da pessoa

## ➤ CAMPOS OBRIGATORIO:

· Nome

· Data de nascimento

· Endereço:

o Logradouro

o CEP

o Número

o Cidade

## ➤ REQUISITOS:

· Todas as respostas da API devem ser JSON

· Banco de dados H2

## ➤ DIFERENCIAL:

· Testes

· Clean Code

## ➤ SERÁ LEVADO EM AVALIAÇÃO:

· Estrutura, arquitetura e organização do projeto

· Boas práticas de programação

· Alcance dos objetivos propostos.
 
## ➤ GETTING STARTED

### → Passo 1:

Fazer um clone do projeto:

```text
git clone https://github.com/Elyson2k/finch-estagio.git
```

Isso fará com que o banco de dados da aplicação rode em um container Docker.

### → Passo 2: 
Baixe/Atualize as bibliotecas do projeto com Maven:

```text
mvn clean install
```

### → Passo 3: 
Rodar testes da aplicação:

```text
mvn test
```

### → Passo 4:
Rode a aplicação pelo pelo IntelliJ, ou use o seguinte comando:

```text
mvn spring-boot:run
```

### → Passo 5:
A documentação Swagger OpenApi da aplicação estará disponivel em:
```text
http://localhost:8080/swagger-ui/index.html
```

## FERRAMENTAS UTILIZADAS
- **springdoc-openapi-ui**: Para fazer documentação com Swagger.
- **com.h2database**: Banco de dados em memória, para testes iniciais e para testes da aplicação.
- **spring-boot-starter-web**: Biblioteca básica que faz com que minha aplicação tenha um servidor embutido do tomcat e também da várias classes uteis para desenvolvimentop da minha aplicação Web.
- **spring-boot-starter-jpa**: Biblioteca básica que faz com que minha aplicação possa fazer as relações das classes.
- **spring-boot-starter-sleuth**: Biblioteca basica que serve para fazer ID's de LOGGERs.
- **junit**: Ferramenta para testes unitários.
- **flyway**: Ferramenta para ter o controle do banco de dados

## VIDEO DE DEMOSTRAÇÃO
### OBS: PARA O ENVIO DE EMAIL FUNCIONAR, BASTA INSERIR OS CAMPOS NO "EMAILSERVICE E EMAILCONFIG"




https://user-images.githubusercontent.com/104575935/211153342-3288eac5-6259-4f4a-a443-bff10c179616.mp4


