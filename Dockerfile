FROM openjdk:8-jre-alpine

ENV spring.server.port 8081

COPY student-service/bootstrap/build/libs/bootstrap-0.0.1-SNAPSHOT.jar student-service.jar

RUN java -jar student-service.jar