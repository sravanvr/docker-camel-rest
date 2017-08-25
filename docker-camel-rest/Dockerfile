FROM openjdk:8
ADD target/docker-camel-rest.jar docker-camel-rest.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "docker-camel-rest.jar" ]