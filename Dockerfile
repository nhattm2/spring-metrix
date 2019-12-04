FROM openjdk:13.0.1-slim
COPY target/spring-metrix-0.0.1-SNAPSHOT.jar /app.jar
CMD ["java", "-jar", "/app.jar"]