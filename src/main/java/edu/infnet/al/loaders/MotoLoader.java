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
import edu.infnet.al.model.service.MotoService;

@Order(3)
@Component
public class MotoLoader implements ApplicationRunner {

	@Autowired
	private MotoService motoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		try {
	
			try {
				FileReader fileR = new FileReader("motos.txt");
				BufferedReader leitura = new BufferedReader(fileR);

				String linha = leitura.readLine();			
				String [] motosFields = null;

				while(linha != null) {
					
					motosFields = linha.split(";");

					Moto moto = new Moto(
							motosFields[0], 
							Integer.parseInt(motosFields[0]), 
							motosFields[2],
							motosFields[3],
							Boolean.parseBoolean(motosFields[4])
						);
					
					motoService.incluir(moto);

					System.out.println("Moto: "+ moto.getModelo()+" Adicionada!");

					linha = leitura.readLine();
				}

				leitura.close();
				fileR.close();
			} catch (IOException e) {
				System.out.println("Erro: " + e.getMessage());
			} 
			
		} finally {
			System.out.println("Sucesso Motos!!!");
		}	
	}
} 