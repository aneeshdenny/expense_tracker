# Expense Tracker Full Stack Application

A full-stack Expense Tracker application built using Java Spring Boot, MySQL, HTML, CSS, and JavaScript.

The application allows users to manage daily expenses with complete CRUD functionality.

---

## Features

### Backend Features
- RESTful API Development
- Add Expense
- Update Expense
- Delete Expense
- Get All Expenses
- Get Expense by ID
- Calculate Total Expenses
- MySQL Database Integration
- Exception Handling
- Layered Architecture

### Frontend Features
- Dynamic Expense Table
- Add Expense Form
- Edit Existing Expenses
- Delete Expenses
- Real-Time Total Expense Calculation
- Fetch API Integration
- Responsive UI

---

## Tech Stack

### Backend
- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven

### Frontend
- HTML
- CSS
- JavaScript

### Database
- MySQL

### Tools
- VS Code
- Postman
- Git & GitHub

---

## Project Structure

```text
expense_tracker
│
├── src
│
├── frontend
│   ├── index.html
│   ├── style.css
│   └── app.js
│
├── screenshots
│
├── pom.xml
├── README.md
```

---

## REST API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | /api/expenses | Add Expense |
| GET | /api/expenses | Get All Expenses |
| GET | /api/expenses/{id} | Get Expense By ID |
| PUT | /api/expenses/{id} | Update Expense |
| DELETE | /api/expenses/{id} | Delete Expense |
| GET | /api/expenses/total | Get Total Expenses |

---

## Database Configuration

Create MySQL database:

```sql
CREATE DATABASE expense_tracker;
```

Update database credentials inside:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/expense_tracker
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## Running Backend

Navigate to project directory:

```bash
cd expense_tracker
```

Run Spring Boot application:

```bash
mvn spring-boot:run
```

Backend runs on:

```text
http://localhost:8080
```

---

## Running Frontend

Open:

```text
frontend/index.html
```

Run using Live Server extension in VS Code.

Frontend runs on:

```text
http://127.0.0.1:5500
```

---

## Application Screenshots

### Home Page

![Expense Tracker](screenshots/home-page.png)

---

## Future Improvements

- User Authentication
- JWT Security
- Search & Filter
- Expense Analytics Dashboard
- React Frontend
- Cloud Deployment

---

## Author

Aneesh Denny
