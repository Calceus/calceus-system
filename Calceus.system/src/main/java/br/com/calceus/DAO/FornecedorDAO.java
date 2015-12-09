package br.com.calceus.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.calceus.conexao.ConnectionPool;
import br.com.calceus.modelo.Fornecedor;

public class FornecedorDAO {

	public FornecedorDAO() {

	}

	public boolean salvar(Fornecedor fornecedor) {
		boolean resultado = false;
		try (Connection conexao = new ConnectionPool().getConnection()) {

			String sql = "INSERT INTO fornecedor(razaoSocial, cnpj, telefone, site, obs) values (?,?,?,?,?)";
			try (PreparedStatement insereSt = conexao.prepareStatement(sql)) {
				insereSt.setString(1, fornecedor.getRazaoSocial());
				insereSt.setString(2, fornecedor.getCnpj());
				insereSt.setInt(3, fornecedor.getTelefone());
				insereSt.setString(4, fornecedor.getSite());
				insereSt.setString(5, fornecedor.getObs());
				insereSt.execute();
				insereSt.close();
				resultado = true;
				return resultado;
			} catch (Exception e) {
				System.out.println("Erro ao incluir fornecedor. Mensagem: " + e.getMessage());
				return resultado;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return resultado;

	}

	public void atualizar(Fornecedor fornecedor) {
	}

	public boolean excluir(int cod) {
		boolean resultado = false;
		try (Connection conexao = new ConnectionPool().getConnection()) {
			
			String sql = "DELETE FROM fornecedor WHERE idFornecedor = ?";

			try (PreparedStatement pstm = conexao.prepareStatement(sql)){
				pstm.setInt(1, cod);

				int retorno = pstm.executeUpdate();
				if (retorno == 1) {
					resultado = true;
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
				resultado = false;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
		return resultado;
	}

	public List<Fornecedor> listar() {

		try (Connection conexao = new ConnectionPool().getConnection()) {

			ResultSet resultado = null;

			Fornecedor fornecedor = null;
			List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
			String sql = "SELECT * FROM fornecedor";

			try (PreparedStatement consulta = conexao.prepareStatement(sql)) {

				resultado = consulta.executeQuery();
				while (resultado.next()) {
					fornecedor = new Fornecedor(resultado.getInt("idFornecedor"), resultado.getString("razaoSocial"),
							resultado.getString("cnpj"), resultado.getInt("telefone"), resultado.getString("site"),
							resultado.getString("obs"));

					fornecedores.add(fornecedor);
				}

				return fornecedores;
			} catch (Exception e) {
				System.out.println("Erro ao buscar codigo de fornecedor. Mensagem: " + e.getMessage());
				return null;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}

		
	}

	public String buscafornecedor(int idFornecedor) {
		String razaoSocial = "";
		try (Connection conexao = new ConnectionPool().getConnection()) {

			String sql = "SELECT * FROM fornecedor WHERE idFornecedor = ?";
//			System.out.println(sql + idFornecedor);
			try (PreparedStatement consulta = conexao.prepareStatement(sql)) {
				
				consulta.setInt(1, idFornecedor);
				ResultSet resultado = null;
				resultado = consulta.executeQuery();
				
				while (resultado.next()) {
					razaoSocial = resultado.getString("razaoSocial");
				}

				return razaoSocial;
			} catch (Exception e) {
				System.out.println("Erro ao buscar codigo de fornecedor. Mensagem: " + e.getMessage());
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return razaoSocial;
		
	}

	public List<Fornecedor> listarFornecedores() {
		List<Fornecedor> fornecedores = null;
		try (Connection con = new ConnectionPool().getConnection()) {

			ResultSet rs = null;
			fornecedores = new ArrayList<>();
			Fornecedor f;
			try (CallableStatement call = con.prepareCall("{CALL RetornaFornecedores()}")) {

				rs = call.executeQuery();
				while (rs.next()) {
					f = new Fornecedor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
							rs.getString(6));
					fornecedores.add(f);
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return fornecedores;
	}
}
