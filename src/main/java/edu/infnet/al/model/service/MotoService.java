package edu.infnet.al.model.service;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.infnet.al.model.domain.Moto;
import edu.infnet.al.model.domain.Usuario;
import edu.infnet.al.model.repository.MotoRepository;

@Service
public class MotoService {

	@Autowired
	private MotoRepository motoRepository;

	public Moto incluir(Moto moto) {
		return motoRepository.save(moto);
	}
	
	public void excluir(Integer id) {
		motoRepository.deleteById(id);
	}
	
	public Collection<Moto> obterLista(){
		return (Collection<Moto>) motoRepository.findAll();
	}
	
	public Collection<Moto> obterLista(Usuario usuario){
		return (Collection<Moto>) motoRepository.obterLista(usuario.getId());
	}

	public Moto obterPorId(Integer id) {
		return motoRepository.findById(id).orElse(null);
	}
}