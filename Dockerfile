# Use a base image with Java 8
FROM openjdk:8-jdk-alpine

# Set working directory inside the container
WORKDIR /app

# Copy the JAR file to the container
COPY app.jar app.jar
# Expose the port used by the app
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]

