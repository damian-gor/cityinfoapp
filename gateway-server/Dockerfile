FROM openjdk:13-alpine
ADD target/gateway-server.jar gateway-server.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=docker", "-jar", "gateway-server.jar"]