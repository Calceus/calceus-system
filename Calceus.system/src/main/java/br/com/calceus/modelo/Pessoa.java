package br.com.calceus.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public abstract class Pessoa {

	@Id
	@GeneratedValue
	protected int idPessoa;
	protected int cpf;
	protected String rg;
	protected int idade;
	protected char sexo;
	protected String nome;
	protected String email;

	/*public Pessoa(int idPessoa, int cpf, int idade, char sexo, String nome, String rg, String email) {
		this();
		this.idPessoa = idPessoa;
		this.cpf = cpf;
		this.idade = idade;
		this.sexo = sexo;
		this.nome = nome;
		this.rg = rg;
		this.email = email;
	}*/

	public Pessoa() {
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public int getIdPessoa() {
		return this.idPessoa;
	}

	public int getCpf() {
		return this.cpf;
	}

	public int getIdade() {
		return this.idade;
	}

	public char getSexo() {
		return this.sexo;
	}

	public String getNome() {
		return this.nome;
	}

	public String getRg() {
		return this.rg;
	}

	public String getEmail() {
		return this.email;
	}
	public  void mostra(){
		System.out.println(this.getIdPessoa());
		System.out.println(this.getNome());
		System.out.println(this.getCpf());
		System.out.println(this.getIdade());
		System.out.println(this.getSexo());
		System.out.println(this.getSexo());
		System.out.println(this.getEmail());
	}
	

}
