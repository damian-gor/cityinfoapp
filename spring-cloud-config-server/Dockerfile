FROM openjdk:13-alpine
ADD target/spring-cloud-config-server.jar spring-cloud-config-server.jar
EXPOSE 8888
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=docker", "-jar", "spring-cloud-config-server.jar"]