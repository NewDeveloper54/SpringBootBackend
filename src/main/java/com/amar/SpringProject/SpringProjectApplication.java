package com.amar.SpringProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringProjectApplication {

	public static void main(String[] args) {
		// La variable MONGODB_URI est lue directement depuis les variables d'environnement
		String uri = System.getenv("MONGODB_URI");

		// Tu peux afficher ou logguer l'URI si besoin (à retirer en production)
		System.out.println("MongoDB URI: " + uri);

		SpringApplication.run(SpringProjectApplication.class, args);
	}
}
