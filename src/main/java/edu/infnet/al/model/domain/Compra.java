package edu.infnet.al.model.domain;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import edu.infnet.al.model.exceptions.*;


@Entity
@Table(name = "TCompra")
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private LocalDateTime data;
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
	@ManyToMany(cascade = CascadeType.DETACH)
	private List<Veiculo> veiculos;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	public Compra() {
	// TODO Auto-generated constructor stub
	}
	public Compra(Cliente cliente, List<Veiculo> veiculos) throws CompraSemClienteException, CompraSemVeiculoException {
		this();
		if(cliente == null) {
			throw new CompraSemClienteException("Não ha um cliente associado a compra!");
		}
		if(veiculos == null) {
			throw new CompraSemVeiculoException("Não ha um veiculo associado a compra!");
	}

    	this.cliente = cliente;
    	this.veiculos = veiculos;

    	data = LocalDateTime.now();
    }

    public void imprimir(){
    	System.out.println("Pedido: " + this);
    	System.out.println("Cliente: " + cliente);
    	System.out.println("Qtde Veiculos: " + veiculos.size());
    	System.out.println("Veiculos:");
    	for(Veiculo v : veiculos) {
    		System.out.println("- " + v.getModelo());
    	}
    }

    public String obterLinha() {
    	DateTimeFormatter formato = DateTimeFormatter.ofPattern("MM/yyyy");

    	return this.getData().format(formato)+";"+
    		   this.getDescricao()+";"+
    		   this.getCliente()+";"+
    		   this.getVeiculos().size()+"\r\n";
    }


    @Override
    public String toString() {

    	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    	return  String.format("%s;%s;%s",
    			descricao,
    			data.format(formato)
    		);
    }

    public Integer getId() {
    	return id;
    }

    public void setId(Integer id) {
    	this.id = id;
    }

    public String getDescricao() {
    	return descricao;
    }

    public void setDescricao(String descricao) {
    	this.descricao = descricao;
    }

    public LocalDateTime getData() {
    	return data;
    }

    public void setData(LocalDateTime data) {
    	this.data = data;
    }

    public Cliente getCliente() {
    	return cliente;
    }

    public void setCliente(Cliente cliente) {
    	this.cliente = cliente;
    }

    public List<Veiculo> getVeiculos() {
    	return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
    	this.veiculos = veiculos;
    }

    public Usuario getUsuario() {
    	return usuario;
    }

    public void setUsuario(Usuario usuario) {
    	this.usuario = usuario;
    }

}
