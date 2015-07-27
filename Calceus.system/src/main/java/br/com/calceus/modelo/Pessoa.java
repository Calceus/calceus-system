package br.com.calceus.modelo;

public class Pessoa {

	private int idPessoa;
	private int cpf;
	private int idade;
	private char sexo;
	private String nome;
	private String rg;
	private String email;
	public Pessoa(int idPessoa, int cpf, int idade, char sexo, String nome, String rg, String email) {
		this.idPessoa = idPessoa;
		this.cpf = cpf;
		this.idade = idade;
		this.sexo = sexo;
		this.nome = nome;
		this.rg = rg;
		this.email = email;
	}
	public int getIdPessoa() {
		return idPessoa;
	}
	public int getCpf() {
		return cpf;
	}
	public int getIdade() {
		return idade;
	}
	public char getSexo() {
		return sexo;
	}
	public String getNome() {
		return nome;
	}
	public String getRg() {
		return rg;
	}
	public String getEmail() {
		return email;
	}

	
}
