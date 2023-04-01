package edu.infnet.al.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.infnet.al.model.domain.Compra;

@Repository
public interface CompraRepository extends CrudRepository<Compra, Integer> {

	@Query("from Compra c WHERE c.usuario.id = :userId")
	List<Compra> obterLista(Integer userId);
}