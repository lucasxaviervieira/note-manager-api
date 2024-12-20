# Note Manager API

RESTful API with Spring Boot to make a basic CRUD for studies.

## Run project

To run this project you will need a PostgreSQL server, on `resources/application.properties` change config to your server.

example:

```text
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=123
```

## Features

- CRUD operations
- DB integration
- JWT-based Authentication & Authorization
- Layered Architecture

## Future Enhancements (Ideas)

- Ensure users can only view, edit, or delete their own notes using JWT claims.
- Allow users to search for notes by title or description.
- Add a deleted flag to avoid permanently deleting notes.
- Use a global exception handler to standardize error messages.

## Tech

- [Maven](https://mvnrepository.com/)

  Followed by his projects:

  - [Spring Boot](https://spring.io/projects/spring-boot)

    and their projects:

    - Spring Boot Data JPA
    - Spring Boot Security
    - Spring Boot Web
    - Spring Boot Test
    - Spring Boot DevTools

  - [Project Lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok)

  - [Java JWT](https://mvnrepository.com/artifact/com.auth0/java-jwt/3.3.0)

  - [Jakarta Validation](https://mvnrepository.com/artifact/jakarta.validation/jakarta.validation-api)

  - [PostgreSQL JDBC Driver](https://mvnrepository.com/artifact/org.postgresql/postgresql)
