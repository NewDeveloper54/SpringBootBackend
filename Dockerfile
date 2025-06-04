# Étape 1 : builder l'appli avec Maven
FROM maven:3.9.3-eclipse-temurin-17 AS build

WORKDIR /app

# Copier uniquement les fichiers nécessaires pour le build
COPY pom.xml .
COPY src ./src

# Build sans tests
RUN mvn clean package -DskipTests

# Étape 2 : lancer l'appli avec l'image JRE légère
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copier le JAR buildé depuis l'étape précédente avec le nom exact
COPY --from=build /app/target/SpringProject-0.0.1-SNAPSHOT.jar app.jar

# Port exposé par l'application Spring Boot
EXPOSE 8080

# Commande pour lancer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
