# Travel Gig

## Description
It is a web-based hotel-booking microservices application.  I was primarily involved with developing the hotel and booking management microservices at the backend to handle both client and administrative requests.  The hotel microservice contains the features like searching and filtering hotels based on preferences such as location, number of guests, rating, pricing, and amenities.  The booking microservice includes the CRUD of hotel reservations and the payment system by using the Stripe API.  Also, the application contains other features such as commenting, rating, and questioning about hotels for users’ authorization and responding to questions, and adding/editing/removing hotels’ information for admins’ authorization.

## Technologies
 Java 8, Hibernate, Spring Boot, HTML5, Bootstrap 4, JavaScript, jQuery, JSP, Postman, Maven, Tomcat, MySQL, Git

## Backend:
- Used Spring Security framework to implement create/login authentication and role authorization.
- Used Spring Boot as the Web Services framework to implement the REST APIs involved.
- Configured MySQL database and used Hibernate as an Object Relational Mapping solution to communicate between Java and MySQL database.
- Implemented JPA Repository to create CRUD operations.
implemented iText to create dynamic pdf file generator for receipts and notifications.
- Used Java Mail Sender to send users emails of completion or cancellation of hotel reservations
Implemented third-party Stripe API for payment once users booked hotels.
- Performed testing for the REST service using Postman
Use Git/GitHub as VCS to maintain and track the project and dependencies.
- Created an auto-check-in system to check in hotel in real-time.

## Frontend:
- Implemented custom validations for user input and displays form validation errors.
- Used jQuery for DOM manipulation, events handlers, and JSON Parsing.
- Used AJAX to handle requests and responses of rest APIs from the back-end.
- Implemented JSP with Bootstrap/CSS and used JavaScript to achieve another client-side event handling.
