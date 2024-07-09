# Spring Boot Application

This is a Spring Boot application running on Java 21 with Gradle.

## Prerequisites

- Java 21
- Gradle
- Docker (if running with Docker)

## Running the Application

### Without Docker

1. **Build the application:**

    ```bash
    ./gradlew build
    ```

2. **Run the application:**

    ```bash
    java -jar build/libs/TestTaskHacken-0.0.1-SNAPSHOT.jar
    ```

### With Docker

1. **Build the Docker image:**

    ```bash
    docker build -t spring-boot-app .
    ```

2. **Run the Docker container:**

    ```bash
    docker run -p 8080:8080 spring-boot-app
    ```

   The application will be accessible at `http://localhost:8080/swagger-ui/index.html`.

(Spring boot actuator)[https://www.baeldung.com/spring-boot-actuators] (from /actuator)

        /actuator/metrics details metrics of our application. This might include generic metrics as well as custom ones.
        /actuator/health summarizes the health status of our application.


## Additional Notes

- Ensure that the port specified in the Dockerfile matches the port configured in your Spring Boot application properties.
- You can customize the `Dockerfile` and the `application.properties` as per your application requirements.
