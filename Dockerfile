# Use OpenJDK 8 base image
FROM openjdk:8-jdk-alpine

# Set working directory in container
WORKDIR /app

# Copy the JAR file built by Maven into the image
COPY target/*.jar app.jar

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
