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
import edu.infnet.al.model.domain.Moto;
import edu.infnet.al.model.domain.Usuario;
import edu.infnet.al.model.service.MotoService;

@Controller
public class MotoController {
	
	@Autowired
	private MotoService motoService;

	private String msg;

	@GetMapping(value = "/moto")
	public String telaCadastro() {
		return "moto/cadastro";
	}	
	
	@GetMapping(value = "/moto/lista")
	public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
		
		Collection<Moto> motos= motoService.obterLista(usuario);
		System.out.print(motos);
		model.addAttribute("motos", motos);

		model.addAttribute("mensagem", msg);
		
		msg = null;

		return "moto/lista";
	}
	
	@PostMapping(value = "/moto/incluir")
	public String incluir(Moto moto, @SessionAttribute("usuario") Usuario usuario) {
		
		System.out.print(moto);
		System.out.print(usuario);
		moto.setUsuario(usuario);

		motoService.incluir(moto);
		
		msg = "Moto "+ moto.getModelo()+" Incluida!!!";
		
		return "redirect:/moto/lista";
	}
		
	@GetMapping(value = "/moto/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		Moto moto = motoService.obterPorId(id);
		try {
			motoService.excluir(id);
			
			msg = "Moto "+moto.getModelo()+" excluida!";
		} catch (Exception e) {
			msg = "Moto "+moto.getModelo()+" nao pode ser excluido pois esta em uma relacao!";
		}
		return "redirect:/moto/lista";
	}
}