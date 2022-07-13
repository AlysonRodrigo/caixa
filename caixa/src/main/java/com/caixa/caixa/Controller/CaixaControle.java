package com.caixa.caixa.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caixa.caixa.Model.CaixaModel;
import com.caixa.caixa.Repository.CaixaRepositorio;

@RestController
@RequestMapping("/caixa")
public class CaixaControle {
	private @Autowired CaixaRepositorio repositorio;
	
	
	CaixaModel att;
	@PutMapping("/att")
	public ResponseEntity<CaixaModel> Att(@Valid @RequestBody CaixaModel att) {
		
		
		
		System.out.println("------------------1 "+att.getEntrada());

		System.out.println("------------------2 "+att.getEntrada());
//		if(att.getSaida()<0) {
//			att.setSaida(att.getSaida()*-1);
//		}
		if(att.getSaida()==null) {
			att.setTotal(0.0);
		}
		
//		att.setTotal(-att.getSaida()+att.getEntrada());

//		System.out.println("------------------3 "+att.getEntrada());
		return ResponseEntity.status(201).body(repositorio.save(att));

		
	}
/*	@GetMapping("/todos")
	public ResponseEntity<List<CaixaModel>> pegarTodas() {
		List<CaixaModel> objetoLista = repositorio.findAll();
		List<CaixaModel> objetoLista = repositorio.findAllByTotal(att.getTotal());
		if (objetoLista.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(objetoLista);
		}
	}*/
	
}