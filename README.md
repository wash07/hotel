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
- [Java 8](https://expo.io/)
- [Spring Boot](https://nodejs.org/en/)
- [Spring Data](https://pt-br.reactjs.org/)
- [MySql](https://reactnative.dev/)
- [JQuery](https://www.typescriptlang.org/)
- [Bootstrap](https://www.typescriptlang.org/)
- [FontAwesome](https://www.typescriptlang.org/)

### Validations

Some of the validations applied on the project when the end user tries to reserve a booking:
- Check if it's not after 30 days from the actual date.
- Check if the end user is not booking a period bigger than 3 days.
- Check if the end user is booking a reservation at least a day after the actual date.

### How to Run

In order to run the application, you should have an MySQL server and under the src/resources folder
there's the application.properties where you can use your MySQL user and password configurations.
There's also the front-end application located at the resources folder.

To run the back-end server you need to have Maven installed in your machine and execute the following command:
`mvn spring-boot:run`

### Unit Tests

There are unit tests available using Junit 5 on the application so we can properly check
the business rule and guarantee that the validation logic is working as intended.

# Author
Washington Mesquita