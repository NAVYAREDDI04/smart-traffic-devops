ROM openjdk:17
COPY target/smart-traffic-devops-1.0-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
