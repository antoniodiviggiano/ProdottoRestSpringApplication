package it.devlecce.ProdottoRestSpring.avviso;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ProdottoNonTrovatoRisposta {
    @ResponseBody
    @ExceptionHandler(ProdottoNonTrovato.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String prodottoNonTrovato(ProdottoNonTrovato ex){
        return "Eccezione: " +ex.getMessage();
    }
}
