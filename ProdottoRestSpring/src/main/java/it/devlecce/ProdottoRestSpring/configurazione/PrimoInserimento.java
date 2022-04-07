package it.devlecce.ProdottoRestSpring.configurazione;

import it.devlecce.ProdottoRestSpring.model.Prodotto;
import it.devlecce.ProdottoRestSpring.repository.ProdottoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class PrimoInserimento {
    private static Logger logger = LoggerFactory.getLogger(PrimoInserimento.class);

    @Bean
    CommandLineRunner inserisciElementi(ProdottoRepository repository){
        return args -> {

            SimpleDateFormat dataAcquisto = new SimpleDateFormat("yyyy-MM-dd");
            Date datadiacquistop1 = dataAcquisto.parse("2005-05-22");
            Date datadiacquistop2 = dataAcquisto.parse("2006-02-23");
            Date datadiacquistop3 = dataAcquisto.parse("2015-12-03");

            Prodotto p1 = new Prodotto("Samsung Galaxy S10", 599.9f, datadiacquistop1);
            Prodotto p2 = new Prodotto("Playstation", 499.9f, datadiacquistop2);
            Prodotto p3 = new Prodotto("Smart TV", 2000.0f, datadiacquistop3);
            List<Prodotto> prodotti = new ArrayList<>();
            prodotti.add(p1);
            prodotti.add(p2);
            prodotti.add(p3);
            repository.saveAll(prodotti);

        };
    }

}
