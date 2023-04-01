package edu.infnet.al.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import edu.infnet.al.model.domain.Compra;
import edu.infnet.al.model.domain.Usuario;
import edu.infnet.al.model.service.CompraService;
import edu.infnet.al.model.service.VeiculoService;
import edu.infnet.al.model.service.ClienteService;

@Controller
public class CompraController {
	
	@Autowired
	private CompraService compraService;
	@Autowired
	private ClienteService clientService;
	@Autowired
	private VeiculoService veiculoService;

	private String msg;

	@GetMapping(value = "/compra")
	public String telaCadastro(Model model, @SessionAttribute("usuario") Usuario usuario) {
		
		model.addAttribute("clientes", clientService.obterLista(usuario));
				
		model.addAttribute("veiculos", veiculoService.obterLista(usuario));

		return "compra/cadastro";
	}	

	@GetMapping(value = "/compra/lista")
	public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
		
		model.addAttribute("compras", compraService.obterLista(usuario));

		model.addAttribute("mensagem", msg);
		
		msg = null;

		return "compra/lista";
	}
	
	@PostMapping(value = "/compra/incluir")
	public String incluir(Compra compra, @SessionAttribute("usuario") Usuario usuario) {
		
		compra.setUsuario(usuario);

		compraService.incluir(compra);

		msg = "Compra "+compra.getDescricao()+" Adicionada!";
		
		return "redirect:/compra/lista";
	}
		
	@GetMapping(value = "/compra/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		Compra compra = compraService.obterPorId(id);
		
		compraService.excluir(id);
		
		msg = "Compra "+compra.getDescricao()+" Excluida!";

		return "redirect:/compra/lista";
	}
}