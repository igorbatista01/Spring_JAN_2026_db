package br.senai.sp.teste.controller;

import java.util.List;
import java.util.Optional;

import javax.sound.midi.SysexMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.senai.sp.teste.DTO.ProdutoListDTO;
import br.senai.sp.teste.model.Produto;
import br.senai.sp.teste.repository.ProdutoRepository;
import br.senai.sp.teste.service.CategoriaService;
import br.senai.sp.teste.service.FornecedorService;
import br.senai.sp.teste.service.ProdutoService;

@Controller
@RequestMapping("/produtocaminho")
public class ProdutoController {
	
	@Autowired
	ProdutoService service;
	
	@Autowired
	CategoriaService serviceCat;
	
	@Autowired
	FornecedorService serviceForn;

	public ProdutoController() {	
	}

	@GetMapping()
	public String lista(
	@RequestParam(name="nome", required = false, 
	     defaultValue = "")String nome,
			Model model) {
		
		model.addAttribute("produtos", service.buscar(nome));
		
		model.addAttribute("nome", nome);
		
		return "produtopasta/lista";
	}
	
	
	@GetMapping("/novo")
	public String novo(Model model) {
		model.addAttribute("produto", new ProdutoListDTO());
		model.addAttribute("categorias", serviceCat.buscarTodos());
		model.addAttribute("fornecedores", serviceForn.buscarTodos());
		
		return "produtopasta/frm-produto";
	}
	
	@GetMapping("/edita/{id}")
	public String edita(@PathVariable Long id, Model model) {
			model.addAttribute("produto", service.buscarPorId(id));
			model.addAttribute("categorias", serviceCat.buscarTodos());
			model.addAttribute("fornecedores", serviceForn.buscarTodos());
		return "produtopasta/frm-produto";
	}
	
	@GetMapping("/exclui/{id}")
	public String excluir(@PathVariable Long id) {
		
		service.excluir(id);
			
		return "redirect:/produtocaminho";
	}	
	
	@PostMapping("/gravar")
	public String gravar(ProdutoListDTO produto) {
		produto = service.inserir(produto);
		
		return "redirect:/produtocaminho";
	}
	

}