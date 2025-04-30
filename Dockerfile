FROM tomcat

COPY target/*.jar /opt/tomcat/webapps/myapp.jar

CMD ["java","-jar", "myapp.jar"]
