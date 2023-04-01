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
		
		Usuario userAdmin = new Usuario("Administrador ", "admin@gmail.com", "123");
		userAdmin.setIdade(34);
		userAdmin.setSalario(1234);
		userAdmin.setSetor("Administracao");
		userAdmin.setTipo("Admin");

		usuarioService.incluir(userAdmin);
		
		System.out.println("Administrador "+userAdmin.getNome()+" Incluido!");
		
		for (int i = 0; i < 4; i++) {
			Usuario usuario = new Usuario("Administrador " + i, "admin"+i+"@admin.com", "0"+i);
			usuario.setIdade(i*4);
			usuario.setSalario(i*100);
			usuario.setSetor("Presidência " + i);
			usuario.setTipo("Admin " + i);

			usuarioService.incluir(usuario);
			
			System.out.println("Usuario "+usuario.getNome()+" Incluido!");
		}

	}
}
