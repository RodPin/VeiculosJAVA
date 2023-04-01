package edu.infnet.al.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.infnet.al.model.domain.Carro;

@Repository
public interface CarroRepository extends CrudRepository<Carro, Integer> {

	@Query("from Carro b WHERE b.usuario.id = :userId")
	List<Carro> obterLista(Integer userId);
}