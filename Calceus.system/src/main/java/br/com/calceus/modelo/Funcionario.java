package br.com.calceus.modelo;

import java.util.Calendar;

public class Funcionario extends Pessoa {

	private int idFuncionario;
	private String nomeFuncionario;
	private Calendar dataAdmissao;
	private int numCarteiraTrabalho;
	private String serieCarteiraTrabalho;
	private String numPIS;
	private double salario;
	private int idCargo;

	public Funcionario(int idFuncionario, String nomeFuncionario, Calendar dataAdmissao, int numCarteiraTrabalho,
			String serieCarteiraTrabalho, String numPIS, double salario, int idPessoa, int idCargo) {
		super();
		this.idFuncionario = idFuncionario;
		this.nomeFuncionario = nomeFuncionario;
		this.dataAdmissao = dataAdmissao;
		this.numCarteiraTrabalho = numCarteiraTrabalho;
		this.serieCarteiraTrabalho = serieCarteiraTrabalho;
		this.numPIS = numPIS;
		this.salario = salario;
		this.idPessoa = idPessoa;
		this.idCargo = idCargo;
	}

	

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public Calendar getDataAdmissao() {
		return dataAdmissao;
	}

	public int getNumCarteiraTrabalho() {
		return numCarteiraTrabalho;
	}

	public String getSerieCarteiraTrabalho() {
		return serieCarteiraTrabalho;
	}

	public String getNumPIS() {
		return numPIS;
	}

	public double getSalario() {
		return salario;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public int getIdCargo() {
		return idCargo;
	}

}
