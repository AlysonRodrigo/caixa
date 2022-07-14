package com.caixa.caixa.Controller;

import java.util.List;

import javax.management.Query;
import javax.swing.JTextField;
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
		List<CaixaModel> Lista = repositorio.findAll();
		att.getId();
		att.getTotal();
		System.out.println("------------------1 "+att.getEntrada());
		
		System.out.println("------------------2 "+att.getEntrada());

		if(att.getSaida()<0) {
				att.setSaida(att.getSaida()*-1);
		}
		if(att.getSaida()==null) {
				att.setSaida(0.0);
		}
		if(att.getEntrada()<0) {
				att.setEntrada(att.getEntrada()*-1);
		}
		if(att.getEntrada()==null) {
				att.setEntrada(0.0);
		}
		if(att.getTotal()==null) {
			att.setTotal(att.getSaida()+ att.getEntrada());
	}
		System.out.println("--1 id-- "+ att.getId());
		System.out.println("--2 total-- "+ att.getTotal());
		System.out.println("--3 entrada-- "+ att.getEntrada());
		System.out.println("--4 saida-- "+ att.getSaida());
		System.out.println("--antes--__----____");
			for(CaixaModel list:Lista) {
				list.getId();
				list.getSaida();
				list.getEntrada();
				list.getTotal();
				att.setTotal(list.getSaida()+ list.getEntrada()+list.getTotal());
				System.out.println("--1 id-- "+ list.getId());
				System.out.println("--2 total-- "+ list.getTotal());
				System.out.println("--3 entrada-- "+ list.getEntrada());
				System.out.println("--4 saida-- "+ list.getSaida());
				
			}
			System.out.println("--depois--__--");
			System.out.println("--1 id-- "+ att.getId());
			System.out.println("--2 total-- "+ att.getTotal());
			System.out.println("--3 entrada-- "+ att.getEntrada());
			System.out.println("--4 saida-- "+ att.getSaida());
			
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