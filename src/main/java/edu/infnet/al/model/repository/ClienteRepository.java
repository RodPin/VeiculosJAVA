package edu.infnet.al.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.infnet.al.model.domain.Cliente;
import org.springframework.data.domain.Sort;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

	@Query("from Cliente c WHERE c.usuario.id = :userId")
	List<Cliente> obterLista(Integer userId, Sort sort);
}