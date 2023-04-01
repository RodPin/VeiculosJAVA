package edu.infnet.al.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.infnet.al.model.domain.Usuario;
import edu.infnet.al.model.repository.UsuarioRepository;

@Controller
public class UsuarioController {

	@GetMapping(value = "/usuario")
	public String telaCadastro() {
		return "usuario/cadastro";
	}

	@GetMapping(value = "/usuario/lista")
	public String telaLista() {

		List<Usuario> lista = UsuarioRepository.obterLista();
		
		System.out.println("Quantidade de usuarios = " + lista.size());
		
		return "usuario/lista";
	}

	@PostMapping(value = "/usuario/incluir")
	public String incluir(Usuario usuario) {

		UsuarioRepository.incluir(usuario);
		
		return "redirect:/usuario/lista";
	}
}