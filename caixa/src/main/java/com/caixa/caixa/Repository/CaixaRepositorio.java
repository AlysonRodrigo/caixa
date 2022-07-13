package com.caixa.caixa.Repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caixa.caixa.Model.CaixaModel;

@Repository
public interface CaixaRepositorio extends JpaRepository<CaixaModel, Long> {

	Optional<CaixaModel> findAllByTotal(Double total);
	Optional<CaixaModel> findAllByEntrada(Double entrada);
	Optional<CaixaModel> findAllBySaida(Double saida);
	
}