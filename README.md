# CMS - Contractor Management Service
 
## Project Overview
 
CMS (Contractor Management Service) is a Spring Boot REST API developed to manage contractor information.
 
CMS communicates with the Employee Management Service (PMS) using REST APIs.
 
It acts as a separate microservice that forwards contractor management requests to PMS.
 
## Technologies Used
 
- Java 25
- Spring Boot
- Maven
- Spring Web
- REST APIs
- JSON
- IntelliJ IDEA
- Postman
- Git and GitHub
 
## Project Architecture
 
CMS follows a layered architecture:
 
Client → CMS Controller → CMS Service → PMS REST API → H2 Database
 
### Controller Layer
 
Handles incoming HTTP requests for contractor management.
 
### Service Layer
 
Contains contractor management logic and communicates with PMS using HTTP requests.
 
### DTO Layer
 
Uses Data Transfer Objects (DTOs) to exchange contractor information between services.
 
### Exception Handling
 
Handles API errors and returns appropriate HTTP status codes.
 
## Microservices Communication
 
CMS communicates with PMS through REST APIs.
 
### Communication Flow
 
1. A client sends a request to CMS.
2. CMS processes the request.
3. CMS forwards the request to PMS.
4. PMS performs the required operation.
5. PMS returns a response to CMS.
6. CMS returns the result to the client.
 
## Contractor Fields
 
Each contractor record contains:
 
- ID
- Name
- Email
- Department
- Salary
- Employee Type
 
Contractors use the employee type:
 
CONTRACTOR
 
## Features
 
### Contractor Management
 
- Create contractors
- Retrieve contractor details
- Retrieve all contractors
- Update contractor information
- Delete contractors
 
### Validation
 
- Validates contractor information
- Handles duplicate email addresses
- Returns appropriate validation errors
 
### Exception Handling
 
- 400 Bad Request for invalid input
- 404 Not Found for missing contractors
- 409 Conflict for duplicate email addresses
 
## API Endpoints
 
CMS runs on port 8082.
 
Base URL:
 
http://localhost:8082
 
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /contractors | Create contractor |
| GET | /contractors | Retrieve all contractors |
| GET | /contractors/{id} | Retrieve contractor by ID |
| PUT | /contractors/{id} | Update contractor |
| DELETE | /contractors/{id} | Delete contractor |
 
## Example Contractor Request
 
POST /contractors
 
Request Body:
 
    {
      "name": "Test Contractor",
      "email": "contractor@example.com",
      "department": "IT",
      "salary": 55000,
      "employeeType": "CONTRACTOR"
    }
 
## Database Integration
 
CMS does not directly manage the contractor database.
 
Instead, CMS sends requests to PMS.
 
PMS stores contractor information in the H2 database using Hibernate.
 
## Running the Application
 
1. Install Java 25.
2. Open the CMS project in IntelliJ IDEA.
3. Import Maven dependencies.
4. Ensure PMS is running on port 8081.
5. Verify that CMS is configured to communicate with PMS.
6. Run CmsApplication.java.
7. Verify that CMS starts on port 8082.
8. Test the REST APIs using Postman.
 
## Testing
 
The following API operations were tested using Postman:
 
| Test | Result |
|------|--------|
| Get contractor by ID | Passed |
| Get all contractors | Passed |
| Duplicate email validation | Passed |
| Invalid contractor ID | Passed |
| Update contractor | Passed |
| Verify updated contractor | Passed |
| Delete contractor | Passed |
| Verify contractor deletion | Passed |
 
### HTTP Status Codes Verified
 
- 200 OK
- 204 No Content
- 404 Not Found
- 409 Conflict
 
## Maven Build
 
The CMS project was successfully verified using Maven.
 
Build Status: SUCCESS
 
## Related Repository
 
Employee Management Service (PMS):
 
https://github.com/varshakatakam/pms
 
## Conclusion
 
CMS demonstrates Spring Boot microservices development,
REST API communication, DTO-based data transfer,
contractor CRUD operations, validation,
exception handling, and integration with PMS.
