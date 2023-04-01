package edu.infnet.al.model.domain;
import javax.persistence.Entity;
import javax.persistence.Table;

import edu.infnet.al.model.exceptions.VeiculoValorException;

@Entity
@Table(name = "TCarro")
public class Carro extends Veiculo {
	private Integer portas;
	
	public Carro() {
	}

	public Carro(String codigo, float valor, String marca, String modelo, Integer portas) throws VeiculoValorException {
		super(codigo, marca, modelo, valor);
		this.setPortas(portas);
	}

	@Override
	public float calcularValorVenda() {
		return this.getValor() + (portas == 4 ? 2500 : 0);
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(portas);
		sb.append(";");
		sb.append(this.getMarca());

		return sb.toString();
	}
	

	public Integer getPortas() {
		return portas;
	}
	public void setPortas(Integer portas) {
		this.portas = portas;
	}
}