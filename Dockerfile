FROM eclipse-temurin:21-jdk-alpine AS build

# Copiamos el pom y el código
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Compilamos y generamos el JAR
RUN mvn clean package

FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copiamos el jar generado desde la etapa "build"
COPY --from=build /app/target/*.jar app.jar

# Comando por defecto
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]


