# Use OpenJDK 23 as the base image
FROM openjdk:23-jdk

# Label the author (optional)
LABEL authors="utkarshvijayvargiya"

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the host machine (target folder) into the container
COPY target/spring-boot-demo1-0.0.1-SNAPSHOT.jar /app/spring-boot-demo1-0.0.1-SNAPSHOT.jar

# Expose the port that the Spring Boot application will run on (default is 8080)
EXPOSE 8080

# Command to run the Spring Boot application when the container starts
ENTRYPOINT ["java", "-jar", "/app/spring-boot-demo1-0.0.1-SNAPSHOT.jar"]
