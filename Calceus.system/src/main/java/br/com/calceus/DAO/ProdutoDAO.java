package br.com.calceus.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.calceus.conexao.ConnectionPool;
import br.com.calceus.modelo.Produto;

public class ProdutoDAO {
	public boolean adicionaProduto(Produto produto) {
		String sql = "INSERT INTO produto(idProduto, idFornecedor, idCategoria, nomeProduto, quantidade, preco, genero, idItemCompra, idMarca) VALUES (?,?,?,?,?,?,?,?,?)";
		if (produto == null) {
			System.out.println("Valor passado nao pode ser nullo");
		}
		try (Connection conexao = new ConnectionPool().getConnection()) {
			try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
				stmt.setInt(1, produto.getIdProduto());
				stmt.setInt(2, produto.getIdFornecedor());
				stmt.setInt(3, produto.getIdCategoria());
				stmt.setString(4, produto.getNomeProduto());
				stmt.setInt(5, produto.getQuantidade());
				stmt.setDouble(6, produto.getValor());
				stmt.setLong(7, produto.getGenero());
				stmt.setInt(8, produto.getIdItemProduto());
				stmt.setInt(9, produto.getMarca().getIdMarca());
				stmt.execute();
				return true;
			}

		} catch (SQLException e) {
			System.out.println("Erro" + e.getMessage());
			return false;
		}

	}

	public Produto consultarProduto(int idProduto) {
		String sql = "SELECT *  FROM produto where idProduto = ?";
		Produto produto = null;
		try (Connection conexao = new ConnectionPool().getConnection()) {
			try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
				stmt.setInt(1, idProduto);
				ResultSet resultado = stmt.executeQuery();
				while (resultado.next()) {
					produto = new Produto();
					produto.setIdProduto(resultado.getInt("idProduto"));
					produto.setIdFornecedor(resultado.getInt("idFornecedor"));
					produto.setIdCategoria(resultado.getInt("idCategoria"));
					produto.setNomeProduto(resultado.getString("nomeProduto"));
					produto.setQuantidade(resultado.getInt("quantidade"));
					produto.setValor(resultado.getDouble("valor"));
					produto.setGenero(resultado.getLong("genero"));
					produto.setIdItemProduto(resultado.getInt("idItemProduto"));
					produto.getMarca().setIdMarca(resultado.getInt("idMarca"));

				}
			}

		} catch (SQLException e) {
			System.out.println("Erro ao fazer busca no banco " + e.getMessage());
		}
		return produto;
	}
}
