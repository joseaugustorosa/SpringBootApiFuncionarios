FROM openjdk:17-jdk-slim

WORKDIR /app
COPY target/AssessmentJava-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "App.jar"]
