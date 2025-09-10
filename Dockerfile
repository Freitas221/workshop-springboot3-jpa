FROM maven:3.8.4-eclipse-temurin-17 AS build

WORKDIR /app
COPY src /app/src
COPY pom.xml /app

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build app/target/*.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "app.jar" ]