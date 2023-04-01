package  edu.infnet.al.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.infnet.al.model.domain.Compra;
import edu.infnet.al.model.domain.Usuario;
import edu.infnet.al.model.repository.CompraRepository;

@Service
public class CompraService {

	@Autowired
	private CompraRepository compraRepository;

	public Compra incluir(Compra compra) {
		return compraRepository.save(compra);
	}
	
	public void excluir(Integer id) {
		compraRepository.deleteById(id);
	}
	
	public Collection<Compra> obterLista(){
		return (Collection<Compra>) compraRepository.findAll();
	}
	
	public Collection<Compra> obterLista(Usuario usuario){
		return (Collection<Compra>) compraRepository.obterLista(usuario.getId());
	}

	public Compra obterPorId(Integer id) {
		return compraRepository.findById(id).orElse(null);
	}
}