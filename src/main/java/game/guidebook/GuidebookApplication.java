package game.guidebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude  = { SecurityAutoConfiguration.class })
public class GuidebookApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuidebookApplication.class, args);
	}

}
