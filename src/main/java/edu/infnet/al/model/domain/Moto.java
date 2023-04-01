package edu.infnet.al.model.domain;
import javax.persistence.Entity;
import javax.persistence.Table;

import edu.infnet.al.model.exceptions.VeiculoValorException;

@Entity
@Table(name = "TMoto")
public class Moto extends Veiculo {

	private boolean turbo;
	private int tamanho;
	private String modelo;
	
	public Moto() {
	}

	public Moto(String codigo, String nome, float valor, String marca, String modelo) throws VeiculoValorException {
		super(codigo, nome, valor);
		this.setMarca(marca);
		this.setModelo(modelo);
	}

	@Override
	public float calcularValorVenda() {
		return this.getValor() + (turbo ? 3000 : 0);
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(turbo ? "Com turbo" : "Sem turbo");
		sb.append(";");
		sb.append(tamanho);
		sb.append(";");
		sb.append(marca);

		return sb.toString();
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
}