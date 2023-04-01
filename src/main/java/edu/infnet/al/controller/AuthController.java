



package edu.infnet.al.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.infnet.al.model.domain.Usuario;
import edu.infnet.al.model.repository.AuthRepository;

@Controller
public class AuthController {

	@GetMapping(value = "/login")
	public String telaLogin() {
		return "login";
	}

	@PostMapping(value = "/login")
	public String login(@RequestParam String email, @RequestParam String senha) {

		Usuario user = new Usuario(email, senha);

		if(AuthRepository.autenticar(user) != null) {
			return "redirect:/home";
		}

		return "redirect:/login";
	}
}