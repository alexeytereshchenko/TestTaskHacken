FROM gradle:8.8.0-jdk21 AS build

WORKDIR /home/gradle/project
COPY build.gradle settings.gradle /home/gradle/project/
COPY src /home/gradle/project/src
RUN gradle build --no-daemon

FROM openjdk:21-jdk-slim

WORKDIR /app
COPY --from=build /home/gradle/project/build/libs/*.jar /app/app.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
