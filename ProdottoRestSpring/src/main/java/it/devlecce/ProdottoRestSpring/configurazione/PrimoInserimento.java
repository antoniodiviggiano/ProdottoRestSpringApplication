package it.devlecce.ProdottoRestSpring.configurazione;

import it.devlecce.ProdottoRestSpring.model.Prodotto;
import it.devlecce.ProdottoRestSpring.repository.ProdottoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class PrimoInserimento {
    private static Logger logger = LoggerFactory.getLogger(PrimoInserimento.class);

    @Bean
    CommandLineRunner inserisciElementi(ProdottoRepository repository){
        return args -> {
            logger.info("Primo inserimento");
            Prodotto p1 = new Prodotto("Samsung Galaxy S10", 599.9f);
            Prodotto p2 = new Prodotto("Playstation", 499.9f);
            Prodotto p3 = new Prodotto("Smart TV", 2000.0f);
            List<Prodotto> prodotti = new ArrayList<>();
            prodotti.add(p1);
            prodotti.add(p2);
            prodotti.add(p3);
            repository.saveAll(prodotti);

        };
    }

}
