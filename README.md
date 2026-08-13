Product Catalog APIA robust RESTful API built with Spring Boot for managing a product catalog. It features full CRUD operations for Product and Maker entities, built upon a clean, layered architecture with DTO-based request and response handling.🛠️ Tech StackLanguage: Java 17Framework: Spring Boot 3Persistence: Spring Data JPA (Hibernate)Database: MySQLBuild Tool: MavenUtilities: Lombok🏗️ ArchitectureThe project follows a domain-driven, feature-based layered architecture:Plaintextcom.practice.app
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
Layer ResponsibilitiesController: Exposes RESTful endpoints and manages HTTP requests/responses.Service / ServiceImpl: Encapsulates core business logic.Repository: Manages database interaction via Spring Data JPA interfaces.DTOs: Decouples internal entity models from external API contracts.Mapper: Converts between entities and DTO objects.🔗 Entity RelationshipA Maker can have multiple Products, while each Product is associated with exactly one Maker (@OneToMany / @ManyToOne).┌───────────┐         1 : N         ┌───────────┐
│   Maker   │ ─────────────────────> │  Product  │
└───────────┘                       └───────────┘
📦 Data ModelMaker EntityFieldTypeConstraints / NotesidLongPrimary Key, Auto-generatednameStringRequiredcountryStringRequiredemailStringRequiredphoneStringRequiredProduct EntityFieldTypeConstraints / NotesidLongPrimary Key, Auto-generatednameStringRequiredpriceBigDecimalRequiredmakerMakerRequired (@ManyToOne)📡 API Endpoints🏢 Maker EndpointsMethodEndpointDescriptionGET/makersRetrieve all makersGET/makers/{id}Retrieve a specific maker by IDPOST/makersCreate a new makerPUT/makers/{id}Update an existing makerDELETE/makers/{id}Delete a makerRequest Payload (POST / PUT)JSON{
  "name": "Test Maker",
  "country": "Argentina",
  "email": "test@test.com",
  "phone": "123456789"
}
Response Payload (200 OK / 201 Created)JSON{
  "id": 1,
  "name": "Test Maker",
  "country": "Argentina",
  "email": "test@test.com",
  "phone": "123456789"
}
📦 Product EndpointsMethodEndpointDescriptionGET/productsRetrieve all productsGET/products/{id}Retrieve a specific product by IDPOST/productsCreate a new productPUT/products/{id}Update an existing productDELETE/products/{id}Delete a productRequest Payload (POST / PUT)JSON{
  "name": "Test Product",
  "price": 1500.50,
  "makerId": 1
}
Response Payload (200 OK / 201 Created)JSON{
  "id": 1,
  "name": "Test Product",
  "price": 1500.50,
  "makerName": "Test Maker"
}
🚀 Getting StartedPrerequisitesJava 17 or higher installedMaven 3.8+MySQL database instance running locallyConfigurationCreate an application.properties file in src/main/resources/:Propertiesspring.datasource.url=jdbc:mysql://localhost:3306/app_database?useSSL=false&serverTimezone=UTC
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
⚠️ Note: Ensure database credentials are excluded from version control (checked in .gitignore).Running the ApplicationClone the repository and navigate to the project root:Bashgit clone <repository-url>
cd product-catalog-api
Build and run using Maven:Bashmvn spring-boot:run
The server will start locally at:http://localhost:8080🗺️ Roadmap[ ] Add input validation (jakarta.validation / @Valid)[ ] Implement global exception handling (@ControllerAdvice)[ ] Add pagination, sorting, and filtering support[ ] Integrate unit tests (JUnit 5, Mockito) and integration tests[ ] Generate interactive API documentation via OpenAPI/Swagger UI👤 AuthorDeveloped as a practice project to demonstrate RESTful API design patterns with Spring Boot.
