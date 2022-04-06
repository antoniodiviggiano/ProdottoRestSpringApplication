package it.devlecce.ProdottoRestSpring.controller;

import it.devlecce.ProdottoRestSpring.avviso.ProdottoNonTrovato;
import it.devlecce.ProdottoRestSpring.model.Prodotto;
import it.devlecce.ProdottoRestSpring.repository.ProdottoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdottoController {
    private static Logger logger = LoggerFactory.getLogger(ProdottoController.class);
    private ProdottoRepository repository;

    public ProdottoController(ProdottoRepository repository){
        this.repository = repository;
    }

    //trova tutti i prodotti
    @GetMapping("/prodotti")
    List<Prodotto> tutti() {
        return repository.findAll();
    }

    //trova il prodottto tramite l'id
    @GetMapping("/prodotto/{id}")
    public Prodotto trovaProdottoConId(@PathVariable Long id){
        return repository.findById(id).orElseThrow(
                () -> new ProdottoNonTrovato(id));
    }

    //inserimento prodotto
    @PostMapping("/prodotto")
    public Prodotto inserisciUnNuovoProdotto(@RequestBody Prodotto nuovoProdotto){
        return repository.save(nuovoProdotto);
    }

    //eliminazione prodotto
    @DeleteMapping("prodotto/{id}")
    void eliminaProdotto(@PathVariable Long id){
        repository.deleteById(id);
    }

}
