package br.com.calceus.ctrl;

import br.com.calceus.DAO.EnderecoDAO;
import br.com.calceus.modelo.Endereco;

public class ManterCadastroClienteCTRL {

	public Endereco buscaCep(String cep){
		Endereco e = new Endereco();
		return e.buscaCep(cep);
	}
	public int cadastrarEndereco(Endereco e){
		Endereco endereco = new Endereco();
		return endereco.cadastrarEndereco(e);
	}
	public boolean alterarEndereco(Endereco e){
		Endereco endereco = new Endereco();
		return endereco.alterarEndereco(e);
	}
	public boolean excluirEndereco(int idEndereco){
		Endereco endereco = new Endereco();
		return endereco.excluirEndereco(idEndereco);
	}
	
	public Endereco consultarEndereco(int idEndereco){
		Endereco e = new Endereco();
		return e.consultarEndereco(idEndereco);
	}
	
}
