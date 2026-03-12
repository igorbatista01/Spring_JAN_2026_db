package br.senai.sp.teste.service;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jspecify.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.TypeToken;

import br.senai.sp.teste.DTO.ProdutoListDTO;
import br.senai.sp.teste.model.Produto;
import br.senai.sp.teste.repository.ProdutoRepository;

@Service
public class ProdutoService {
		
		@Autowired
		ProdutoRepository repo;

		public ProdutoListDTO inserir(ProdutoListDTO p) {
			ModelMapper mapper = new ModelMapper();
			return mapper.map(
					repo.save(
							mapper.map(p, Produto.class)
							), ProdutoListDTO.class); 
		}
		
		public Produto alterar(Produto p) {
			return repo.save(p);
		}
		
		public List<ProdutoListDTO> buscar(String nome){
			
			ModelMapper mapper = new ModelMapper();
			
			Type listType = new TypeToken<List<ProdutoListDTO>>() {}.getType();
			if(nome != null && (nome.trim()).equals(""))
				
				return mapper.map(repo.findAll(), listType);
			else
				return mapper.map(repo.findByNomeContainingIgnoreCase(nome), listType);
		}
		
		public List<Produto> buscarTudo() {
			 return repo.findAll();
		}
		
		public ProdutoListDTO buscarPorId(Long id) {
			
			Optional<Produto> o = repo.findById(id);
			ModelMapper mapper = new ModelMapper();
			return mapper.map(o.get(), ProdutoListDTO.class);
		}
		
		public void excluir(Long id) {
			repo.deleteById(id);
		}

		
		
	
}
