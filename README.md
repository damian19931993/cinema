# Cinema Microservice

A microservice for running a cinema application. It provides an api to fetch the current movie listings from an external API (TheMovieDB).

## Features

- It fetches the current movie listings from an external API.
- Architecture based on Domain-Driven Design (DDD).
- WebClient to get external HTTP resources.
- Centralized error handling.
- Secrets and urls are managed in application.yml

## Techonologies

- Java 21
- Spring Boot 3.5.3
- Spring WebFlux (WebClient)
- Jackson (JSON)
- SLF4J (logging)

## Prerequisites

- JDK 21
- Maven 3.6+
- API Key de TheMovieDB (o la API pública que prefieras)

