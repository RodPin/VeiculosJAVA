package edu.infnet.al.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.infnet.al.model.domain.Moto;
import org.springframework.data.domain.Sort;
@Repository
public interface MotoRepository extends CrudRepository<Moto, Integer> {

	@Query("from Moto b WHERE b.usuario.id = :userId")
	List<Moto> obterLista(Integer userId, Sort sort);
}