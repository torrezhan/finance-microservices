# Build stage
FROM gradle:8.4.0-jdk17 AS build
WORKDIR /app

# Copy common-config first
COPY common-config /app/common-config
# Copy auth-service
COPY auth-service /app/auth-service

# Set working directory to auth-service
WORKDIR /app/auth-service

# Build the application
RUN gradle build --no-daemon

# Run stage
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/auth-service/build/libs/*.jar app.jar
ENV JAVA_OPTS="-Xmx256m -Xms128m"
EXPOSE 8082
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]