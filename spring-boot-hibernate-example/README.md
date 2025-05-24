# Spring Boot Hibernate Example

## Overview
This project demonstrates how to integrate Hibernate ORM (without JPA) in a Spring Boot application with MySQL database using C3P0 connection pooling.

## Features
- Hibernate native API usage (no JPA)
- MySQL database integration
- C3P0 connection pooling configuration
- XML-based Hibernate configuration and mapping (`hibernate.cfg.xml`, `customer.hbm.xml`)
- Basic CRUD operations support (you can extend)
- Java 21 compatibility
- SQL logging enabled for debugging

## Technologies Used
- Java 21
- Spring Boot 3.2.5
- Hibernate 6.5.2 (core)
- MySQL 8+
- C3P0 0.9.5.5 (connection pooling)
- Maven for build and dependency management
- Lombok (provided scope)

## Prerequisites
- Java 21 installed
- Maven installed
- MySQL server running with a database named `foodorder`
- Database user `root` with password `root` (update properties if different)

## Configuration
- `src/main/resources/hibernate.cfg.xml` - Hibernate core configuration (database connection, dialect, pooling)
- `src/main/resources/customer.hbm.xml` - Hibernate mapping file for `Customer` entity

**Important:**  
Remove `hibernate.connection.provider_class` from configuration to avoid connection provider resolution errors.

## Build and Run

1. Clone the repository:
   ```bash
    git clone https://github.com/shreyamahalle/hibernate-examples.git
    cd spring-boot-hibernate-example
   ```
## Build the project:
   ```bash
     mvn clean install
   ```
## Run the Spring Boot application:
   ```bash
      mvn spring-boot:run
   ```
## Project Structure
```properties
src/
├── main/
│   ├── java/com/shreya/hibernate/       # Java source code
│   ├── resources/
│   │   ├── hibernate.cfg.xml            # Hibernate configuration
│   │   ├── customer.hbm.xml             # Hibernate mapping file
│   │   └── application.properties       # Spring Boot properties (optional)
└── test/                               # Test cases
```
## Sample JSON (customer.json)
```bash
    {
      "id": 1,
      "firstName": "Shreya",
      "lastName": "Patil",
      "email": "shreya@example.com",
      "createdTime": "2025-05-24",
      "updatedTime": "2025-05-24"
     }
```
## Sample cURL Command to POST
   ```bash
   curl -X POST http://localhost:8080/customers \
  -H "Content-Type: application/json" \
  -d '{
    "id": 1,
    "firstName": "Shreya",
    "lastName": "Patil",
    "email": "shreya@example.com",
    "createdTime": "2025-05-24",
    "updatedTime": "2025-05-24"
  }'
```
## Get All Customers (GET)
```bash
    curl -X GET http://localhost:8080/customers
```

##  Get Customer by ID (GET)
```bash
    curl -X GET http://localhost:8080/customers/1
```
## Update Customer (PUT)
```bash
   curl -X PUT http://localhost:8080/customers/1 \
    -H "Content-Type: application/json" \
    -d '{
    "id": 1,
    "firstName": "ShreyaUpdated",
    "lastName": "PatilUpdated",
    "email": "shreya_updated@example.com",
    "createdTime": "2025-05-24",
    "updatedTime": "2025-05-25"
  }
```
##  Delete Customer by ID (DELETE)
```bash
    curl -X DELETE http://localhost:8080/customers/1
```
## Notes
- This project uses native Hibernate APIs with XML configuration, not Spring Data JPA.

- C3P0 is configured via hibernate.c3p0.* properties for connection pooling.

- You can extend entities and DAO classes as needed.

- Ensure MySQL driver version and dialect match your database version.

## Troubleshooting
- If you encounter Unable to resolve name org.hibernate.engine.jdbc.connections.internal.C3P0ConnectionProvider, remove the hibernate.connection.provider_class property from hibernate.cfg.xml.

- Check your database credentials and MySQL server status.

- Verify Maven dependencies include hibernate-core and c3p0.