package br.com.calceus.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.calceus.banco.GerenciadorDeConexoes;
import br.com.calceus.modelo.Cliente;

public class ClienteDAO {

	private Connection conn;

	public ClienteDAO() throws SQLException {
		try {
			this.conn = GerenciadorDeConexoes.getConnection("mysql", "localhost", "calceus", "root", "camila2015");
		} catch (Exception e) {
			// throw new Exception("Erro " + e.getMessage());
			System.out.println("Erro durante a conexão");
		}
	}

	public void adicionaCliente(Cliente cliente) {
		PreparedStatement pps = null;
		Connection conn = null;
		if (cliente == null) {
			System.out.println("O valor passado não pode ser nulo");
		}
		try {
			String comando = "INSERT INTO Cliente(idCliente,tipoCliente,status,idPessoa)" + "values(?,?,?,?)";
			conn = this.conn;
			pps = conn.prepareStatement(comando);
			pps.setInt(1, cliente.getIdCliente());
			pps.setInt(1, cliente.getTipoCliente());
			pps.setLong(3, cliente.getStatus());
			pps.setInt(4, cliente.getIdPessoa());
			pps.execute();
			pps.close();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir dados no banco");
		}finally {
			try {
				conn.close();
				System.out.println("Dados inseridos com sucesso");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				System.out.println("Erro ao fechar a conexão com banco!");
			}
		}

	}

	public void alterarCliente() {
	}

	public void excluirCliente() {
	}
	public Cliente consultarCliente(int idCliente) throws SQLException {
		PreparedStatement pps = null;
		Connection conn = null; 
		ResultSet rs = null; 
		Cliente cliente = null;
		try {
			conn = this.conn;
			pps = conn.prepareStatement("selec * from Clientes where id = ?");
			pps.setInt(1, idCliente);
			rs = pps.executeQuery();
			if(! rs.next()){
				throw new Exception("Não foi encontrado nenhum resultado para o ID:" + idCliente);
			}
			int id = rs.getInt(1);
			int tipo = rs.getInt(2);
			char status = (char) rs.getLong(3);
			int idPessoa = rs.getInt(4);
			
			cliente =  new Cliente(id, tipo, status,idPessoa); 
		} catch (Exception e) {
			System.out.println("erro ao executar operação");
		}finally {
			conn.close();
		}
		return cliente;
	}

}
