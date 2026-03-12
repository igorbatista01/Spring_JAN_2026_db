package br.senai.sp.teste.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class FornecedorDTO {

	private Long id;

	@NotBlank(message = "Espaço em branco.")
	@NotEmpty(message = "Campo obrigatório!")
	@Size(min = 2, max = 100, message = "Valores entre 2 e 100.")
	private String nome;

	@NotBlank(message = "Espaço em branco.")
	@NotEmpty(message = "Campo obrigatório!")
	@Size(min = 2, max = 100, message = "Valores entre 2 e 100.")
	private String contato;

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

	public FornecedorDTO(Long id, String nome, String contato) {
		setId(id);
		setNome(nome);
		setContato(contato);
	}

	public FornecedorDTO() {
	}

}