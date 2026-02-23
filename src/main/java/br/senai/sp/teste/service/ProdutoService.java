package br.senai.sp.teste.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senai.sp.teste.model.Produto;
import br.senai.sp.teste.repository.ProdutoRepository;

@Service
public class ProdutoService {
		
		@Autowired
		ProdutoRepository repo;

		public Produto inserir(Produto p) {
			return repo.save(p);
		}
		
		public Produto alterar(Produto p) {
			return repo.save(p);
		}
		
		public List<Produto> buscarTudo() {
			 return repo.findAll();
		}
		
		public Produto buscarPorId(Long id) {
			
			Optional<Produto> o = repo.findById(id);
			return o.get();
		}
		
		public void excluir(Long id) {
			repo.deleteById(id);
		}
	
}
