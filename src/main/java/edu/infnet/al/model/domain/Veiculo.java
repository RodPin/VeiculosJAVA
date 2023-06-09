package edu.infnet.al.model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.infnet.al.model.exceptions.VeiculoValorException;

@Entity
@Table(name = "TVeiculo")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Veiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String codigo;
	private float valor;
	public String marca;
	public String modelo;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	@ManyToMany(mappedBy = "veiculos")
	private List<Compra> compras; 
	
	public Veiculo() {
	}
	
	public Veiculo(String codigo,String marca, String modelo, float valor) throws VeiculoValorException {
		
		if(valor == 0) {
			throw new VeiculoValorException("O valor do veiculo nao pode ser 0!");
		}
		
		if(valor < 0) {
			throw new VeiculoValorException("O valor do veiculo nao pode ser menor que 0!");
		}

		this.codigo = codigo;
		this.modelo = modelo;
		this.marca = marca;
		this.valor = valor;
	}
	
	public abstract float calcularValorVenda();

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(codigo);
		sb.append(";");
		sb.append(modelo);
		sb.append(";");
		sb.append(valor);

		return sb.toString();
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCodigo() {
		return codigo;
	}
	public String getModelo() {
		return modelo;
	}
	public float getValor() {
		return valor;
	}

	public String getMarca() {
		return marca;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setModelo(String modelo) {
		this.modelo= modelo;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}	
}