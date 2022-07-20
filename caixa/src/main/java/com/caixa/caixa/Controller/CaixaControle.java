package com.caixa.caixa.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caixa.caixa.Model.CaixaModel;
import com.caixa.caixa.Repository.CaixaRepositorio;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@RestController
@RequestMapping("/caixa")
public class CaixaControle {
	private @Autowired CaixaRepositorio repositorio;
	Double totalParcial;
	
	
	@PutMapping("/att")
	public ResponseEntity<CaixaModel> Att(@Valid @RequestBody CaixaModel att) {

		LocalDate data1 = LocalDate.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		String datas = data1.format(myFormatObj);
		
		List<CaixaModel> Lista = repositorio.findAll();
		if(att.getEntradaSaida()==null) {
			att.setEntradaSaida(0.0);
		}
		if(att.getTotal()==null ) {
			att.setTotal(att.getEntradaSaida());
		}
		totalParcial=0.0;
		for(CaixaModel list:Lista) {
			if(list.getId()==1) {
				att.setTotal(0.0);
			}
			if(att.getId()==0) {
				att.setTotal(list.getTotal()+att.getEntradaSaida());
			}
			if(list.getId()==att.getId()) {
				att.setTotal(att.getEntradaSaida()+totalParcial);
			}
			if(list.getId()>att.getId() && att.getId()!=0) {
				list.setTotal(totalParcial+list.getEntradaSaida());
			}
			totalParcial= list.getTotal();
			
		}
		if(att.getData()==null) {
			att.setData(datas);
		}
		return ResponseEntity.status(201).body(repositorio.save(att));
	}
	
	
	@DeleteMapping("/deletar/{id}")
	public void deletarClientePorId(@PathVariable(value = "id") Long id) {
		repositorio.deleteById(id);
	}
	
	@GetMapping("/todos")
	public ResponseEntity<List<CaixaModel>> pegarTodes() {
		List<CaixaModel> Listas = repositorio.findAll();

		if (Listas.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(Listas);
		}

	}
	
}