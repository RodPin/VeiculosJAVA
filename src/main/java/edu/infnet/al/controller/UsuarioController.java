package edu.infnet.al.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.infnet.al.model.domain.Usuario;
import edu.infnet.al.model.repository.UsuarioRepository;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UsuarioController {
	
	private String msg;

	@GetMapping(value = "/usuario")
	public String telaCadastro() {
		return "usuario/cadastro";
	}

	@GetMapping(value = "/usuario/lista")
	public String telaLista(Model model) {

		model.addAttribute("usuarios", UsuarioRepository.obterLista());
		
		model.addAttribute("mensagem", msg);
		
		msg = null;
		
		return "usuario/lista";
	}

	@PostMapping(value = "/usuario/incluir")
	public String incluir(Usuario usuario) {

		UsuarioRepository.incluir(usuario);
		
		msg = usuario.getNome()+ "Incluido com sucesso!";
		
		return "redirect:/";
	}
		
	@GetMapping(value = "/usuario/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		Usuario usuario = UsuarioRepository.excluir(id);
		
		msg = usuario.getNome()+"Excluido com sucesso!!!";

		return "redirect:/usuario/lista";
	}
}