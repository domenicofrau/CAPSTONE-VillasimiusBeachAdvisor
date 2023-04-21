package com.VillasimiusBeachAdvisor;

import java.io.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.VillasimiusBeachAdvisor.main.initializer.DatabaseInitializer;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@SpringBootApplication
public class VillasimiusBeachAdvisorApplication {

	public static void main(String[] args) throws IOException {
		
		ConfigurableApplicationContext context = SpringApplication.run(VillasimiusBeachAdvisorApplication.class, args);

		@SuppressWarnings("unused")
		DatabaseInitializer initializer = context.getBean(DatabaseInitializer.class);
		initializer.createSpiagge();
	}
}
