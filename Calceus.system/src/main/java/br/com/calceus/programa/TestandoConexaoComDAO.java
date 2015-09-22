package br.com.calceus.programa;

import java.sql.SQLException;

import br.com.calceus.DAO.ClienteDAO;
import br.com.calceus.modelo.Cliente;

public class TestandoConexaoComDAO {
	public static void main(String[] args) throws SQLException {
		 Cliente cliente = new Cliente(1,"Ativo",'s',1);
		 try {
		 ClienteDAO clienteDAO = new ClienteDAO();
		 clienteDAO.adicionaCliente(cliente);
		 } catch (SQLException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		ClienteDAO cliente2 = new ClienteDAO();
		Cliente cliente1 = new Cliente();
		cliente1 = cliente2.consultarCliente(1);
		cliente1.getIdCliente();

	}
}
