# Alten Hotel

The project main goal is to create an CRUD operation where users can book an hotel reservation.
There's a front-end application available as well.

Content Table
=================
<!--ts-->
* [Architecture](#architecture)
* [Features](#features)
* [Technologies](#technologies)
* [Validations](#validations)
* [How to Run](#how-to-run)
* [Unit Tests](#unit-tests)
* [Author](#author)
<!--te-->

### Architecture

It follows an MVC (Model View Controller) structure.

- Controllers: Responsible for handling the HTTP calls to the APIs.

- Services: Contains the business logic and manage the database calls

- Repository: Abstracts the communication with the database

- Validations: Each class is responsible for an individual validation by
implementing the main validation interface making it possible to scale multiple
validations without changing another layer.

### Features

- [x] Create Booking
- [x] Update booking
- [x] Cancel Booking
- [x] List Bookings
- [x] Booking Validation

### Technologies

These are the tools used to develop this application:
- [Java 8](https://www.oracle.com/br/index.html)
- [Spring Framework](https://spring.io)
- [Lombok](https://projectlombok.org)
- [H2](https://www.h2database.com/html/main.html)
- [JQuery](https://jquery.com)
- [Bootstrap](https://getbootstrap.com)
- [FontAwesome](https://fontawesome.com)

### Validations

Some validations applied on the project when the end user tries to reserve a booking:
- Check if it's not after 30 days from the actual date.
- Check if the end user is not booking a period bigger than 3 days.
- Check if the end user is booking a reservation at least a day after the actual date.
- Check if the end user choose a check-out date before the check-in date.
- Check if the end user choose a date on the past.

### How to Run

To run the back-end server you need to have Maven installed in your machine and execute the following command:
`mvn spring-boot:run`

Since we are using H2 Database for testing purposes there's no need to have a MySQL configured.

### Unit Tests

There are unit tests available using Junit 5 on the application so we can properly check
the business rule and guarantee that the validation logic is working as intended.

# Author
Washington Mesquita