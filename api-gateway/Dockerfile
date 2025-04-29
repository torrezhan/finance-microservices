# Build stage
FROM gradle:8.4.0-jdk17 AS build
WORKDIR /app

# Copy common-config first
COPY common-config /app/common-config
# Copy api-gateway
COPY api-gateway /app/api-gateway

# Set working directory to api-gateway
WORKDIR /app/api-gateway

# Build the application
RUN gradle build --no-daemon

# Run stage
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/api-gateway/build/libs/*.jar app.jar
ENV JAVA_OPTS="-Xmx256m -Xms128m"
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]