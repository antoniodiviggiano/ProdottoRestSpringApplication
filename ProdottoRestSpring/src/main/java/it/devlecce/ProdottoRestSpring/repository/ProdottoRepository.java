package it.devlecce.ProdottoRestSpring.repository;

import it.devlecce.ProdottoRestSpring.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {
    List<Prodotto> findByDatadiacquistoBetween(Date datada, Date dataa);
    List<Prodotto> findByNome(String nome);

}
