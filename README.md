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
git clone https://github.com/Elyson2k/Attornatus-Test.git/
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
mvn spring-boot:run -Demail.username=<seu_email> -Demail.password=<sua_senha_email>
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
- **junit**: Ferramenta para testes unitários.
- **flyway**: Ferramenta para ter o controle do banco de dados

## PADROES DE PROJETO UTILIZADOS
- [Builder](https://refactoring.guru/design-patterns/builder)

## TECNICAS UTILIZADAS
### → ENVIO DE EMAIL

Foi criado um mecanismo para envio de email para confirmação da conta do usuário. A ideia é que se o sistema tivesse um login por exemplo, conseguiriamos evitar que o usuário logue no sistema sem ter confirmado a conta. Para fazer isso, foi adicionado a tabela de usuário dois campos: confirmationToken e accountVerified. Esses dois campos servem para salvar o token de confirmação(UUID) e saber se um usuário tem conta confirmada ou não, respectivamente. 

Foi usado o JavaMailSender para envio de email.

Para fazer a validação do email nós enviamos um email para o email recebido no body de cadastro, para que o o usuário possa confirmar a conta via email. 

**OBS: Essa confirmação de email só serve na maquina que o API estiver rodando, pelo fato do link ser enviado em localhost, caso tivesse um servidor, colocaria o host do servidor para poder confirmar o email.**

### → REQUEST-ID NO LOG
Foi adicionado um mecanismo para adicionar um request-id em todos os requests da aplicação, para que possa ser facilmente rastreavel via logs.

Foi usado o seguinte mecanismo:
![image](https://user-images.githubusercontent.com/104575935/211159955-90d9c8cc-a5a7-4cb8-a1f0-4e3a4316732f.png)

Criado uma classe de configuração de Log e extendido de OncePerRequestFilter. Quando extendido, sou obrigado a implementar a função doFilterInternal, o que será executado apenas uma vez a cada requisição. Então, usei uma ferramente para adicionar um request-id de um UUID randomico a cada requisição.

Exemplo do resultado: 
![image](https://user-images.githubusercontent.com/104575935/211160372-a858a7cc-0fae-41fc-a42d-14c84df13d59.png)


## VIDEO DE DEMOSTRAÇÃO

https://user-images.githubusercontent.com/104575935/211153342-3288eac5-6259-4f4a-a443-bff10c179616.mp4


