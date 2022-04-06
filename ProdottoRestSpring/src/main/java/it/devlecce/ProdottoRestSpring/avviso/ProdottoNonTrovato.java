package it.devlecce.ProdottoRestSpring.avviso;

public class ProdottoNonTrovato extends RuntimeException{
    public ProdottoNonTrovato(Long id){
        super("Prodotto non trovato: " +id);
    }
}
