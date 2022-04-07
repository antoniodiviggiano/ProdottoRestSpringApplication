package it.devlecce.ProdottoRestSpring.controller;

import it.devlecce.ProdottoRestSpring.avviso.ProdottoNonTrovato;
import it.devlecce.ProdottoRestSpring.model.Prodotto;
import it.devlecce.ProdottoRestSpring.repository.ProdottoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
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

    //trova il prodotto tramite l'id
    @GetMapping("/prodotto/{id}")
    public Prodotto trovaProdottoConId(@PathVariable Long id){
        return repository.findById(id).orElseThrow(
                () -> new ProdottoNonTrovato(id));
    }
    //modifica prodotto
    @PutMapping("/prodotto/{id}")
    public Prodotto aggiornaDatiProdotto(@PathVariable Long id, @RequestBody Prodotto prodotto) {
        return  repository.findById(id)
                .map(
                        nuovoProdotto -> {
                            nuovoProdotto.setNome(prodotto.getNome());
                            nuovoProdotto.setPrezzo(prodotto.getPrezzo());
                            return repository.save(nuovoProdotto);
                        }
                )
                .orElseGet(() -> {
                            //il prodotto esiste
                             prodotto.setId(id);
                            return repository.save(prodotto);
                        }
                );
    }

    //inserimento prodotto
    @PostMapping("/inserisciprodotto")
    public Prodotto inserisciUnNuovoProdotto(@RequestBody Prodotto nuovoProdotto){
        return repository.save(nuovoProdotto);
    }

    //eliminazione prodotto
    @DeleteMapping("prodotto/{id}")
    void eliminaProdotto(@PathVariable Long id){
        repository.deleteById(id);
    }

    //query prodotto x nome
    @GetMapping("/prodotto/ricerca/nome/{nome}")
    List<Prodotto> cercaPerNome(@PathVariable String nome) {
        return repository.findByNome(nome);
    }

    //query prodotto x data
    @GetMapping("/prodotto/ricerca/datadiacquisto")
    public List<Prodotto> ricercaUtenteConDataDiAcquisto(
            @RequestParam(name = "datada") @DateTimeFormat(pattern = "dd-MM-yyyy")
                    Date datada,
            @RequestParam(name = "dataa") @DateTimeFormat(pattern = "dd-MM-yyyy")
                    Date dataa
    ){
        return repository.findByDatadiacquistoBetween(datada, dataa);
    }

    //Caricamento di file
    @PostMapping("/caricafile")
    public String caricaFile (@RequestParam("file") MultipartFile file){
        String infofile = file.getOriginalFilename() + " - " + file.getContentType();
        String conFormat = String.format("%s-%s", file.getOriginalFilename(), file.getContentType());
        logger.info(infofile);
        logger.warn(conFormat);
        return conFormat;
    }
}
