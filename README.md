# Wellness360 Task Management REST API

A RESTful Task Management API built using Spring Boot as part of the Wellness360 Full Stack Java Developer case study.

This application allows users to create, retrieve, update, delete, and manage tasks efficiently through REST APIs. The project follows a layered architecture approach using Controller, Service, Repository, and DTO layers.

---

# Features

- Create a new task
- Retrieve all tasks
- Retrieve task by ID
- Update existing task
- Delete task
- Mark task as completed
- Input validation using Hibernate Validator
- Global exception handling
- Swagger/OpenAPI documentation
- Spring Security Basic Authentication
- Unit testing using JUnit and Mockito
- H2 in-memory database integration

---

# Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- Hibernate Validator
- H2 Database
- Swagger / OpenAPI
- JUnit 5
- Mockito
- Maven

---

# Project Architecture

The project follows a layered architecture:

Controller Layer  
↓  
Service Layer  
↓  
Repository Layer  
↓  
H2 Database

## Layer Responsibilities

### Controller Layer
Handles incoming HTTP requests and returns API responses.

### Service Layer
Contains business logic and interacts with the repository layer.

### Repository Layer
Communicates with the database using Spring Data JPA.

### DTO Layer
Used for request and response data transfer between client and server.

---

# API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/tasks` | Create a new task |
| GET | `/tasks` | Retrieve all tasks |
| GET | `/tasks/{id}` | Retrieve task by ID |
| PUT | `/tasks/{id}` | Update existing task |
| DELETE | `/tasks/{id}` | Delete task |
| PATCH | `/tasks/{id}/complete` | Mark task as completed |

---

# Task Entity Fields

| Field | Type |
|---|---|
| id | Long |
| title | String |
| description | String |
| dueDate | LocalDate |
| status | Enum |
| createdAt | LocalDateTime |
| updatedAt | LocalDateTime |

---

# Task Status Enum Values

- PENDING
- IN_PROGRESS
- COMPLETED

---

# Authentication

This project uses Spring Security Basic Authentication.

## Credentials
- Username: `admin`
- Password: `admin123`


# Swagger Documentation

## Swagger UI URL

http://localhost:8080/swagger-ui/index.html

## OpenAPI Docs

http://localhost:8080/v3/api-docs

Swagger provides interactive API documentation and allows testing APIs directly from the browser.



# H2 Database Console

## H2 Console URL

http://localhost:8080/h2-console

## H2 Database Configuration

| Property | Value |
|---|---|
| JDBC URL | jdbc:h2:mem:testdb |
| Username | sa |
| Password | (empty) |

---

# Validation & Exception Handling

Implemented validation using:

- @NotBlank
- @NotNull

Global exception handling is implemented using `@RestControllerAdvice`.

## Example Validation Response

```json
{
  "title": "Title is required"
}
```


# Unit Testing

Unit testing is implemented for the Service Layer using:

- JUnit 5
- Mockito

## Tested Functionality

- createTask() service method

Mockito is used to mock repository interactions and isolate business logic during testing.

---

# Sample Request Body

## Create Task

```json
{
  "title": "Learn Spring Boot",
  "description": "Practice REST APIs",
  "dueDate": "2026-05-20",
  "status": "PENDING"
}
```

---

# Sample Response

```json
{
  "id": 1,
  "title": "Learn Spring Boot",
  "description": "Practice REST APIs",
  "dueDate": "2026-05-20",
  "status": "PENDING",
  "createdAt": "2026-05-12T10:20:30",
  "updatedAt": "2026-05-12T10:20:30"
}
```

---

# Security Configuration

Implemented using Spring Security with:

- InMemoryUserDetailsManager
- SecurityFilterChain
- HTTP Basic Authentication

CSRF protection is disabled for REST API testing using Postman and Swagger.

---

# How To Run The Application

## Clone Repository

```bash
git clone https://github.com/Rakeshmunukuntla/wellness360-task-manager-api.git
```

## Navigate To Project

```bash
cd wellness360-task-manager-api
```

## Build Project

```bash
mvn clean install
```

## Run Application

```bash
mvn spring-boot:run
```

---

# Application URLs

| Tool | URL |
|---|---|
| Swagger UI | http://localhost:8080/swagger-ui/index.html |
| H2 Console | http://localhost:8080/h2-console |
| API Base URL | http://localhost:8080/tasks |

---

# Future Improvements

- JWT Authentication
- Role-based Authorization
- MySQL/PostgreSQL Integration
- Docker Containerization
- Pagination and Sorting
- API Rate Limiting



---

# Author

Rakesh Munukuntla

Java Full Stack Developer
