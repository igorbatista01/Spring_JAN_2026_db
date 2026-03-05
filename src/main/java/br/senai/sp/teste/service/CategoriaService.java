package br.senai.sp.teste.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senai.sp.teste.DTO.CategoriaListDTO;
import br.senai.sp.teste.mapper.CategoriaMapper;
import br.senai.sp.teste.model.Categoria;
import br.senai.sp.teste.repository.CategoriaRepository;


@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository repo;

	public Categoria inserir(Categoria c) {
		return repo.save(c);
	}
	
	public Categoria alterar(Categoria c) {
		return repo.save(c);
	}
	List<CategoriaListDTO> lista = new ArrayList<>();
    public List<CategoriaListDTO> buscar(String valor){
    	
		if (valor != null || valor.trim().isEmpty()) {
			return CategoriaMapper.toListDTO(repo.findAll());
		} else {
			return CategoriaMapper.toListDTO(repo.findByDescricaoContainingIgnoreCase(valor));
			
		}
		
    }

	public Categoria buscarPorId(Long id) {
		
		Optional<Categoria> o = repo.findById(id);
		return o.get();
	}
	
	public void excluir(Long id) {
		repo.deleteById(id);
	}
	
	public List<Categoria> buscarTodos() {
		return repo.findAll();
	}
	
	
}
