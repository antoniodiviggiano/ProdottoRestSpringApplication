package it.devlecce.ProdottoRestSpring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProdottoRestSpringApplication {

	private static final Logger logger =
			LoggerFactory.getLogger(ProdottoRestSpringApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProdottoRestSpringApplication.class, args);
		logger.debug("prova console");
	}

}
