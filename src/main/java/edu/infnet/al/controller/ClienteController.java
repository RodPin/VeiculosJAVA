package edu.infnet.al.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import edu.infnet.al.model.domain.Cliente;
import edu.infnet.al.model.service.ClienteService;
import edu.infnet.al.model.domain.Usuario;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	private String msg;

	@GetMapping(value = "/cliente")
	public String telaCadastro() {
		return "cliente/cadastro";
	}	

	@GetMapping(value = "/cliente/lista")
	public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
		
		model.addAttribute("clientes", clienteService.obterLista(usuario));
		
		model.addAttribute("mensagem", msg);
		
		msg = null;
		
		return "cliente/lista";
	}

	@PostMapping(value = "/cliente/incluir")
	public String incluir(Cliente cliente, @SessionAttribute("usuario") Usuario usuario) {
		
		cliente.setUsuario(usuario);

		clienteService.incluir(cliente);
		
		msg = "Cliente "+cliente.getNome()+" Incluido";
		
		return "redirect:/cliente/lista";
	}
		
	@GetMapping(value = "/cliente/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		try{
			clienteService.excluir(id);
		
			msg = "Cliente ("+id+") Excluido.";
		} catch (Exception e) {
			msg = "Exclusao do  ("+id+") nao e possivel pois esta relacionado em uma compra!";
		}

		return "redirect:/cliente/lista";
	}
}