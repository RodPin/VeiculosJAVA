package edu.infnet.al.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import edu.infnet.al.model.domain.Caminhao;
import edu.infnet.al.model.domain.Usuario;
import edu.infnet.al.model.service.CaminhaoService;

@Controller
public class CaminhaoController {
	
	@Autowired
	private CaminhaoService caminhaoService;

	private String msg;

	@GetMapping(value = "/caminhao")
	public String telaCadastro() {
		return "caminhao/cadastro";
	}	
	
	@GetMapping(value = "/caminhao/lista")
	public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
		
		Collection<Caminhao> caminhaos = caminhaoService.obterLista(usuario);
		System.out.print(caminhaos);
		model.addAttribute("caminhaos", caminhaos);

		model.addAttribute("mensagem", msg);
		
		msg = null;

		return "caminhao/lista";
	}
	
	@PostMapping(value = "/caminhao/incluir")
	public String incluir(Caminhao caminhao, @SessionAttribute("usuario") Usuario usuario) {
		
		System.out.print(caminhao);
		System.out.print(usuario);
		caminhao.setUsuario(usuario);

		caminhaoService.incluir(caminhao);
		
		msg = "Caminhao "+ caminhao.getModelo()+" Incluido!!!";
		
		return "redirect:/caminhao/lista";
	}
		
	@GetMapping(value = "/caminhao/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		Caminhao caminhao = caminhaoService.obterPorId(id);
		
		try {
			caminhaoService.excluir(id);
			
			msg = "Caminhao "+caminhao.getModelo()+" excluida!";
		} catch (Exception e) {
			msg = "Caminhao "+caminhao.getModelo()+" nao pode ser excluido pois esta em uma relacao!";
		}

		return "redirect:/caminhao/lista";
	}
}