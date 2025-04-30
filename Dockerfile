FROM openjdk:17-jdk-slim

COPY target/*.jar .

CMD ["java","-jar", "/*.jar"]
