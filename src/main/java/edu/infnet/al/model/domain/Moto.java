package edu.infnet.al.model.domain;
import javax.persistence.Entity;
import javax.persistence.Table;

import edu.infnet.al.model.exceptions.VeiculoValorException;

@Entity
@Table(name = "TMoto")
public class Moto extends Veiculo {
	private boolean turbo;
	
	public Moto() {
	}

	public Moto(String codigo, float valor, String marca, String modelo, Boolean turbo) throws VeiculoValorException {
		super(codigo, modelo, valor);
		this.setMarca(marca);
		this.setModelo(modelo);
		this.setTurbo(turbo);
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
		sb.append(marca);

		return sb.toString();
	}
	

	public Boolean getTurbo() {
		return turbo;
	}
	public void setTurbo(Boolean turbo) {
		this.turbo= turbo;
	}
}