package com.VillasimiusBeachAdvisor;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.VillasimiusBeachAdvisor.main.initializer.DatabaseInitializer;


@SpringBootApplication
public class VillasimiusBeachAdvisorApplication {

	public static void main(String[] args) throws IOException {
		
		ConfigurableApplicationContext context = SpringApplication.run(VillasimiusBeachAdvisorApplication.class, args);

		@SuppressWarnings("unused")
		DatabaseInitializer initializer = context.getBean(DatabaseInitializer.class);
		initializer.createSpiagge();
	}
}
