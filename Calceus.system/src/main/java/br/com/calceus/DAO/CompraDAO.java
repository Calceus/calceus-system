package br.com.calceus.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import br.com.calceus.conexao.ConnectionPool;

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

	public int cadastrarProduto(int notaFiscal) {
		int id = 0;
		String sql = "INSERT INTO compra (numPedido, idFuncionario) VALUES (?,?)";
		try(Connection conexao = new ConnectionPool().getConnection()){
			try(PreparedStatement pps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
				pps.setInt(1, notaFiscal);
				pps.setInt(2, 1);
				pps.execute();
				ResultSet rs = pps.getGeneratedKeys();
				while(rs.next()){
					id = rs.getInt(1);
				}
				rs.close();
				return id;
			}
		}catch (SQLException e) {
			System.out.println("Errp ao inserir Compra: "+e.getMessage());
			return id;
		}
	}

}
