package edu.infnet.al.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import edu.infnet.al.model.domain.Carro;
import edu.infnet.al.model.domain.Usuario;
import edu.infnet.al.model.service.CarroService;

@Controller
public class CarroController {
	
	@Autowired
	private CarroService carroService;

	private String msg;

	@GetMapping(value = "/carro")
	public String telaCadastro() {
		return "carro/cadastro";
	}	
	
	@GetMapping(value = "/carro/lista")
	public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
		
		Collection<Carro> carros = carroService.obterLista(usuario);
		System.out.print(carros);
		model.addAttribute("carros", carros);

		model.addAttribute("mensagem", msg);
		
		msg = null;

		return "carro/lista";
	}
	
	@PostMapping(value = "/carro/incluir")
	public String incluir(Carro carro, @SessionAttribute("usuario") Usuario usuario) {
		
		System.out.print(carro);
		System.out.print(usuario);
		carro.setUsuario(usuario);

		carroService.incluir(carro);
		
		msg = "carro "+ carro.getModelo()+" Incluida!!!";
		
		return "redirect:/carro/lista";
	}
		
	@GetMapping(value = "/carro/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		Carro carro = carroService.obterPorId(id);
		
		carroService.excluir(id);
		
		msg = "carro "+carro.getModelo()+" excluida!";

		return "redirect:/carro/lista";
	}
}