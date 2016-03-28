package br.com.calceus.ctrl;

import br.com.calceus.modelo.Cliente;
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
	public boolean cadastrarCliente(Cliente c) {
		
		Cliente cliente = new Cliente();
//		Endereco e = buscaCep(c.getEndereco().getCep());
		System.out.println(c.getEndereco().getLogradouro());
		int chaveEndereco = cadastrarEndereco(c.getEndereco());
		System.out.println(chaveEndereco);
		if(chaveEndereco > 0){
			c.getEndereco().setIdEndereco(chaveEndereco);
			
			System.out.println("Cadastrando cliente");
			return cliente.cadastrarCliente(c);
		}else{
			return false;
		}
		
	}
	
}
