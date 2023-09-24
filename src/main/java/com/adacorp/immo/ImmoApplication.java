package com.adacorp.immo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImmoApplication {

	public static void main(String[] args) {

		SpringApplication.run(ImmoApplication.class, args);
	}

}
/**
 * Cheminement:
 * 1 - Creer le model
 * 2 - creer le repository (faire communiquer avec le model)
 * 3 - Creer le service, injecter la dependance du repository dans le service
 * 4 - Creer le controleur et injecter la dependance du service dans le controleur
 * 5 - creer l'ENDPOINT (La methode que vous voule [GET, PUT, POST, DELETE, PATCH] )
 * 6 - Testez votre application
 *
 * ref: https://app.diagrams.net/#G13idmLipGQq3-rBJVN1MXhWC9ZVProEJ-
 */
