# Desafio Jaya Micronaut 
[Swagger/OpenAPI](https://desafio-jaya-micronaut.herokuapp.com/swagger-ui)

---

### Propósito: 
 Este projeto tem como objetivo realizar um estudo e aprendizagem do framework Micronaut. Para atingir esse objetivo, utilizei o [Desafio Jaya](https://github.com/achimid/desafio-jaya-micronaut/blob/2b9d69d32ace3a5729322595324fad5def944e40/documentation/Developer%20Test%20v6.0.pdf) para implementar essa base de código.

---

### Features:
- Java 11
- Micronaut (Data, Validation, Core)
- H2 Database (Embedded)
- Swagger/OpenAPI
- Cache Caffeine
- MapStruct
- Lombok
- JUnit
---
### Motivação das principais escolhas de tecnologias:
- Micronaut (Data, Validation, Core)
  * Esse framework foi escolhido com o objetivo de aprendizado.
- H2 Database (Embedded)
  * Por se tratar de um desafio que será entregue em prod, e pela facilidade de criação, utilizei o esse banco de dados em memória embedded.
- Cache Caffeine
  * Escolhido pela facilidade de integração com o framework
- MapStruct
  * Permite a separação e isolamento dos dominios e contrução dos objetos imutaveis.
- Lombok
  * Escolhido pois facilita o desenvolvimento e aumenta a produtividade do desenvolvimento com linguagem Java. Obs: Tomar os devidos cuidados com a geração de código.

---
## Aplicação hospedada no Heroku

Endpoint para utilização: https://desafio-jaya-micronaut.herokuapp.com/api/v1/exchange?userId=123

Endereço da documentação: https://desafio-jaya-micronaut.herokuapp.com/swagger-ui

---
## Como rodar a aplicação

Executar via docker:

``` docker run -p 8080:8080 achimid/desafio-jaya-micronaut:latest ```

Executar via gradle:

``` ./gradlew run ```

---
## Pipeline

A pipeline esta configura utilizando Github Actions: 
https://github.com/achimid/desafio-jaya-micronaut/actions

Steps: Checkstyle -> Test -> Build

---
### Micronaut 3.5.3 Documentation

- [User Guide](https://docs.micronaut.io/3.5.3/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.5.3/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.5.3/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)

#### Feature swagger-ui documentation
- [Shadow Gradle Plugin](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)

#### Feature swagger-ui documentation
- [Micronaut Swagger UI documentation](https://micronaut-projects.github.io/micronaut-openapi/latest/guide/index.html)
- [https://swagger.io/tools/swagger-ui/](https://swagger.io/tools/swagger-ui/)

#### Feature jdbc-hikari documentation
- [Micronaut Hikari JDBC Connection Pool documentation](https://micronaut-projects.github.io/micronaut-sql/latest/guide/index.html#jdbc)

#### Feature http-client documentation 
 - [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)

#### Feature lombok documentation
- [Micronaut Project Lombok documentation](https://docs.micronaut.io/latest/guide/index.html#lombok)
- [https://projectlombok.org/features/all](https://projectlombok.org/features/all)

#### Feature openapi documentation
- [Micronaut OpenAPI Support documentation](https://micronaut-projects.github.io/micronaut-openapi/latest/guide/index.html)
- [https://www.openapis.org](https://www.openapis.org)
