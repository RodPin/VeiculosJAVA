



package edu.infnet.al.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import edu.infnet.al.model.service.UsuarioService;

@Controller
@SessionAttributes("usuario")
public class AuthController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(value = "/login")
	public String telaLogin() {

		return "login";
	}
	
	@PostMapping(value = "/login")
	public String login(Model model, @RequestParam String email, @RequestParam String senha) {
		
		Usuario user = new Usuario(email, senha);
		
		user = usuarioService.autenticar(user);
		if(user != null) {
			model.addAttribute("usuario", user);
			
			return "redirect:/usuario/lista";
		}
		
		
		model.addAttribute("mensagem", "Credenciais incorretas!");

		return telaLogin();
	}
	
	@GetMapping(value = "/logout")
	public String logout(HttpSession session, SessionStatus status) {
		status.setComplete();
		
		session.removeAttribute("usuario");
		
		return "redirect:/home";
	}
}