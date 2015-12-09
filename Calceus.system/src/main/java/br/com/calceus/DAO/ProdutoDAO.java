package br.com.calceus.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.calceus.conexao.ConnectionPool;
import br.com.calceus.modelo.Produto;

public class ProdutoDAO {
	

	public boolean adicionaProduto(Produto produto) {
		String sql = "INSERT INTO produto(idProduto, nomeProduto , idFornecedor, quantidade, preco, idCategoria, genero, idItemCompra, idMarca) VALUES (?,?,?,?,?,?,?,?,?)";
		if (produto == null) {
			System.out.println("Valor passado nao pode ser nullo");
		}
		try (Connection conexao = new ConnectionPool().getConnection()) {
			try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			    stmt.setInt(1,produto.getIdProduto());
				stmt.setString(2, produto.getNomeProduto());
				stmt.setInt(3, produto.getFornecedor().getIdFornecedor());
				stmt.setInt(4, produto.getQuantidade());
				stmt.setDouble(5, produto.getValor());
				stmt.setInt(6, produto.getCategoria().getIdCategoria());
				stmt.setLong(7,produto.getGenero()); 
//				stmt.setInt(8, produto.getIdItemProduto());
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
					produto.getFornecedor().setIdFornecedor(resultado.getInt("idFornecedor"));
					produto.getCategoria().setIdCategoria(resultado.getInt("idCategoria"));
					produto.setNomeProduto(resultado.getString("nomeProduto"));
					produto.setQuantidade(resultado.getInt("quantidade"));
					produto.setValor(resultado.getDouble("preco"));
					produto.setGenero(resultado.getString("genero").charAt(0));
//					produto.setIdItemProduto(resultado.getInt("idItemProduto"));
					produto.getMarca().setIdMarca(resultado.getInt("idMarca"));

				}
			}

		} catch (SQLException e) {
			System.out
					.println("Erro ao fazer busca no banco " + e.getMessage());
		}
		return produto;
	}
	public Produto buscarProduto(int idProduto) {
		String sql = "SELECT *  FROM produto where idProduto = ?";
		Produto produto = null;
		try (Connection conexao = new ConnectionPool().getConnection()) {
			try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
				stmt.setInt(1, idProduto);
				ResultSet resultado = stmt.executeQuery();
				while (resultado.next()) {
					produto = new Produto();
					produto.setIdProduto(resultado.getInt("idProduto"));
					produto.getFornecedor().setIdFornecedor((resultado.getInt("idFornecedor")));
					produto.getCategoria().setIdCategoria((resultado.getInt("idCategoria")));
					produto.setNomeProduto(resultado.getString("nomeProduto"));
					
					produto.setValor(resultado.getDouble("preco"));
					produto.setGenero(resultado.getString("genero").charAt(0));
					
					produto.getMarca().setIdMarca(resultado.getInt("idMarca"));

				}
			}

		} catch (SQLException e) {
			System.out
					.println("Erro ao fazer busca no banco " + e.getMessage());
		}
		return produto;
	}

	public List<Produto> listarProdutos() {
		String sql = "SELECT * FROM produto";
		List<Produto> produtos = null;
		try (Connection conexao = new ConnectionPool().getConnection()) {
			try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
				
				ResultSet resultado = stmt.executeQuery();
				produtos = new ArrayList<Produto>();
				Produto produto;
				while (resultado.next()) {
					produto = new Produto();
					produto.setIdProduto(resultado.getInt("idProduto"));
					produto.getFornecedor().setIdFornecedor(resultado.getInt("idFornecedor"));
					produto.getCategoria().setIdCategoria(resultado.getInt("idCategoria"));
					produto.setNomeProduto(resultado.getString("nomeProduto"));
					produto.setQuantidade(resultado.getInt("quantidade"));
					produto.setValor(resultado.getDouble("preco"));
					produto.setGenero(resultado.getString("genero").charAt(0));
					produto.setIdItemProduto(resultado.getInt("idItemCompra"));
					produto.getMarca().setIdMarca(resultado.getInt("idMarca"));
//					System.out.println(produto.toString());
					produtos.add(produto);
				}
				return produtos;
			}

		} catch (SQLException e) {
			System.out.println("Erro ao fazer busca no banco " + e.getMessage());
			return null;
		}
	}

	public boolean cadastrarProduto(Produto produto) {
		String sql = "INSERT INTO produto(nomeProduto , idFornecedor, quantidade, preco, idCategoria, genero, idItemCompra, idMarca) VALUES (?,?,?,?,?,?,?,?)";
		boolean resultado = false;
		try(Connection conexao = new ConnectionPool().getConnection()){
			try(PreparedStatement pps = conexao.prepareStatement(sql)){
				
				pps.setString(1, produto.getNomeProduto());
				pps.setInt(2, 1);
				pps.setInt(3, produto.getQuantidade());
				pps.setDouble(4, produto.getValor());
				pps.setInt(5, 1);
				pps.setString(6,"M"); 
				pps.setInt(7, produto.getIdItemProduto());
				pps.setInt(8, 1);
				pps.execute();
//				ResultSet rs = pps.getGeneratedKeys();
//				while(rs.next()){
//					
//				}
				resultado = true;
			}
		}catch (SQLException e) {
			System.out.println("Erro ao cadastrar no banco " + e.getMessage());
			return resultado;
		}
		return resultado;
	}
}
