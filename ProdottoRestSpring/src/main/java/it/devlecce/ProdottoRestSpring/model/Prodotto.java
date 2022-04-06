package it.devlecce.ProdottoRestSpring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class Prodotto {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private float prezzo;
    private Date datadiacquisto;

    public Prodotto() {
    }

    public Prodotto(Long id, String nome, float prezzo, Date datadiacquisto) {
        this.id = id;
        this.nome = nome;
        this.prezzo = prezzo;
        this.datadiacquisto = datadiacquisto;
    }

    public Prodotto(String nome, float prezzo, Date datadiacquisto) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.datadiacquisto = datadiacquisto;
    }

    public Prodotto(String nome, float prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
    }

    public Prodotto(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public Date getDatadiacquisto() {
        return datadiacquisto;
    }

    public void setDatadiacquisto(Date datadiacquisto) {
        this.datadiacquisto = datadiacquisto;
    }
}
