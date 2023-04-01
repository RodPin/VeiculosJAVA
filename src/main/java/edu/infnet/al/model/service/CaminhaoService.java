package edu.infnet.al.model.service;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.infnet.al.model.domain.Caminhao;
import edu.infnet.al.model.domain.Usuario;
import edu.infnet.al.model.repository.CaminhaoRepository;

@Service
public class CaminhaoService {

	@Autowired
	private CaminhaoRepository caminhaoRepository;

	public Caminhao incluir(Caminhao caminhao) {
		return caminhaoRepository.save(caminhao);
	}
	
	public void excluir(Integer id) {
		caminhaoRepository.deleteById(id);
	}
	
	public Collection<Caminhao> obterLista(){
		return (Collection<Caminhao>) caminhaoRepository.findAll();
	}
	
	public Collection<Caminhao> obterLista(Usuario usuario){
		System.out.print(caminhaoRepository.obterLista(usuario.getId()));
		return (Collection<Caminhao>) caminhaoRepository.obterLista(usuario.getId());
	}

	public Caminhao obterPorId(Integer id) {
		return caminhaoRepository.findById(id).orElse(null);
	}
}