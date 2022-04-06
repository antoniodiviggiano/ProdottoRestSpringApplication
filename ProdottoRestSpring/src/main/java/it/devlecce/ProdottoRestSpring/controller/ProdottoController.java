package it.devlecce.ProdottoRestSpring.controller;

import it.devlecce.ProdottoRestSpring.model.Prodotto;
import it.devlecce.ProdottoRestSpring.repository.ProdottoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProdottoController {
    private static Logger logger = LoggerFactory.getLogger(ProdottoController.class);
    private ProdottoRepository repository;

    public ProdottoController(ProdottoRepository repository){
        this.repository = repository;
    }
    @GetMapping("/prodotti")
    List<Prodotto> tutti() {
        return repository.findAll();
    }
}
