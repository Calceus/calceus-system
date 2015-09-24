package br.com.calceus.interfacesDAO;

import br.com.calceus.modelo.Cliente;

public interface ClienteDAO {
	public boolean adicionaCliente(Cliente cliente);
	public boolean alterarCliente(Cliente cliente); 
	public boolean excluirCliente(Cliente cliente); 
	public Cliente consultarCliente(int idCliente); 
	
}
