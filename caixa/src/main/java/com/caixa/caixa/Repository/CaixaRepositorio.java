package com.caixa.caixa.Repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.caixa.caixa.Model.CaixaModel;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@Repository
public interface CaixaRepositorio extends JpaRepository<CaixaModel, Long> {
	
	@Query(value = "SELECT * FROM caixa")
	List<CaixaModel> findAllUsers(Sort sort);
	
	
}