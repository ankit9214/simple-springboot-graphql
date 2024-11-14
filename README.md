# Spring Boot Simple GraphQL API

This project is a simple Spring Boot application that demonstrates a GraphQL API for managing books. The API includes querying all books, querying a book by ID, and adding a new book to the in-memory database.

## Project Structure

The key files in this project are as follows:

- **Book.java**: Entity class that defines the `Book` model with fields `id`, `title`, and `author`.
- **BookRepository.java**: Repository interface that extends `JpaRepository` to perform CRUD operations on `Book` entities.
- **BookResolver.java**: GraphQL resolver class containing the GraphQL queries and mutations.
- **schema.graphqls**: Defines the GraphQL schema for `Book` queries and mutations.
- **DemoApplication.java**: Main application class to run the Spring Boot application.
- **application.properties**: Configuration file to set up an H2 in-memory database and enable the GraphQL API endpoint.

## Getting Started

### Prerequisites

- **Java 17** or higher
- **Maven** for dependency management
- **Spring Boot 3.0** or later

### Setting Up the Project

1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   cd <repository-directory>

2. **Run the Application**:
Use Maven to build and run the application.
    ```bash
   mvn spring-boot:run

3. **Access the H2 Console**:
The H2 in-memory database is enabled by default. Access the console at:
    ```bash
   http://localhost:8080/h2-console

- JDBC URL: jdbc:h2:mem:testdb 
- Username: sa
- Password: password

4. **Access the GraphQL Playground**:
Access the GraphQL API at the following endpoint:
    ```bash
    http://localhost:8080/graphql
   
### GraphQL Schema


The GraphQL schema for this application is defined in schema.graphqls:

    type Book {
    id: ID!
    title: String!
    author: String!
    }

    type Query {
    books: [Book]
    book(id: ID!): Book
    }

    type Mutation {
    createBook(title: String!, author: String!): Book
    }

### Available GraphQL Queries and Mutations

#### Queries
1. Get All Books
    ```graphql
    query {
        books {
            id
            title
            author
        }
    }

2. Get Book by ID
    ```graphql
    query($id: ID!) {
        book(id: $id) {
            id
            title
            author
        }
    }

### Mutations
1. Create a New Book
    ```graphql
    mutation($title: String!, $author: String!) {
         createBook(title: $title, author: $author) {
             id
             title
             author
         }
    }


### Project Configuration

The application.properties file configures the following:
- spring.datasource.url: Sets up an H2 in-memory database for testing.
- spring.h2.console.enabled: Enables access to the H2 console at /h2-console.
- spring.graphql.path: Configures the GraphQL endpoint path to /graphql.

### Technologies Used
- Java: Programming language 
- Spring Boot: Framework for building Java applications 
- Spring Data JPA: For data persistence 
- GraphQL: For API query and mutation capabilities 
- H2 Database: In-memory database for testing
