package edu.infnet.al.model.repository;

import edu.infnet.al.model.domain.Usuario;

public class AuthRepository {
	public static Usuario autenticar(Usuario usuario) {

		if(usuario.getEmail().equalsIgnoreCase(usuario.getSenha())) {
			return new Usuario("Administrador", usuario.getEmail(), usuario.getSenha());
		}

		return null;
	}
}
