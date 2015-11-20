package br.com.calceus.ctrl;

import java.util.List;

import br.com.calceus.modelo.Fornecedor;

public class FornecedorCTRL {

	private Fornecedor fornecedor;
	public FornecedorCTRL() {
		
	}
	
	public boolean salvar(String razaoSocial, String cnpj, int telefone, String site, String obs){
		this.fornecedor = new Fornecedor(razaoSocial, cnpj, telefone, site, obs);
		
		return fornecedor.salvar(fornecedor);
	}

	public List<String> listar(){
		fornecedor = new Fornecedor();
		return fornecedor.listar();		
	}
	
	public List<Fornecedor> listarFornecedores(){
		fornecedor = new Fornecedor();
		return fornecedor.listarFornecedores();
	}

	public boolean excluir(int cod) {
		fornecedor = new Fornecedor();
		return fornecedor.excluir(cod);
	}
	
}
