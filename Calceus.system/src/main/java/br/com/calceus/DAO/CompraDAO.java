package br.com.calceus.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.calceus.conexao.ConnectionPool;
import br.com.calceus.modelo.Produto;

public class CompraDAO {

	
	public boolean consultarNotaFiscal(int notaFiscal) {
		boolean resultado = false;
		try (Connection conexao = new ConnectionPool().getConnection()) {
			String sql = "SELECT * FROM compra WHERE  numPedido = ?";

			try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
				stmt.setInt(1, notaFiscal);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					resultado = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return resultado;
	}
	
}
