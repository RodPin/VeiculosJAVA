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
import edu.infnet.al.model.domain.Compra;
import edu.infnet.al.model.domain.Veiculo;
import edu.infnet.al.model.domain.Cliente;
import edu.infnet.al.model.service.CompraService;
import edu.infnet.al.model.service.VeiculoService;
import edu.infnet.al.model.service.ClienteService;

import java.util.ArrayList;
import java.util.List;

@Order(4)
@Component
public class ComprasLoader implements ApplicationRunner {
	
	@Autowired
	private CompraService compraService;
	
	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired
	private ClienteService clienteService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		try {
			
			try {
				FileReader fileR = new FileReader("compras.txt");
				BufferedReader leitura = new BufferedReader(fileR);

				String linha = leitura.readLine();			
				String[] compras = null;

				while(linha != null) {
					
					compras = linha.split(";");
					
					Usuario usuario = new Usuario();
					usuario.setId(1);
					
					Cliente cliente = clienteService.obterPorId(Integer.parseInt(compras[0]));
					List<Veiculo> veiculos = new ArrayList<Veiculo>();
					veiculos.add(veiculoService.obterPorId(Integer.parseInt(compras[1])));
					
					Compra compra= new Compra(
							cliente, 
							veiculos
						);
					compra.setUsuario(usuario);
					
					compraService.incluir(compra);

					System.out.println("Cliente Adicionada!");

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
