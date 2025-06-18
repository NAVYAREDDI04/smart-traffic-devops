FROM openjdk:17
ADD target/traffic-api.jar traffic-api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "traffic-api.jar"]
