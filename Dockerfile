# Dockerfile
# getting base image
FROM openjdk:8

MAINTAINER ctschubel <ctschubel@googlemail.com>

# Add application to docker container
ADD target/test-0.0.1-SNAPSHOT.jar testcts.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "testcts.jar"]


