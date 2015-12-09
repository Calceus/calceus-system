package br.com.calceus.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.com.calceus.conexao.ConnectionPool;
import br.com.calceus.modelo.ItemCompra;
import br.com.calceus.modelo.Produto;

public class ItemCompraDAO {

	public List<Produto> consultarProdutos(int idCompra) {
		List<Produto> listaCompra = null;
		Produto produto = null;
		try (Connection conexao = new ConnectionPool().getConnection()) {
			String sql = "SELECT idProduto, nomeProduto, quantidade, preco FROM produto WHERE idItemCompra in (SELECT idItemCompra FROM itemcompra WHERE idCompra = ?)";
			try (PreparedStatement query = conexao.prepareStatement(sql)) {
				//System.out.println(idCompra);
				query.setInt(1, idCompra);
				listaCompra = new ArrayList<Produto>();
				ResultSet rs = query.executeQuery();
				while (rs.next()) {
					produto = new Produto(rs.getInt("idProduto"), rs.getString("nomeProduto"), rs.getInt("quantidade"),
							rs.getDouble("preco"));
					listaCompra.add(produto);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return listaCompra;
	}
	public int consultarIdNotaFiscal(int notaFiscal) {
		int idCompra = 0;
		try (Connection conexao = new ConnectionPool().getConnection()) {
			String sql = "SELECT idCompra FROM Compra WHERE numPedido = ?";
			try (PreparedStatement query = conexao.prepareStatement(sql)) {

				query.setInt(1, notaFiscal);
				ResultSet resultado = query.executeQuery();
				while (resultado.next()) {
					idCompra = resultado.getInt("idCompra");
				}

				resultado.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return idCompra;
	}
	public int cadastrarItemCompra(ItemCompra i) {
		System.out.println(i.getIdCompra());
		String sql = "INSERT INTO itemcompra (idCompra, numSequencial, qtdProduto) VALUES (?,?,?)";
		int id = 0;
		try(Connection conexao = new ConnectionPool().getConnection()){
			try(PreparedStatement pps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
				pps.setInt(1, i.getIdCompra());
				pps.setInt(2, i.getNumSequencial());
				pps.setInt(3, i.getQuantidade());
				pps.execute();
				ResultSet rs = pps.getGeneratedKeys();
				while(rs.next()){
					id = rs.getInt(1);
				}
				return id;
			}
		}catch (SQLException e) {
			System.out.println("Erro ao inserir ItemdeCompra: "+e.getMessage());
			return id;
		}
	}
}
