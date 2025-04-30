FROM openjdk:17-jdk-slim

COPY target/*.jar .

CMD ["java","-jar", "travel-booking-0.0.1-SNAPSHOT.jar"]
