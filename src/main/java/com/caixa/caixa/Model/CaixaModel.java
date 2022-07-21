package com.caixa.caixa.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CAIXA")
public class CaixaModel {
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY)long id;
	private Double entradaSaida;
	private String data;
	private Double total;
	private String descricao;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Double getTotal() {
		
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getEntradaSaida() {
		return entradaSaida;
	}
	public void setEntradaSaida(Double entradaSaida) {
		this.entradaSaida = entradaSaida;
	}
	
	
}