FROM openjdk:13-alpine
ADD target/country-info-service.jar country-info-service.jar
EXPOSE 8083
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=docker", "-jar", "country-info-service.jar"]