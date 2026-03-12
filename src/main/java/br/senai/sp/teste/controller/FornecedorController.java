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

import br.senai.sp.teste.DTO.FornecedorDTO;
import br.senai.sp.teste.service.FornecedorService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/fornecedorcaminho")
public class FornecedorController {

	private final FornecedorService service;

	@Autowired
	public FornecedorController(FornecedorService service) {
		this.service = service;
	}

	@GetMapping()
	public String lista(Model model) {
		model.addAttribute("fornecedores", service.buscarTudo());
		return "fornecedorpasta/lista";
	}

	@GetMapping("/novo")
	public String novo(Model model) {
		model.addAttribute("fornecedor", new FornecedorDTO());
		return "fornecedorpasta/frm-fornecedor";
	}

	@GetMapping("/edita/{id}")
	public String edita(@PathVariable Long id, Model model) {
		model.addAttribute("fornecedor", service.buscarPorId(id));
		return "fornecedorpasta/frm-fornecedor";
	}

	@PostMapping("/gravar")
	public String gravar(@Valid @ModelAttribute("fornecedor") FornecedorDTO fornecedorDTO, BindingResult result) {
		if (result.hasErrors()) {
			return "fornecedorpasta/frm-fornecedor";
		}
		service.inserir(fornecedorDTO);
		return "redirect:/fornecedorcaminho";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable Long id) {
		service.excluir(id);
		return "redirect:/fornecedorcaminho";
	}

}