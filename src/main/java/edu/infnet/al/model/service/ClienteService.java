package edu.infnet.al.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.infnet.al.model.domain.Cliente;
import edu.infnet.al.model.domain.Usuario;
import edu.infnet.al.model.repository.ClienteRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente incluir(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public void excluir(Integer key) {
		clienteRepository.deleteById(key);
	}

	public Collection<Cliente> obterLista(){
		return (Collection<Cliente>) clienteRepository.findAll();
	}

	public Collection<Cliente> obterLista(Usuario usuario){
		return clienteRepository.obterLista(usuario.getId(),Sort.by(Direction.ASC, "nome"));
	}
}