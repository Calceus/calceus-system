package br.com.calceus.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.calceus.conexao.ConnectionPool;
import br.com.calceus.conexao.GerenciadorDeConexoes;
import br.com.calceus.modelo.Marca;

public class MarcaDAO {

	public boolean salvar(Marca marca) throws SQLException {
		String sql = "INSERT INTO marca (marca) VALUES (?)";
		try (Connection conn = GerenciadorDeConexoes.getConnection()) {

			try (PreparedStatement ps = conn.prepareStatement(sql)) {
				ps.setString(1, marca.getMarca());
				ps.execute();

				return true;
			} catch (SQLException e) {
				System.out
						.println("Erro ao inserir no banco " + e.getMessage());
				return false;

			}
		}
	}

	public List<Marca> listar() throws SQLException {
		Marca marca = null;
		List<Marca> marcas = new ArrayList<Marca>();
		String sql = "SELECT * FROM Marca";
		try (Connection conn = new ConnectionPool().getConnection()) {

			try (Statement st = conn.createStatement()) {
				try (ResultSet rs = st.executeQuery(sql)) {
					while (rs.next()) {

						marca = new Marca();
						marca.setIdMarca(rs.getInt("idMarca"));
						marca.setMarca(rs.getString("marca"));

						marcas.add(marca);
					}
				}

				return marcas;
			} catch (SQLException e) {
				System.out.println("Erro na pesquisa de marcas: "
						+ e.getMessage());
				return null;
			}
		}
	}

}
