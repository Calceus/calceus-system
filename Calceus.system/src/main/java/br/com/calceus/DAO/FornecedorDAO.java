package br.com.calceus.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.calceus.conexao.GerenciadorDeConexoes;
import br.com.calceus.modelo.Fornecedor;

public class FornecedorDAO {

	public FornecedorDAO() {
		
	}

	public void salvar(Fornecedor fornecedor) {
		Connection conexao = this.geraConexao();
		PreparedStatement insereSt = null;
		String sql = "INSERT INTO fornecedor(razaoSocial, cnpj, telefone, site, obs) values (?,?,?,?,?)";
		try {
			insereSt = conexao.prepareStatement(sql);
			insereSt.setString(1, fornecedor.getRazaoSocial());
			insereSt.setString(2, fornecedor.getCnpj());
			insereSt.setInt(3, fornecedor.getTelefone());
			insereSt.setString(4, fornecedor.getSite());
			insereSt.setString(5, fornecedor.getObs());
			insereSt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao incluir fornecedor. Mensagem: " + e.getMessage());
		} finally {
			try {
				insereSt.close();
				conexao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar operações de inserção. Mensagem: " + e.getMessage());
			}
		}
	}

	public void atualizar(Fornecedor fornecedor) {
	}

	public void excluir(Fornecedor fornecedor) {
	}

	public List<Fornecedor> listar() {
		Connection conexao = this.geraConexao();
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		Statement consulta = null;
		ResultSet resultado = null;
		Fornecedor fornecedor = null;
		String sql = "SELECT * FROM fornecedor";

		try {
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			while (resultado.next()) {
				fornecedor = new Fornecedor(resultado.getInt("idFornecedor"),
						resultado.getString("razaoSocial"),
						resultado.getString("cnpj"),
						resultado.getInt("telefone"),
						resultado.getString("site"),
						resultado.getString("obs"));
				
				fornecedores.add(fornecedor);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar codigo de fornecedor. Mensagem: " + e.getMessage());
		} finally {
			try {
				consulta.close();

			} catch (Throwable e) {
				System.out.println("Erro ao fechar operações de consulta. Mensagem: " + e.getMessage());
			}
		}
		return fornecedores;
	}

	public Fornecedor buscafornecedor(int valor) {
		return null;
	}

	public Connection geraConexao() {
		Connection conn = GerenciadorDeConexoes.getConnection();
		return conn;
	}
	public static void main(String[] args) {
		FornecedorDAO dao = new FornecedorDAO();
		System.out.println("Fornecedor" + dao.listar());;
	}
}
