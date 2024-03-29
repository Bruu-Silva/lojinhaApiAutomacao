# Lojinha API Automação
Este é um repositório que contém a automação de alguns testes de API Rest de um software denominado "Lojinha". Os subtópicos abaixo descrevem algumas decisões tomadas na estruturação do projeto.

## Tecnologias Utilizadas


- Java
  https://www.oracle.com/java/technologies/javase/jdk19-archive-downloads.html
- JUnit
  https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.8.0
- RestAssured
  https://mvnrepository.com/artifact/io.rest-assured/rest-assured/4.4.0
- Maven
  https://maven.apache.org

## Testes Automatizados
Testes para validar as partições de equivalência relacionadas ao valor do produto na lojinha, que estão vinculados diretamente à regra de negócio que diz que o valor do produto deve estar entre R$ 0,01 e R$ 7.000,00.

## Notas Gerais

-   Sempre utilizamos a anotação "Before Each" para capturar o token que será utilizado posteriormente nos métodos de teste.
-   Armazenamos os dados que são enviados para a API através do uso de classes POJO.
-   Criamos dados iniciais através do uso da classe Data Factory, para facilitar a criação e controle dos mesmos.
-   Neste projeto, fazemos uso do JUnit 5, o que nos dá a possibilidade de usar a anotação "DisplayName" para dar descrições em português para nosso teste.