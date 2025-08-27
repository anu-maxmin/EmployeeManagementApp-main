# Use OpenJDK 17 image
FROM openjdk:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml first (for dependency caching)
COPY ./pom.xml ./ 
COPY ./mvnw ./ 
COPY .mvn/ .mvn

# Copy source code
COPY ./src ./src

# Give execute permission to Maven wrapper
RUN chmod +x mvnw

# Package the app
RUN ./mvnw package -DskipTests

# Expose port 8081
EXPOSE 8081

# Run the jar file
CMD ["java", "-jar", "target\employee-0.0.1-SNAPSHOT.jar"]
