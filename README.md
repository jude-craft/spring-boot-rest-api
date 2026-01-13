# Student Management API

A Spring Boot REST API for managing student information, built with modern Java technologies and best practices.

## Overview

This project demonstrates a clean, scalable architecture for a student management system using Spring Boot. It provides RESTful endpoints to retrieve student data with features like dependency injection, JPA persistence, and PostgreSQL integration.

## Features

- **REST API** - Clean REST endpoints for student operations
- **JPA & Hibernate** - Object-relational mapping with automatic entity management
- **PostgreSQL Database** - Persistent data storage
- **Dependency Injection** - Spring's IoC container for loose coupling
- **Service Layer Pattern** - Separation of concerns with service and repository layers
- **JSON Serialization** - Ordered JSON property output for consistent API responses
- **Sequence Generators** - Database sequence-based ID generation

## Tech Stack

- **Java 25**
- **Spring Boot 4.0.0**
- **Spring Data JPA**
- **PostgreSQL**
- **Maven** - Build and dependency management

## Project Structure

```
src/
├── main/
│   ├── java/com/example/demo/
│   │   ├── DemoApplication.java          # Application entry point
│   │   └── student/
│   │       ├── Student.java              # Student entity model
│   │       ├── StudentController.java    # REST controller
│   │       ├── StudentService.java       # Business logic
│   │       ├── StudentRepository.java    # Data access layer
│   │       └── StudentConfig.java        # Configuration
│   └── resources/
│       └── application.properties        # Application configuration
└── test/
    └── java/com/example/demo/
        └── DemoApplicationTests.java     # Unit tests
```

## API Endpoints

### Get All Students

```
GET /api/v1/student
```

Returns a list of all students in JSON format with the following structure:

```json
[
  {
    "id": 1,
    "name": "John Williams",
    "email": "john@example.com",
    "dob": "2000-05-15",
    "age": 26
  }
]
```

## Getting Started

### Prerequisites

- Java 25 or higher
- Maven 3.6+
- PostgreSQL 12+

### Installation

1. **Clone the repository**

   ```bash
   git clone https://github.com/jude-craft/spring-boot-rest-api.git
   cd demo
   ```

2. **Configure PostgreSQL**

   Update `src/main/resources/application.properties` with your database credentials:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/student_db
   spring.datasource.username=postgres
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=create-drop
   ```

3. **Build the project**

   ```bash
   ./mvnw clean install
   ```

4. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```

The API will be available at `http://localhost:8080/api/v1/student`

## Architecture

### Student Entity

The `Student` class represents a student record with:

- **id** - Auto-generated primary key using database sequences
- **name** - Student's full name
- **email** - Student's email address
- **dob** - Date of birth
- **age** - Calculated age (transient, not persisted)

### StudentController

RESTful endpoint handler that:

- Maps to `/api/v1/student`
- Injects `StudentService` via constructor injection
- Provides endpoints for student operations

### StudentService

Business logic layer that:

- Handles student-related operations
- Communicates with the repository layer
- Implements service patterns

### StudentRepository

Data access layer using Spring Data JPA:

- Provides CRUD operations
- Extends `JpaRepository` for automatic query methods
- Communicates with PostgreSQL

## Testing

Run the test suite:

```bash
./mvnw test
```

## Configuration

### Database Configuration

Configure database connection in `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/student_db
spring.datasource.username=postgres
spring.datasource.password=your_password
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQL10Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Development

### Build

```bash
./mvnw clean package
```

### Run in Development Mode

```bash
./mvnw spring-boot:run
```

### View Maven Dependency Tree

```bash
./mvnw dependency:tree
```

## License

This project is provided as-is for educational purposes.

## Author

Jude-craft
