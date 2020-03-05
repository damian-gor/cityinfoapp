FROM openjdk:13-alpine
ADD target/weather-info-service.jar weather-info-service.jar
EXPOSE 8082
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=docker", "-jar", "weather-info-service.jar"]