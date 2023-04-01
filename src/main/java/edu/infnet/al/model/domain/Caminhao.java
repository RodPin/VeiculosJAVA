package edu.infnet.al.model.domain;
import javax.persistence.Entity;
import javax.persistence.Table;

import edu.infnet.al.model.exceptions.VeiculoValorException;

@Entity
@Table(name = "TCaminhao")
public class Caminhao extends Veiculo {
	private String  combustivel;
	
	public Caminhao() {
	}

	public Caminhao(String codigo, float valor, String marca, String modelo, String combustivel) throws VeiculoValorException {
		super(codigo, marca, modelo, valor);
		this.setCombustivel(combustivel);
	}

	@Override
	public float calcularValorVenda() {
		return this.getValor() + (combustivel == "diesel" ? 1000 : combustivel == "alcool"? 1500 : 2000);
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(combustivel);
		sb.append(";");
		sb.append(this.getMarca());

		return sb.toString();
	}
	

	public String getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}
}