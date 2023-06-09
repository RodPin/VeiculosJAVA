package edu.infnet.al.model.repository;

import edu.infnet.al.model.domain.Usuario;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	@Query("from Usuario u WHERE u.email = :email AND u.senha = :senha")
	Usuario autenticacao(String email, String senha);
}