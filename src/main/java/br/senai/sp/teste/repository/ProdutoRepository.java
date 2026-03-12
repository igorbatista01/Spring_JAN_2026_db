package br.senai.sp.teste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senai.sp.teste.model.Categoria;
import br.senai.sp.teste.model.Fornecedor;
import br.senai.sp.teste.model.Produto;

@Repository
public interface ProdutoRepository 
           extends JpaRepository<Produto, Long> {
    
    List<Produto> findByCategoria(Categoria categoria);
    
    List<Produto> findByFornecedor(Fornecedor fornecedor);
    
    List<Produto> findByNomeContainingIgnoreCase(String nome);
}

