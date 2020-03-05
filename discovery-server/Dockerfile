FROM openjdk:13-alpine
ADD target/discovery-server.jar discovery-server.jar
EXPOSE 8761
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=docker", "-jar", "discovery-server.jar"]