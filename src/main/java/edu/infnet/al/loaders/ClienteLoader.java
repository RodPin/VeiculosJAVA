package edu.infnet.al.loaders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import edu.infnet.al.model.domain.Usuario;
import edu.infnet.al.model.domain.Cliente;
import edu.infnet.al.model.repository.UsuarioRepository;
import edu.infnet.al.model.service.ClienteService;

@Order(2)
@Component
public class ClienteLoader implements ApplicationRunner {
	
	@Autowired
	private ClienteService clienteService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		try {
			
			try {
				FileReader fileR = new FileReader("clientes.txt");
				BufferedReader leitura = new BufferedReader(fileR);

				String linha = leitura.readLine();			
				String[] clientes = null;

				while(linha != null) {
					
					clientes = linha.split(";");
					
					Usuario usuario = new Usuario();
					usuario.setId(1);
					
					Cliente cliente = new Cliente(
							clientes[0], 
							clientes[1], 
							clientes[2]
						);
					cliente.setUsuario(usuario);
					
					clienteService.incluir(cliente);

					System.out.println("Cliente "+cliente.getNome()+" Adicionado!");

					linha = leitura.readLine();
				}

				leitura.close();
				fileR.close();
			} catch (IOException e) {
				System.out.println("Erro: " + e.getMessage());
			} 
			
		} finally {
			System.out.println("Sucesso!!!");
		}		
	}
}
