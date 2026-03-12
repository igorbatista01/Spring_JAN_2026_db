package br.senai.sp.teste.model;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Espaço em branco.")
	@NotEmpty(message = "Campo obrigatório!")
	@Size(min = 2, max = 100, message = "Valores entre 2 e 100.")
	@Column(length = 100, unique = true)
	private String nome;
	
	@NotBlank(message = "Espaço em branco.")
	@NotEmpty(message = "Campo obrigatório!")
	@Size(min = 2, max = 100, message = "Valores entre 2 e 100.")
	@Column(length = 100)	
	private String contato;
	
	@ManyToMany(mappedBy = "fornecedores")
	private Set<Produto> produtos = new LinkedHashSet<>();

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

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Fornecedor() {}
	
	public Fornecedor(Long id,
			@NotBlank(message = "Espaço em branco.") @NotEmpty(message = "Campo obrigatório!") @Size(min = 2, max = 100, message = "Valores entre 2 e 100.") String nome,
			@NotBlank(message = "Espaço em branco.") @NotEmpty(message = "Campo obrigatório!") @Size(min = 2, max = 100, message = "Valores entre 2 e 100.") String contato) {

		this.id = id;
		this.nome = nome;
		this.contato = contato;
	}

	public Set<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
	
}