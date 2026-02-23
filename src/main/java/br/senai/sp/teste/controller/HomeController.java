package br.senai.sp.teste.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class HomeController {
	@GetMapping
	public String home() {
		System.err.println("Passei por Aqui!");
		return "home/index";
	}
	
	@GetMapping("/params")
	public String homeParams(
			@RequestParam(name="nome")
					String nome,
			@RequestParam(name="idade")
			int idade	,		Model model			
			) {
		System.err.println(nome);
		
		model.addAttribute("attrNome", nome);
		model.addAttribute("attrIdade", idade);
		
		return "home/index2";
	}	

}
