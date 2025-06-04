package com.amar.SpringProject;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringProjectApplication {

	public static void main(String[] args) {
		// Charger les variables du fichier .env
		Dotenv dotenv = Dotenv.configure().load();

		// Injecter la variable MONGODB_URI dans les propriétés système
		System.setProperty("MONGODB_URI", dotenv.get("MONGODB_URI"));

		SpringApplication.run(SpringProjectApplication.class, args);
	}
}
