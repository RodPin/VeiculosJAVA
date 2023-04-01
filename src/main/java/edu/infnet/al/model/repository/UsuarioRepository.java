package edu.infnet.al.model.repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import java.util.HashMap;
import java.util.Map;

import edu.infnet.al.model.domain.Usuario;

public class UsuarioRepository {
	private static Integer id = 1;

	private static Map<Integer, Usuario> usuariosMap = new HashMap<Integer, Usuario>();
	
	public static boolean incluir(Usuario usuario) {
		usuario.setId(id++);
		try {
			usuariosMap.put(usuario.getId(), usuario);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	public static Usuario excluir(Integer key) {

		return usuariosMap.remove(key);
	}

	public static Collection<Usuario> obterLista(){
		return usuariosMap.values();
	}
	
}
