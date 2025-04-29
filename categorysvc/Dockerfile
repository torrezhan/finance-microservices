# Build stage
FROM gradle:8.4.0-jdk17 AS build
WORKDIR /app

# Copy common-config first
COPY common-config /app/common-config
# Copy categorysvc
COPY categorysvc /app/categorysvc

# Set working directory to categorysvc
WORKDIR /app/categorysvc

# Build the application
RUN gradle build --no-daemon

# Run stage
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/categorysvc/build/libs/*.jar app.jar
ENV JAVA_OPTS="-Xmx256m -Xms128m"
EXPOSE 8084
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]