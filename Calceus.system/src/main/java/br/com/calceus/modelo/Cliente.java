package br.com.calceus.modelo;

import java.util.Calendar;


public class Cliente {

	private int idCliente;
	private String tipoCliente;
	private String status;
	protected String nome;
	protected int cpf;
	protected String sexo;
	protected Calendar dataNascimento;
	private int telefone;
	private int celular;
	protected String email;
	private String senha;

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(int idCliente, String tipoCliente, String status, String nome, int cpf, String sexo,
			Calendar dataNascimento, int telefone, int celular, String email) {
		this.idCliente = idCliente;
		this.tipoCliente = tipoCliente;
		this.status = status;
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getCpf() {
		return this.cpf;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSexo() {
		return this.sexo;
	}

	public String getNome() {
		return this.nome;
	}

	public String getEmail() {
		return this.email;
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public String getTipoCliente() {
		return this.tipoCliente;
	}

	public String getStatus() {
		return this.status;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	

	@Override
	public String toString() {
		return "Cliente " + this.getNome();
	}

}
