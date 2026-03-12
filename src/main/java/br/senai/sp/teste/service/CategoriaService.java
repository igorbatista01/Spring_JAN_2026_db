package br.senai.sp.teste.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senai.sp.teste.DTO.CategoriaListDTO;
import br.senai.sp.teste.exception.EntityInUseException;
import br.senai.sp.teste.mapper.CategoriaMapper;
import br.senai.sp.teste.model.Categoria;
import br.senai.sp.teste.repository.CategoriaRepository;
import br.senai.sp.teste.repository.ProdutoRepository;


@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository repo;
	
	@Autowired
	ProdutoRepository produtoRepo;

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
		// Buscar a categoria
		Optional<Categoria> categoria = repo.findById(id);
		
		if (categoria.isPresent()) {
			// Verificar se existem produtos associados
			List<?> produtosAssociados = produtoRepo.findByCategoria(categoria.get());
			
			if (produtosAssociados != null && !produtosAssociados.isEmpty()) {
				throw new EntityInUseException(
					"Não é possível excluir esta categoria pois existem " + 
					produtosAssociados.size() + " produto(s) associado(s) a ela. " +
					"Por favor, remova os produtos primeiro ou altere a categoria deles."
				);
			}
		}
		
		// Se não há produtos associados, prosseguir com a exclusão
		repo.deleteById(id);
	}
	
	public List<CategoriaListDTO> buscarTodos() {
		return CategoriaMapper.toListDTO(repo.findAll());
	}
	
	
}
