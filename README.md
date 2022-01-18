# RESTful HR API

This Spring Boot application provides a simple RESTful API that manages Human Resources (HR) records for a company.

## Run Instructions

### Linux:

./mvnw clean install \
./mvnw spring-boot:run

### Windows:

mvnw.cmd clean install \
mvnw.cmd spring-boot:run

## Usage

After starting the application, access the API endpoints at http://localhost:8080.

For API documentation, see: \
https://docs.google.com/document/d/1Pdb6ONRXRssUZAfq05aFORu3m-aG44MBhQEOS2EKKaM/edit?usp=sharing

## Database

Access the H2 console at http://localhost:8080/h2.

Driver: org.h2.Driver \
JDBC URL: jdbc:h2:mem:mydb \
User Name: sa \
Password:
