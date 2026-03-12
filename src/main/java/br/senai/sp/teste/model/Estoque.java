package br.senai.sp.teste.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;

@Entity
public class Estoque {
	
	@Id
	private Long id;
	@Min(value = 0)
	private Integer qtdProduto;
	@OneToOne(optional = false)
	@MapsId
	@JoinColumn(name = "produto_id")
	private Produto produto;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getQtdProduto() {
		return qtdProduto;
	}
	public void setQtdProduto(Integer qtdProduto) {
		this.qtdProduto = qtdProduto;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}