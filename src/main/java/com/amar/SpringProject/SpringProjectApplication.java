package com.amar.SpringProject;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringProjectApplication {

	public static void main(String[] args) {
		// En local, charge .env ; sur Railway, les variables sont déjà dans le système
		// Mmeme ici tas u fichier .env que tu vas creer, tu vas mettre ton compte MongoDB
		if (System.getenv("RAILWAY_STATIC_URL") == null) {
			Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
			String uri = dotenv.get("SPRING_DATA_MONGODB_URI");
			if (uri != null) {
				System.setProperty("SPRING_DATA_MONGODB_URI", uri);
			}
		}

		SpringApplication.run(SpringProjectApplication.class, args);
	}
}
