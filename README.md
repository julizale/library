# LIBRARY


## Table of contents
* [General Information](#description)
* [Endpoints](#endpoints)
* [Technologies](#technologies)
* [Requirements](#requirements)

## Description:

The application is a simple REST API for the library.
It has modeled entities and related tables:

* Members, containing the reader's ID, name, lastname and account creation date,
* Titles, containing title id, title, author and year of publication,
* Books - meaning copies of books, containing the copy ID, title ID and status (IN_STOCK, BORROWED, LOST, DESTROYED, IN_REPAIR)
* Rentals - which includes the item ID, reader ID, borrowing date and return date.

## Endpoints:

* Adding a reader
* Adding a title
* Adding a copy
* Change of item status
* Checking the number of copies of a given title available for rent
* Borrowing a book
* Book return

## Technologies:

Project is created with:
- Java 17
- Spring Boot 2.7
- Spring Data JPA 2.7
- Spring
- Hibernate
- MySQL and H2 database
- JUnit5
- Gradle
- Swagger (springdoc-openapi-ui:1.6)

## Requirements

To run this project, clone the repository, create database and configure it in application.properties.

Tested with Postman, you can also use swagger at   /swagger-ui/index.html

https://snipboard.io/evUyqW.jpg

https://snipboard.io/AcnmTp.jpg

https://snipboard.io/81Z9Hn.jpg

https://snipboard.io/qQ2Vca.jpg

https://snipboard.io/GfMKAS.jpg

https://snipboard.io/b1iM0z.jpg

https://snipboard.io/sOzlhx.jpg