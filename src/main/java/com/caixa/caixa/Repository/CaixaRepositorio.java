package com.caixa.caixa.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.caixa.caixa.Model.CaixaModel;

@Repository
public interface CaixaRepositorio extends JpaRepository<CaixaModel, Long> {
	
//	@Query(
//			value = "SELECT * FROM Caixa", 
//			nativeQuery = true)
//			Collection<CaixaModel> findById();
	
	@Query(value="select * FROM Caixa and data like='%2020%'", 
	nativeQuery = true)
	List<CaixaModel> findByCaixa();
	
//	@Query(value="select * FROM (select distinct data FROM Caixa) as dat", 
//	nativeQuery = true)
//	List<CaixaModel> findByData();
	
	
}