package br.com.calceus.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.calceus.conexao.ConnectionPool;

public class PromocaoDAO {

	public double verificaPromocao(int idProduto) {
		try (Connection conexao = new ConnectionPool().getConnection()) {
			String sql = "SELECT * FROM promocao WHERE idProduto = ?";
			try(PreparedStatement pps = conexao.prepareStatement(sql)){
				pps.setInt(1, idProduto);
				ResultSet rs = pps.executeQuery();
				double desconto = 0;
				while (rs.next()) {					
					desconto = rs.getLong("desconto");
				}
				return desconto;
			}catch (SQLException e) {
				e.printStackTrace();
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
}
