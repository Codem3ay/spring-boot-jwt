# Spring boot with JWT

###About

This project presents the usage of **JWT (JASON WEB TOKEN)** with **Spring Security** and **Spring boot**. This solution
is based on [**JWT Spring Security Demo**](https://github.com/szerhusenBC/jwt-spring-security-demo "Repository link") 
project by [**Stephan Zerhusen**](https://github.com/szerhusenBC "Github's profile link").

It has less code and can be used as a starter point for your development.

###Usage

Just run your application either by your IDE (STS, Intellij) or from the command line by using the 
Spring Boot Maven Plugin with the command `mvn spring-boot:run`. 

To test your application install [Postman](https://www.getpostman.com/ "Postman link") and import 
[Spring-Boot-With-Jwt.postman_collection.json](https://github.com/Codem3ay/spring-boot-jwt/blob/master/Spring-Boot-With-Jwt.postman_collection.json 
"Postman collection link") file.

You can test your application using the four endpoints:
* Login : log the user, you can use the admin account (username:admin, password:admin) or the user 
account (username:user, password:password)
* Public : this endpoint is public and does not required the authorization header to return a response
* User : This endpoint requires an Authorization header, make sure to update the token with the response from the login endpoint response. Admin and User accounts can reach this URL.
* Admin :  Same for the User endpoint. Only the Admin account can reach this URL otherwise you get an _AccessDeniedException_
 