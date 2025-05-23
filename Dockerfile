# Etapa de construcción
FROM maven:3.9.6-amazoncorretto-17 AS build
WORKDIR /app
COPY  pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests
# Etapa de ejecución
FROM amazoncorretto:17-alpine3.18
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "app.jar" ]