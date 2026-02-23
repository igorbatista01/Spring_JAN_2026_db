package br.senai.sp.teste.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.senai.sp.teste.model.Produto;
import br.senai.sp.teste.repository.ProdutoRepository;
import br.senai.sp.teste.service.ProdutoService;

@Controller
@RequestMapping("/produtocaminho")
public class ProdutoController {

	@Autowired
	ProdutoService service;

	
	public ProdutoController() {	
		
	}


	@GetMapping()
	public String lista(Model model) {
		
		model.addAttribute("produtos", service.buscarTudo());
		
		return "produtopasta/lista";
	}
	
	
	@GetMapping("/novo")
	public String novo(Model model) {

		model.addAttribute("produto", new Produto());
		return "produtopasta/frm-produto";
	}
	
	@GetMapping("/edita/{id}")
	public String edita(@PathVariable Long id, Model model) {
			
			model.addAttribute("produto", service.buscarPorId(id));	
		return "produtopasta/frm-produto";
	}
	
	@PostMapping("/gravar")
	public String gravar(Produto produto) {
		
		service.inserir(produto);
		return "redirect:/produtocaminho";
	}
	

}
