package edu.infnet.al.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import edu.infnet.al.model.domain.Veiculo;
import edu.infnet.al.model.domain.Usuario;
import edu.infnet.al.model.service.VeiculoService;


@Controller
public class VeiculoController {
	
	@Autowired
	private VeiculoService veiculoService;

	private String msg;

	@GetMapping(value = "/veiculo/lista")
	public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
		
		model.addAttribute("veiculos", veiculoService.obterLista(usuario));

		model.addAttribute("mensagem", msg);
		
		msg = null;

		return "veiculo/lista";
	}

	@GetMapping(value = "/veiculo/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		Veiculo veiculo= veiculoService.obterPorId(id);
		
		try {
			veiculoService.excluir(id);
			
			msg = "Veiculo "+veiculo.getModelo()+" Excluido!";
		} catch (Exception e) {
			msg = "Veiculo "+veiculo.getModelo()+" nao pode ser excluido";
		}
		
		return "redirect:/veiculo/lista";
	}
}