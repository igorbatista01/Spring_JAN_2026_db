package br.senai.sp.teste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.senai.sp.teste.model.Categoria;
import br.senai.sp.teste.service.CategoriaService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/categoriacaminho")
public class CategoriaController {

	private final CategoriaService service;

	@Autowired
	public CategoriaController(CategoriaService service) {
		this.service = service;
		
	}


	@GetMapping()
	public String lista(@RequestParam(name="descricao", required = false, defaultValue="") String descricao, Model model) {
	    
	    model.addAttribute("categorias", service.buscar(descricao));
	    model.addAttribute("descricao", descricao);
	    return "categoriapasta/lista";
	}
	
	
	@GetMapping("/novo")
	public String novo(Model model) {

		model.addAttribute("categoria", new Categoria());
		return "categoriapasta/frm-categoria";
	}
	
	@GetMapping("/edita/{id}")
	public String edita(@PathVariable Long id, Model model) {
			
			model.addAttribute("categoria", service.buscarPorId(id));	
		return "categoriapasta/frm-categoria";
	}
	
	@PostMapping("/gravar")
	public String gravar(@Valid @ModelAttribute("categoria")  Categoria categoria, BindingResult result) {
		
		if (result.hasErrors()) {
			return "categoriapasta/frm-categoria";
		}
		
		service.inserir(categoria);
		return "redirect:/categoriacaminho";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable Long id) {
		
		service.excluir(id);
		return "redirect:/categoriacaminho";
	}
	
	
}