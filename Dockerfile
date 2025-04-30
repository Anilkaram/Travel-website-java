FROM java

COPY target/*.jar .

CMD ["java","-jar", "/*.jar"]
