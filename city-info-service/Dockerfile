FROM openjdk:13-alpine
ADD target/city-info-service.jar city-info-service.jar
EXPOSE 8081
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=docker", "-jar", "city-info-service.jar"]