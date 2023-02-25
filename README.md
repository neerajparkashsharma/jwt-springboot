# Spring Boot JWT Implementation


This repository contains a Spring Boot implementation of JSON Web Tokens (JWT) for secure authentication and authorization. JSON Web Tokens are a standard for representing claims securely between two parties and are widely used for single sign-on (SSO) and other security scenarios.

# Getting Started

## Prerequisites
To build and run this project, you will need:
* Java 8 or higher
* Apache Maven 3.3.9 or higher


## Building

> To build the project, run the following command in the root directory:
` mvn package `

> This will compile the source code and create an executable JAR file in the target directory.



## Dependencies 
`<dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jdbc</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt</artifactId>

        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>

        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt</artifactId>
            <version>0.9.1</version>
        </dependency>
        <dependency>
            <groupId>com.microsoft.sqlserver</groupId>
            <artifactId>mssql-jdbc</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
`

## Configuration 

> The JWT implementation supports the following configuration options:

* jwt.secret: *the secret key used to sign and verify tokens (default: "secret").
* jwt.refreshExpirationDateInMs: *The jwt.refreshExpirationDateInMs property specifies the expiration time of the refresh token in milliseconds. A refresh token is used to request a new access token after the current access token has expired. In this case, the refresh token will expire after 9000000 milliseconds, which is equivalent to 2.5 hours.
* jwt.expirationDateInMs: *The jwt.expirationDateInMs property specifies the expiration time of the JWT in milliseconds. If it's set to 0, it means the token will     never expire.

`
jwt.expirationDateInMs=0
`
`
jwt.refreshExpirationDateInMs=9000000
`
`
jwt.secret = neeraj
`

# API EndPoints

* `/authenticate`: A POST endpoint that accepts a JwtRequest object in the request body, containing the user's username and password. The authenticate() method is called to verify the user's credentials, and if successful, a JWT token is generated using the JwtTokenUtil class and returned in a JwtResponse object.

* `/register`: A POST endpoint that accepts an Employee object in the request body, containing the user's details. The save() method of the JWTUserDetailsService class is called to save the user in the database.

* Both endpoints are annotated with @RequestMapping and @CrossOrigin annotations to define the request mapping and allow cross-origin requests respectively.

* The AuthenticationManager, JwtTokenUtil, and JWTUserDetailsService beans are autowired to the controller using Spring's dependency injection.

* The *authenticate()* method is a helper method that authenticates the user's credentials using the AuthenticationManager and throws an exception if the credentials are invalid. This method is called by the /authenticate endpoint.

* The *saveUser()* method is called by the /register endpoint and saves the user in the database using the JWTUserDetailsService.
> Overall, these endpoints provide a basic authentication system that allows users to authenticate using their username and password and register as new users.
