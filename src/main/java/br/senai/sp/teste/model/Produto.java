package br.senai.sp.teste.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private float preco;
	// O Option false é para dizer que o produto tem que ter uma categoria, ou seja, não pode ser nulo
	@ManyToOne(fetch = jakarta.persistence.FetchType.EAGER, optional = false)
	@JoinColumn(name="categoriaId", nullable = false)
	
	private Categoria categoria;
	
	public Produto() {}
	
	public Produto(Long id, String nome, float preco) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	

}
