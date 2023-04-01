package edu.infnet.al.loaders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import edu.infnet.al.model.domain.Moto;
import edu.infnet.al.model.domain.Carro;
import edu.infnet.al.model.domain.Caminhao;
import edu.infnet.al.model.domain.Usuario;
import edu.infnet.al.model.service.MotoService;
import edu.infnet.al.model.service.CarroService;
import edu.infnet.al.model.service.CaminhaoService;


@Order(3)
@Component
public class VeiculoLoader implements ApplicationRunner {

	@Autowired
	private MotoService motoService;
	
	@Autowired
	private CarroService carroService;
	
	@Autowired
	private CaminhaoService caminhaoService;

	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		try {
	
			try {
				Usuario admin = new Usuario();
				admin.setId(1);
				
				FileReader fileR = new FileReader("veiculos.txt");
				BufferedReader leitura = new BufferedReader(fileR);

				String linha = leitura.readLine();			
				String [] fields = null;

				while(linha != null) {
					
					fields = linha.split(";");
					
					if(fields[0].charAt(0)=='M') {
						 Moto moto = new Moto(
									fields[1], 
									Integer.parseInt(fields[2]), 
									fields[3],
									fields[4],
									Boolean.parseBoolean(fields[5])
								);
							moto.setUsuario(admin);
							
							motoService.incluir(moto);
							System.out.println("Moto: "+ moto.getModelo()+" Adicionada!");
					}
					
					if(fields[0].charAt(0)== 'C') {
						Carro carro = new Carro(
									fields[1], 
									Integer.parseInt(fields[2]), 
									fields[3],
									fields[4],
									Integer.parseInt(fields[5])
								);
							carro.setUsuario(admin);
							
							carroService.incluir(carro);
							System.out.println("Carro: "+ carro.getModelo()+" Adicionada!");
					}
					
					if(fields[0].charAt(0)=='X') {
						Caminhao caminhao = new Caminhao(
									fields[1], 
									Integer.parseInt(fields[2]), 
									fields[3],
									fields[4],
									fields[5]
								);
						caminhao.setUsuario(admin);
							
							caminhaoService.incluir(caminhao);
							System.out.println("Caminhao"+ caminhao.getModelo()+" Adicionada!");
					}
					
					

					linha = leitura.readLine();
				}

				leitura.close();
				fileR.close();
			} catch (IOException e) {
				System.out.println("Erro: " + e.getMessage());
			} 
			
		} finally {
			System.out.println("Sucesso Add Veiculos!!!");
		}	
	}
} 