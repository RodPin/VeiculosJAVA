



package edu.infnet.al.controller;

import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.infnet.al.model.domain.Usuario;
import edu.infnet.al.model.repository.AuthRepository;

@Controller
@SessionAttributes("usuario")
public class AuthController {

	@GetMapping(value = "/login")
	public String telaLogin() {

		return "login";
	}
	
	@PostMapping(value = "/login")
	public String login(Model model, @RequestParam String email, @RequestParam String senha) {
		
		Usuario user = new Usuario(email, senha);
		
		user = AuthRepository.autenticar(user);

		if(user != null) {
			model.addAttribute("usuario", user);
			
			return "redirect:/home";
		}
		
		model.addAttribute("mensagem", "Credenciais incorretas!");

		return telaLogin();
	}
	
	@GetMapping(value = "/logout")
	public String logout(HttpSession session, SessionStatus status) {
		status.setComplete();
		
		session.removeAttribute("usuario");
		
		return "redirect:/";
	}
}