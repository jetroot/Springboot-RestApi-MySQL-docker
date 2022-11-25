# Spring Boot, MySQL, JPA, Hibernate Rest API, Docker, Unit Test Tutorial

Build Restful CRUD API for a simple Note-Taking application using Spring Boot, Mysql, JPA and Hibernate with docker.

## Requirements

1. Java - 8

2. Maven - 3.x.x

3. Mysql - 8.0.31-oracle

## Steps to Setup

**1. Clone the application**

```bash
git clone git@github.com:jetroot/Springboot-RestApi-MySQL-docker.git
```

**2. Build and run the app using maven**

```bash
mvn clean install
```

**3. Build and run the app using maven**

```bash
docker composer up
```

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app defines following CRUD APIs.

    GET /api/notes
    
    POST /api/notes
    
    GET /api/notes/{noteId}
    
    PUT /api/notes/{noteId}
    
    DELETE /api/notes/{noteId}

