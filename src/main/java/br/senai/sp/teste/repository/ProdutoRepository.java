package br.senai.sp.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senai.sp.teste.model.Produto;

@Repository
public interface ProdutoRepository 
           extends JpaRepository<Produto, Long>        {

}
