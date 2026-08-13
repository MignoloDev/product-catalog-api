# Product Catalog API

A RESTful API built with Spring Boot for managing a product catalog, featuring `Product` and `Maker` entities with full CRUD operations, a layered architecture, and DTO-based request/response handling.

## 🛠️ Tech Stack

- Java 17
- Spring Boot 3
- Spring Data JPA (Hibernate)
- MySQL
- Lombok
- Maven

## 🏗️ Architecture

The project follows a layered architecture, organized by domain (feature-based packages):

```text
com.practice.app
├── entity
│   ├── Maker.java
│   └── Product.java
├── maker
│   ├── MakerController.java
│   ├── MakerRepository.java
│   ├── MakerService.java
│   ├── MakerServiceImpl.java
│   ├── MakerMapper.java
│   ├── MakerRequestDTO.java
│   └── MakerResponseDTO.java
└── product
    ├── ProductController.java
    ├── ProductRepository.java
    ├── ProductService.java
    ├── ProductServiceImpl.java
    ├── ProductMapper.java
    ├── ProductRequestDTO.java
    └── ProductResponseDTO.java
```

- **Controller**: Exposes REST endpoints, handles HTTP requests/responses.
- **Service / ServiceImpl**: Contains business logic.
- **Repository**: Handles persistence via Spring Data JPA.
- **DTOs**: Separate request/response shapes from the internal entity model.
- **Mapper**: Converts between entities and DTOs.

## 🔗 Entity Relationship

A `Maker` can have many `Products`, and each `Product` belongs to one `Maker` (`@OneToMany` / `@ManyToOne`).

## 📦 Data Model

### Maker

| Field | Type | Notes |
| :--- | :--- | :--- |
| `id` | Long | Auto-generated |
| `name` | String | Required |
| `country` | String | Required |
| `email` | String | Required |
| `phone` | String | Required |

### Product

| Field | Type | Notes |
| :--- | :--- | :--- |
| `id` | Long | Auto-generated |
| `name` | String | Required |
| `price` | BigDecimal | Required |
| `maker` | Maker | Required (`@ManyToOne`) |

## 📡 Endpoints

### Maker

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/makers` | List all makers |
| `GET` | `/makers/{id}` | Get a maker by id |
| `POST` | `/makers` | Create a new maker |
| `PUT` | `/makers/{id}` | Update an existing maker |
| `DELETE` | `/makers/{id}` | Delete a maker |

Request body example (`POST` / `PUT`):

```json
{
  "name": "Test Maker",
  "country": "Argentina",
  "email": "test@test.com",
  "phone": "123456789"
}
```

Response body example:

```json
{
  "id": 1,
  "name": "Test Maker",
  "country": "Argentina",
  "email": "test@test.com",
  "phone": "123456789"
}
```

### Product

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/products` | List all products |
| `GET` | `/products/{id}` | Get a product by id |
| `POST` | `/products` | Create a new product |
| `PUT` | `/products/{id}` | Update an existing product |
| `DELETE` | `/products/{id}` | Delete a product |

Request body example (`POST` / `PUT`):

```json
{
  "name": "Test Product",
  "price": 1500.50,
  "makerId": 1
}
```

Response body example:

```json
{
  "id": 1,
  "name": "Test Product",
  "price": 1500.50,
  "makerName": "Test Maker"
}
```

## 🚀 Getting Started

### Prerequisites

- Java 17+
- Maven
- MySQL running locally

### Configuration

Create an `application.properties` file under `src/main/resources` with your local MySQL connection details:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/app_database?useSSL=false&serverTimezone=UTC
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

> **Note:** This file is not committed to the repository — set it up locally with your own credentials before running the app.

### Running the App

```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`.

## 🗺️ Roadmap

- [ ] Input validation with `@Valid`
- [ ] Global exception handling with `@ControllerAdvice`
- [ ] Pagination and filtering
- [ ] Unit and integration tests
- [ ] API documentation with OpenAPI/Swagger

## 👤 Author

Built as a learning project to practice REST API development with Spring Boot.
