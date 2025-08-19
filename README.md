# 🌍 Real-Time Events Tracking using Google Maps API

A production-style **Spring Boot** web application that integrates **MySQL + Hibernate** with **Google Maps APIs** (Maps JavaScript, Directions, Geocoding, Places) to allow users to register, add and view events, and visualize routes and event warnings on an interactive map.


## Project overview
This web application demonstrates full-stack functionality:
- User registration & login
- Submitting event information (email, location, issue)
- Visualizing events and routes on Google Maps
- Using Google Directions & Geocoding to compute and render routes
- Persisting users and events in MySQL using Hibernate/JPA

It is built to be easy to run locally for evaluation and to be deployed to a JVM-enabled cloud host later.

---

## Features
- ✅ User registration and login
- ✅ Persisted event information (`info` table)
- ✅ Interactive map UI with route drawing
- ✅ Warnings extraction from route instructions (custom logic)
- ✅ Hibernate / JPA auto-DDL (`spring.jpa.hibernate.ddl-auto=update`)
- ✅ Simple, clean Thymeleaf/JSP templates for UI

---

## Tech stack
- Java 17
- Spring Boot (Spring Web, Spring Data JPA)
- Hibernate / JPA
- MySQL 8
- Thymeleaf / server-side templates (HTML)
- Google Maps JavaScript API (Maps JS, Directions, Geocoding, Places)
- Maven build

---
## Project structure (important files)
src/
├─ main/java/com/location/project/
│ ├─ controller/ # HomeController, LoginController, RegistrationController, ErrorController
│ ├─ entity/ # User.java, Info.java
│ ├─ repository/ # UserRepository, InfoRepository
│ ├─ service/ # service interfaces
│ ├─ serviceimp/ # service implementations
│ └─ MainApplication.java
└─ main/resources/
├─ application.properties
└─ templates/ # home.html, login.html, register.html, updateinfo.html, aboutus.html, contactus.html, error.html
pom.xml


---

## Prerequisites
Install the following on your development machine:
- Java 17 JDK
- Maven (or use the bundled `mvnw`)
- MySQL Server 8.x (running on `localhost:3306`)
- A Google Cloud account (to create Maps API key and enable billing for Directions/Geocoding)

---


---

## Prerequisites
Install the following on your development machine:
- Java 17 JDK
- Maven (or use the bundled `mvnw`)
- MySQL Server 8.x (running on `localhost:3306`)
- A Google Cloud account (to create Maps API key and enable billing for Directions/Geocoding)

---

## Local setup

### Clone repository
```bash
git clone https://github.com/kushwanth-gowda-vs/Real-Time-Events-Tracking-Using-Goggle-Maps.git
cd Real-Time-Events-Tracking-Using-Goggle-Maps

**##Create MySQL database**
-- log in as root (or your admin user)
-- mysql -u root -p

CREATE DATABASE geo CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

##Configure application properties
server.port=8080

spring.datasource.url=jdbc:mysql://localhost:3306/geo
spring.datasource.username=root            # or geo_user
spring.datasource.password=Root@123        # or Geo@123

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

spring.devtools.restart.enabled=true

##Add Google Maps API key
Go to Google Cloud Console → create/select a project.

Enable APIs (APIs & Services → Library):

Maps JavaScript API

Directions API

Geocoding API

Places API (if you use autocomplete)

Create Credentials → API Key.

For local development, you can temporarily keep key unrestricted. For production, restrict:

Application restriction → HTTP referrers → http://localhost:8080/*

API restriction → select the Maps APIs used

Replace the hard-coded key in src/main/resources/templates/home.html:

##Build & run (local)
# using Maven wrapper (recommended if provided)
./mvnw clean package     # Unix/Mac
mvnw.cmd clean package   # Windows

# run directly
./mvnw spring-boot:run
# or
mvn spring-boot:run
