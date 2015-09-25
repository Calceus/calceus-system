package br.com.calceus.DAO.interfaces;

import java.util.List;

import br.com.calceus.modelo.Cliente;

public interface ClienteDAO {
	public boolean adicionarCliente(Cliente cliente);
	public boolean alterarCliente(Cliente cliente); 
	public boolean excluirCliente(Cliente cliente); 
	public Cliente consultarCliente(int idCliente); 
	public Cliente consultarPorLogin(String login);
	public List<Cliente> listar();//método usado pelo administrador do sistema
	boolean adicionaCliente(Cliente cliente);
	
}
