package edu.infnet.al.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.infnet.al.model.domain.Caminhao;
import org.springframework.data.domain.Sort;

@Repository
public interface CaminhaoRepository extends CrudRepository<Caminhao, Integer> {

	@Query("from Caminhao b WHERE b.usuario.id = :userId")
	List<Caminhao> obterLista(Integer userId, Sort sort);
}