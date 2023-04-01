package edu.infnet.al.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

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
		
		model.addAttribute("motos", motoService.obterLista(usuario));

		model.addAttribute("mensagem", msg);
		
		msg = null;

		return "moto/lista";
	}
	
	@PostMapping(value = "/moto/incluir")
	public String incluir(Moto moto, @SessionAttribute("usuario") Usuario usuario) {
		
		moto.setUsuario(usuario);

		motoService.incluir(moto);
		
		msg = "Moto "+moto.getNome()+" Incluida!!!";
		
		return "redirect:/moto/lista";
	}
		
	@GetMapping(value = "/moto/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		Moto moto = motoService.obterPorId(id);
		
		motoService.excluir(id);
		
		msg = "Moto "+moto.getNome()+" excluida!";

		return "redirect:/moto/lista";
	}
}