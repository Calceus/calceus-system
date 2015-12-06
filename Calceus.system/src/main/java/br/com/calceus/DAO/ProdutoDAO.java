package br.com.calceus.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.calceus.conexao.ConnectionPool;
import br.com.calceus.modelo.Marca;
import br.com.calceus.modelo.Produto;

public class ProdutoDAO {
	public static void main(String[] args) {
		Marca marca = new Marca();
		marca.setIdMarca(2);
		marca.setMarca("Nike");

		Produto produto = new Produto(2, "chinelo", 1, 1, 1, 29, 3.000, marca);
		
	
		ProdutoDAO produtoDAO = new ProdutoDAO();
		if (produtoDAO.adicionaProduto(produto)) {
			System.out.println("Produto adicionado");
		} else {
			System.out.println("erro");
		}

	}

	public boolean adicionaProduto(Produto produto) {
		String sql = "INSERT INTO produto(idProduto, nomeProduto , idFornecedor, quantidade, preco, idCategoria, genero, idItemCompra, idMarca) VALUES (?,?,?,?,?,?,?,?,?)";
		if (produto == null) {
			System.out.println("Valor passado nao pode ser nullo");
		}
		try (Connection conexao = new ConnectionPool().getConnection()) {
			try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			    stmt.setInt(1,produto.getIdProduto());
				stmt.setString(2, produto.getNomeProduto());
				stmt.setInt(3, produto.getIdFornecedor());
				stmt.setInt(4, produto.getQuantidade());
				stmt.setDouble(5, produto.getValor());
				stmt.setInt(6, produto.getIdCategoria());
				stmt.setLong(7,produto.getGenero()); 
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
			System.out
					.println("Erro ao fazer busca no banco " + e.getMessage());
		}
		return produto;
	}
}
