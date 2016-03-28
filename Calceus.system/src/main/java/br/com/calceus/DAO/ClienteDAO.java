package br.com.calceus.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.mysql.jdbc.Statement;

import br.com.calceus.conexao.ConnectionPool;
import br.com.calceus.modelo.Cliente;

public class ClienteDAO {

	public int cadastrarCliente(Cliente cliente) {

		if (cliente == null) {
			System.out.println("O valor passado n�o pode ser nulo");
		}
		try (Connection conexao = new ConnectionPool().getConnection()) {
			String sql = "INSERT INTO Cliente(tipoCliente, status, nome, cpf, sexo, dataNascimento, telefone, celular, email, idEndereco, senha)"
					+ "values(?,?,?,?,?,?,?,?,?,?,?)";

			try (PreparedStatement pps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

				pps.setString(1, "VIP");
				pps.setString(2, "A");
				pps.setString(3, cliente.getNome());
				pps.setString(4, cliente.getCpf());
				pps.setString(5, cliente.getSexo());
				pps.setDate(6, new java.sql.Date(cliente.getData().getTime()));
				// pps.setDate(6, new
				// java.sql.Date(cliente.getDataNascimento().getTimeInMillis()));
				pps.setString(7, cliente.getTelefone());
				pps.setString(8, cliente.getCelular());
				pps.setString(9, cliente.getEmail());
				pps.setInt(10, cliente.getEndereco().getIdEndereco());
				pps.setString(11, cliente.getSenha());

				pps.execute();

				ResultSet rs = pps.getGeneratedKeys();
				int chave = 0;
				while (rs.next()) {
					chave = rs.getInt(1);
				}
				return chave;

			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir dados no banco: " + e.getMessage());
			return 0;
		} catch (Exception e) {
			System.out.println("Erro ao inserir dados no banco: " + e.getMessage());
			return 0;
		}

	}

	public boolean alterarCliente(Cliente cliente) {
		if (cliente == null) {
			System.out.println("O valor passado n�o pode ser nulo");
		}
		try (Connection conexao = new ConnectionPool().getConnection()) {
			String sql = "UPDATE Cliente SET tipoCliente = ?, status = ?, nome = ?, cpf = ?, sexo = ?, dataNascimento = ?, telefone = ?, celular = ?, email = ?, idEndereco = ? WHERE idCliente = ?";

			try (PreparedStatement pps = conexao.prepareStatement(sql)) {

				pps.setString(1, cliente.getTipoCliente());
				pps.setString(2, cliente.getStatus());
				pps.setString(3, cliente.getNome());
				pps.setString(4, cliente.getCpf());
				pps.setString(5, cliente.getSexo());
				pps.setDate(6,
						new java.sql.Date(new java.util.Date(cliente.getDataNascimento().getTimeInMillis()).getTime()));
				pps.setString(7, cliente.getTelefone());
				pps.setString(8, cliente.getCelular());
				pps.setString(9, cliente.getEmail());
				pps.setInt(10, cliente.getEndereco().getIdEndereco());
				pps.setInt(11, cliente.getIdCliente());

				pps.execute();

				return true;

			}
		} catch (SQLException e) {
			System.out.println("Erro ao alterar dados no banco: " + e.getMessage());
			return false;
		} catch (Exception e) {
			System.out.println("Erro ao alterar dados no banco: " + e.getMessage());
			return false;
		}
	}

	public Cliente consultarCliente(int idCliente) {

		Cliente cliente = null;
		try (Connection conexao = new ConnectionPool().getConnection()) {
			String sql = "SELECT * FROM cliente WHERE idCliente = ?";

			try (PreparedStatement pps = conexao.prepareStatement(sql)) {

				pps.setInt(1, idCliente);
				ResultSet rs = pps.executeQuery();
				if (!rs.next()) {
					throw new Exception("N�o foi encontrado nenhum resultado para o ID:" + idCliente);
				}
				cliente = new Cliente();

				cliente.setIdCliente(rs.getInt("idCliente"));
				cliente.setTipoCliente(rs.getString("tipoCliente"));
				cliente.setStatus(rs.getString("status"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setSexo(rs.getString("sexo"));

				Calendar dataNascimento = new GregorianCalendar();
				dataNascimento.setTime(rs.getDate("dataNascimento"));
				cliente.setDataNascimento(dataNascimento);

				cliente.setTelefone(rs.getString("telefone"));

				cliente.setCelular(rs.getString("celular"));

				cliente.setEmail(rs.getString("email"));
				cliente.getEndereco().setIdEndereco(rs.getInt("idEndereco"));

				rs.close();

				return cliente;

			} catch (SQLException e) {
				System.out.println("Erro ao executar opera��o: " + e.getMessage());
				return null;
			} catch (Exception e) {
				System.out.println("Erro ao executar opera��o: " + e.getMessage());
				return null;
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
	}

	public boolean excluirCliente(int idCliente) {
		try (Connection conexao = new ConnectionPool().getConnection()) {
			String sql = "DELETE FROM cliente WHERE idCliente = ?";
			try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
				stmt.setInt(1, idCliente);

				stmt.execute();
				return true;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
	}

	public boolean verificarCliente(Cliente cliente) {
		boolean resultado = false;
		try (Connection conexao = new ConnectionPool().getConnection()) {
			String sql = "SELECT email, senha FROM cliente WHERE email like ? AND senha like ?";

			try (PreparedStatement pps = conexao.prepareStatement(sql)) {

				pps.setString(1, cliente.getEmail());
				pps.setString(2, cliente.getSenha());

				ResultSet rs = pps.executeQuery();
				if (!rs.next()) {
					throw new Exception(
							"N�o foi encontrado nenhum resultado com os dados fornecidos:" + cliente.getEmail());
				}
				String email = "";
				String senha = "";
				while (rs.next()) {
					email = rs.getString("email");
					senha = rs.getString("senha");
					if (cliente.getEmail().equals(email) && cliente.getSenha().equals(senha)) {
						resultado = true;
					} else {
						resultado = false;
					}
				}
				rs.close();

				return resultado;
			} catch (SQLException e) {
				System.out.println("Erro ao executar opera��o: " + e.getMessage());
				return resultado;
			} catch (Exception e) {
				System.out.println("Erro ao executar opera��o: " + e.getMessage());
				return resultado;
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
			return resultado;
		}
	}

	// public static void main(String[] args) {
	// ClienteDAO dao = new ClienteDAO();
	//
	// Cliente c = new Cliente();
	// c.setNome("Laercio");
	// c.setCpf("2345678900");
	// c.setEmail("laercio_ferraci@yahoo.com.br");
	// c.setCelular("11987654321");
	// c.setTelefone("1137896060");
	// c.setSenha("heineken");
	//
	// SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
	// String dateInString = "13/10/1985";
	// Date date = null;
	// try {
	// date = sdf.parse(dateInString);
	// } catch (ParseException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// Calendar dataNascimento = Calendar.getInstance();
	// dataNascimento.setTime(date);
	// c.setDataNascimento(dataNascimento);
	// c.getEndereco().setIdEndereco(1);
	//
	// System.out.println("Cadastrando cliente: " + c.toString());
	// int chave = dao.adicionaCliente(c);
	// System.out.println("consultando cliente: " + chave);
	// c.setEmail("laercio_ferracini@yahoo.com.br");
	// if (dao.alterarCliente(c))
	// System.out.println("Alterando cliente: " +
	// dao.consultarCliente(chave).toString());
	// else
	// System.out.println("Errors fuck");
	//
	// if (dao.excluirCliente(chave)) {
	// System.out.println("Excluindo cliente");
	// }
	// }

}
