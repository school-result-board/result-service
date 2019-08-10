FROM openjdk:8-jre-alpine

ENV spring.server.port 8081

COPY ./bootstrap/build/libs/bootstrap-0.0.1-SNAPSHOT.jar result-service.jar

RUN java -jar result-service.jar
