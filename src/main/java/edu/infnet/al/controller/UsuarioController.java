package edu.infnet.al.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.infnet.al.model.domain.Usuario;
import edu.infnet.al.model.service.UsuarioService;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	private String msg;

	@GetMapping(value = "/usuario")
	public String telaCadastro() {
		return "usuario/cadastro";
	}

	@GetMapping(value = "/usuario/lista")
	public String telaLista(Model model) {
		model.addAttribute("usuarios", usuarioService.obterLista());
		
		model.addAttribute("mensagem", msg);
		
		msg = null;
		
		return "usuario/lista";
	}

	@PostMapping(value = "/usuario/incluir")
	public String incluir(Usuario usuario) {

		usuarioService.incluir(usuario);
		
		msg = usuario.getNome()+ "Incluido !";
		
		return "redirect:/usuario/lista";
	}
		
	@GetMapping(value = "/usuario/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		usuarioService.excluir(id);

		msg =  "Usuario com id "+id+" Excluido";
		

		return "redirect:/usuario/lista";
	}
}