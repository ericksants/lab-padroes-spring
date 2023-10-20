package one.digitalinnovation.lab.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *  Projeto Spring Boot gerado via Spring Initializr.
 *  Módulos selecionados
 *  - Spring Data JPA
 *  - Spring WEB
 *  - H2 Database
 *  - OpenFeingn
 *
 * @author erick
 *
 */
@EnableFeignClients
@SpringBootApplication
public class LabPadroesSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabPadroesSpringApplication.class, args);
	}

}
