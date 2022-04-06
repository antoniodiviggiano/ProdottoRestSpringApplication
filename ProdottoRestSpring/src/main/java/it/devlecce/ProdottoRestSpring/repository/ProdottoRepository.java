package it.devlecce.ProdottoRestSpring.repository;

import it.devlecce.ProdottoRestSpring.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {

}
