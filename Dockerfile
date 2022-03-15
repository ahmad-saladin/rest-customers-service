FROM openjdk:8-jdk-alpine

WORKDIR /app

COPY target/*.jar tmp/

VOLUME ["/app/tmp/sample.db"]

EXPOSE 4001

ENTRYPOINT ["java","-jar","/app/tmp/rest-customers-service-1.0.0-SNAPSHOT.jar"]