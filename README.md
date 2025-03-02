# Observability in Spring Boot

This repository provides an example of implementing observability in a Spring Boot application. Observability enables monitoring and understanding the internal state of a system by collecting and analyzing logs, metrics, and traces.

## Features

- **Spring Boot Application**: Demonstrates observability practices within a Spring Boot framework.
- **Docker Compose Integration**: Orchestrates services, including the application and observability tools, using Docker Compose.
- **PostgreSQL Database**: Integrates with a PostgreSQL database for data persistence.
- **Zipkin for Distributed Tracing**: Implements Zipkin to collect and visualize trace data, aiding in performance monitoring and troubleshooting.
- **MapStruct for Object Mapping**: Utilizes MapStruct for efficient and type-safe object mapping between DTOs and entities.
- **Spring Security**: Secures application endpoints using Spring Security.
- **Swagger/OpenAPI Documentation**: Provides interactive API documentation with Swagger UI.

## Prerequisites

Ensure you have the following installed:

- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/install/)
- [Java Development Kit (JDK) 11 or higher](https://adoptopenjdk.net/)
- [Maven](https://maven.apache.org/install.html)

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/youssefGamalMohamed/observability-spring-boot.git
cd observability-spring-boot
```

### Build the Application

```bash
./mvnw clean install
```

### Start Services with Docker Compose

```bash
docker-compose up
```

This command will start the Spring Boot application, PostgreSQL database, and Zipkin for tracing.

### Access the Application

- **Application Endpoint**: `http://localhost:8080`
- **Swagger UI**: `http://localhost:8080/swagger-ui.html`
- **Zipkin Dashboard**: `http://localhost:9411`

## Observability Components

- **Metrics**: Exposed via Spring Boot Actuator at `http://localhost:8080/actuator/metrics`.
- **Health Checks**: Available at `http://localhost:8080/actuator/health`.
- **Distributed Tracing**: Visualize traces using the Zipkin dashboard at `http://localhost:9411`.

## Security

The application uses Spring Security to protect endpoints. Configure security settings in the `application.yml` file.

## API Documentation

Interactive API documentation is available through Swagger UI at `http://localhost:8080/swagger-ui.html`.

## Additional Resources

For further reading on observability in Spring Boot, consider exploring the following resources:

- [Spring Boot Actuator: Production-ready Features](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html)
- [Micrometer: Application Metrics Facade](https://micrometer.io/)
- [Zipkin: Distributed Tracing System](https://zipkin.io/)

