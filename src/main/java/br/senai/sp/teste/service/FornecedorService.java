package br.senai.sp.teste.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senai.sp.teste.DTO.FornecedorDTO;
import br.senai.sp.teste.mapper.FornecedorMapper;
import br.senai.sp.teste.model.Fornecedor;
import br.senai.sp.teste.repository.FornecedorRepository;

@Service
public class FornecedorService {
	@Autowired
	FornecedorRepository repo;

	public Fornecedor inserir(Fornecedor f) {
		return repo.save(f);
	}

	public Fornecedor alterar(Fornecedor f) {
		return repo.save(f);
	}

	public List<FornecedorDTO> buscar(String valor) {

		if (valor != null && (valor.trim()).isEmpty())
			return FornecedorMapper.toListDTO(repo.findAll());
		else
			return FornecedorMapper.toListDTO(repo.findByNomeContainingIgnoreCase(valor));

	}

	public FornecedorDTO buscarPorId(Long id) {
		Optional<Fornecedor> o = repo.findById(id);

		var dto = FornecedorMapper.toDTO(o.get());

		return dto;
	}

	public void excluir(Long id) {
		repo.deleteById(id);
	}

	public List<FornecedorDTO> buscarTodos() {
		return FornecedorMapper.toListDTO(repo.findAll());
	}

}