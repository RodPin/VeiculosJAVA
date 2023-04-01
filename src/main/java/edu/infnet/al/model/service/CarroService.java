package edu.infnet.al.model.service;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.infnet.al.model.domain.Carro;
import edu.infnet.al.model.domain.Usuario;
import edu.infnet.al.model.repository.CarroRepository;

@Service
public class CarroService {

	@Autowired
	private CarroRepository carroRepository;

	public Carro incluir(Carro carro) {
		return carroRepository.save(carro);
	}
	
	public void excluir(Integer id) {
		carroRepository.deleteById(id);
	}
	
	public Collection<Carro> obterLista(){
		return (Collection<Carro>) carroRepository.findAll();
	}
	
	public Collection<Carro> obterLista(Usuario usuario){
		System.out.print(carroRepository.obterLista(usuario.getId()));
		return (Collection<Carro>) carroRepository.obterLista(usuario.getId());
	}

	public Carro obterPorId(Integer id) {
		return carroRepository.findById(id).orElse(null);
	}
}