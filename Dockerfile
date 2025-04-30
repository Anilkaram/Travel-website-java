FROM java:17

COPY target/*.jar .

CMD ["java","-jar", "/*.jar"]
