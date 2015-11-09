package br.com.calceus.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.calceus.conexao.GerenciadorDeConexoes;
import br.com.calceus.modelo.Cliente;

public class ClienteDAO {

	

	public void adicionaCliente(Cliente cliente) {
		
		PreparedStatement pps = null;
		
		if (cliente == null) {
			System.out.println("O valor passado não pode ser nulo");
		}
		try {
			String comando = "INSERT INTO Cliente(tipoCliente, status, nome, cpf, sexo, dataNascimento, telefone, celular, email)" + "values(?,?,?,?,?,?,?,?,?)";
			pps = getConnection().prepareStatement(comando);
			pps.setString(1, cliente.getTipoCliente());
			pps.setString(2, String.valueOf(cliente.getStatus()));
			pps.setString(3, cliente.getNome());
			pps.setInt(4, cliente.getCpf());
			pps.setString(5, String.valueOf(cliente.getSexo()));
			pps.setDate(6, new java.sql.Date(new java.util.Date(cliente.getDataNascimento().getTimeInMillis()).getTime()));
			pps.setInt(7, cliente.getTelefone());
			pps.setInt(8, cliente.getCelular());
			pps.setString(9, cliente.getEmail());
			
			pps.execute();
			pps.close();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir dados no banco: " + e.getMessage());
		} finally {
			try {
				getConnection().close();
				System.out.println("Dados inseridos com sucesso");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				System.out.println("Erro ao fechar a conexão com banco! " + e.getMessage());
			}
		}

	}

	public void alterarCliente() {
	}

	public void excluirCliente() {
	}

	public Cliente consultarCliente(int id)  {
		PreparedStatement pps = null;
		Connection conn = null;
		ResultSet rs = null;
		Cliente cliente = null;
		try {
			conn = this.getConnection();
			pps = conn.prepareStatement("select * from Cliente where idCliente = ?");
			pps.setInt(1, id);
			rs = pps.executeQuery();
			if (!rs.next()) {
				throw new Exception("Não foi encontrado nenhum resultado para o ID:" + id);
			}
			int idCliente = rs.getInt(1);
			String tipoCliente = rs.getString(2);
			String status = rs.getString(3);
			String nome = rs.getString(4);
			int cpf = rs.getInt(5);
			String sexo = rs.getString(6);
			
			Calendar dataNascimento = new GregorianCalendar();
			dataNascimento.setTime(rs.getDate(7));

			int telefone = rs.getInt(8);
			int celular = rs.getInt(9);
			String email = rs.getString(10);
			
			cliente = new Cliente(idCliente, tipoCliente, status, nome, cpf, sexo, dataNascimento, telefone, celular, email);
			
			rs.close();
			pps.close();
		} catch (SQLException e) {
			System.out.println("Erro ao executar operação: " + e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cliente;
	}
	private Connection getConnection(){
		Connection conn = GerenciadorDeConexoes.getConnection();
		return conn;
	}
	
}
