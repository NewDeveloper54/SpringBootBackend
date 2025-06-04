# Utilise une image OpenJDK officielle (version 17 par exemple)
FROM eclipse-temurin:17-jdk-alpine

# Définir le répertoire de travail dans le container
WORKDIR /app

# Copier le fichier de build maven wrapper + pom.xml + sources
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

# Rendre mvnw exécutable
RUN chmod +x mvnw

# Build le projet
RUN ./mvnw clean package -DskipTests

# Copier le jar construit (nomme ton jar comme il faut si différent)
COPY target/SpringProject-0.0.1-SNAPSHOT.jar app.jar

# Expose le port sur lequel l'app tourne
EXPOSE 8080

# Commande pour lancer l’application
ENTRYPOINT ["java","-jar","app.jar"]
