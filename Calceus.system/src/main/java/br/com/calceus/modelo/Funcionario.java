package br.com.calceus.modelo;

import java.util.Calendar;

public class Funcionario {

	private int idFuncionario;
	private String nomeFuncionario;
	private Calendar dataAdmissao;
	private double salario;
	private int idCargo;

	public Funcionario() {
		// TODO Auto-generated constructor stub
	}

	public Funcionario(int idFuncionario, String nomeFuncionario, Calendar dataAdmissao, double salario, int idCargo) {
		this.idFuncionario = idFuncionario;
		this.nomeFuncionario = nomeFuncionario;
		this.dataAdmissao = dataAdmissao;
		this.salario = salario;
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

	public double getSalario() {
		return salario;
	}

	public int getIdCargo() {
		return idCargo;
	}

	@Override
	public String toString() {

		return "Funcionario " + this.getIdCargo() + " " + this.getIdFuncionario();
	}

}
