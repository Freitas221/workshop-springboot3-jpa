FROM ubuntu:latest AS build

WORKDIR /app
COPY src /app/src
COPY pom.xml /app

RUN apt-get update && apt-get install openjdk-17-jdk -y maven

RUN apt-get install maven -y
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app
COPY --from=build app/target/course-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "app.jar" ]