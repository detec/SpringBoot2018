# SpringBoot2017

This is a template project to build with Maven or Gradle. It uses Spring Data for H2 and runs with Spring Boot.

Its core components are:
- Spring Boot 1.5;
- Jackson Databind 2.8 with JSR310 support;
- sl4j/Logback;
- Spring Data 1.11;
- Springfox swagger 2.7;
- Java 8.

There is a repository level that extends Repository interface in Spring Data, no actual implementation is needed. Service layer is omitted. 

There is a sample Customer class that utilizes '/customer/' endpoint. To view automatic Swagger.io documentation use address /swagger-ui.html.
To log in to frontend of application use login password pair admin/1. These are credentials both for regular REST endpoints and standard Spring Boot actuator endpoints, which are listed in application startup log.

There are custom health endpoints . To reach them call endpoint GET http://localhost:8080/test . It should return 'true' in response body. You can also use additional endpoint to check current server time: GET http://localhost:8080/now . Requests should be accompanied by "Accept" and "Content-Type" headers with value application/json.
Sample rest controller supports exception handling and JSON pretty printing. 

Change src/main/resources/application.properties to customize the application using standard Spring Boot properties.

To build project use commands "mvn package" or "gradlew build" respectively.