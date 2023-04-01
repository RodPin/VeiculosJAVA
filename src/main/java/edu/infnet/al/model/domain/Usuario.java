package edu.infnet.al.model.domain;

public class Usuario {
	
	private Integer id;
	private String nome;
	private String senha;
	private String email;
	private String[] caracteristicas;
	private String tipo;
	private String setor;
	private int idade;
	private float salario;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Usuario(String email, String senha) {
		this.setEmail(email);
		this.setSenha(senha);
	}
	
	public Usuario(String nome, String email, String senha) {
		this(email, senha);
		this.setNome(nome);
	}
	
	@Override
	public String toString() {

		return String.format(
				"Nome: %s Emaik: %s Senha:%s, Idade:%d Salario:R$%.2f. "
				+ "Tipo: %s Setor: %s Caracteristicas: %d", 
				nome,
				email,
				senha,
				idade,
				salario,
				tipo,
				setor,
				caracteristicas.length
			);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String[] getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(String[] caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
}