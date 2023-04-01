package edu.infnet.al.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.infnet.al.model.domain.Veiculo;
import org.springframework.data.domain.Sort;
@Repository
public interface VeiculoRepository extends CrudRepository<Veiculo, Integer> {

	@Query("from Veiculo v where v.usuario.id = :userId")
	List<Veiculo> obterLista(Integer userId, Sort sort);
}