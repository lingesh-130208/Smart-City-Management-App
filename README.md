# Smart City Management App

A Java 17, Spring Boot 3.3.5, Thymeleaf, Spring Data JPA, MySQL citizen complaint registration and tracking system with an admin panel.

## Project Overview

This is a Spring Boot web application that allows citizens to register complaints and track their status, while administrators can view and update complaint records.

**Note:** The `/admin` route has no production-grade authentication. Do not deploy without proper security.

## Tech Stack

- **Java 17**
- **Spring Boot 3.3.5**
- **Thymeleaf** (templating engine)
- **Spring Data JPA** (data persistence)
- **MySQL** (database)

## Setup

### 1. Create the Database

Run the following SQL command in MySQL:

```sql
CREATE DATABASE smart_city_db;
```

### 2. Set Database Password

Set the `DB_PASSWORD` environment variable in Windows CMD before running the application:

```cmd
set DB_PASSWORD=your_mysql_password
```

Or update `src/main/resources/application.properties` with your MySQL password.

### 3. Run the Application

Build and run using Maven:

```bash
mvn clean package
mvn spring-boot:run
```

### 4. Access the Application

Open your browser and navigate to:

```
http://localhost:8080
```

## Routes

| Route | Description |
|-------|-------------|
| `/` | Home page with links to all sections |
| `/complaints/new` | Citizen complaint registration form |
| `/track` | Track complaint by tracking code |
| `/admin` | Admin dashboard to manage complaints |

## API Endpoints

- `GET /` - Home page
- `GET /complaints/new` - Complaint form
- `POST /complaints` - Submit a new complaint
- `GET /track` - Tracking form
- `POST /track` - Submit tracking code to look up complaint
- `GET /admin` - Admin dashboard
- `POST /admin/complaints/{id}/update` - Update complaint department and status

## Entity Fields

Complaint entity includes: trackingCode, citizenName, email, category, description, location, department, status (PENDING, IN_PROGRESS, RESOLVED), createdAt, updatedAt.

## Build

```bash
mvn clean package
```

## ⚠️ Security Notice

The `/admin` endpoint currently has **no production-grade authentication**. It should only be used in development environments. Add proper authentication before deploying to production.
