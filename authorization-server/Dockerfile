FROM openjdk:13-alpine
ADD target/authorization-server.jar authorization-server.jar
EXPOSE 9292
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=docker", "-jar", "authorization-server.jar"]