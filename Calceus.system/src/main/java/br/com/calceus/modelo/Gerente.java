package br.com.calceus.modelo;

import java.util.Calendar;

public class Gerente extends Funcionario{

	public Gerente(int idFuncionario, String nomeFuncionario, Calendar dataAdmissao, int numCarteiraTrabalho,
			String serieCarteiraTrabalho, String numPIS, double salario, int idPessoa, int idCargo) {
		super(idFuncionario, nomeFuncionario, dataAdmissao, numCarteiraTrabalho, serieCarteiraTrabalho, numPIS, salario,
				idPessoa, idCargo);
		
	}

    
}
