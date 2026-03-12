package br.senai.sp.teste.DTO;

import java.util.Set;

import br.senai.sp.teste.model.Categoria;
import br.senai.sp.teste.model.Estoque;
import br.senai.sp.teste.model.Fornecedor;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ProdutoListDTO {
	
	private long id;
	
	@NotBlank(message = "O nome do produto é obrigatório")
	@NotEmpty(message = "O nome do produto não pode ser vazio")
	@Size(min = 2, max = 100, message = "O nome do produto deve conter entre 2 e 100 caracteres")
	private String nome;
	
	@Min(0)
	private float preco;
	
	
	private CategoriaListDTO categoria;
	private Set<FornecedorDTO> fornecedores;
	private Estoque estoque;
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public CategoriaListDTO getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaListDTO categoria) {
		this.categoria = categoria;
	}
	public Set<FornecedorDTO> getFornecedores() {
		return fornecedores;
	}
	public void setFornecedores(Set<FornecedorDTO> fornecedores) {
		this.fornecedores = fornecedores;
	}
	public Estoque getEstoque() {
		return estoque;
	}
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
	
}

