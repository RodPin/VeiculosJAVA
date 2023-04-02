package edu.infnet.al.loaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import edu.infnet.al.model.domain.Usuario;
import edu.infnet.al.model.service.UsuarioService;

@Order(1)
@Component
public class UsuarioLoader implements ApplicationRunner {

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Usuario userAdmin = new Usuario("Rodrigo Administrador", "admin@gmail.com", "123");
		userAdmin.setIdade(34);
		userAdmin.setTipo("Admin");
		userAdmin.setAdmin(true);
		usuarioService.incluir(userAdmin);
		
		System.out.println("Administrador "+userAdmin.getNome()+" Incluido!");
		
		for (int i = 0; i < 2; i++) {
			
			Usuario usuario = new Usuario("Administrador " + i, "admin"+i+"gmail.com", "0"+i);
			usuario.setIdade(i*4);
			usuario.setTipo("Admin");

			usuarioService.incluir(usuario);
		}

	}
}
