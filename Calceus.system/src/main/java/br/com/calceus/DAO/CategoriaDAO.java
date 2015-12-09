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
import br.com.calceus.modelo.Categoria;

public class CategoriaDAO {

	public boolean salvar(Categoria c){
		Connection conn = GerenciadorDeConexoes.getConnection();
		String sql = "INSERT INTO categoria (categoria, descricao) VALUES (?,?)";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, c.getCategoria());
			ps.setString(2, c.getDescricao());
			ps.execute();
			ps.close();
			return true;
		} catch (SQLException e) {
			System.out.println("Erro ao inserir no banco " + e.getMessage());
			return false;
		}finally {
			try{
				
				conn.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
	public List<Categoria> listar(){
		Connection conn = GerenciadorDeConexoes.getConnection();
		Statement consulta = null;
		ResultSet resultado = null;
		Categoria categoria = null;
		List<Categoria> categorias = new ArrayList<Categoria>();
		String sql = "SELECT * From Categoria";
		try {
			consulta = conn.createStatement();
			resultado = consulta.executeQuery(sql);
			while(resultado.next()){
				categoria = new Categoria(resultado.getInt("idCategoria"), resultado.getString("categoria"), resultado.getString("descricao"));
				categorias.add(categoria);
			}
			consulta.close();
			resultado.close();
		} catch (SQLException e) {
			System.out.println("Erro na pesquisa de categorias: "+e.getMessage());
			return null;
		}finally {
			try{
				conn.close();
				
			}catch(Exception e){
				System.out.println("Erro ao fechar operações de consulta. Mensagem: " + e.getMessage());
			}
		}
		return categorias;
	}
	public String consultarCategoria(int ids) {
		String categoria = "";
		String sql = "SELECT categoria FROM categoria WHERE idCategoria = ?";
		try(Connection conexao = new ConnectionPool().getConnection()) {
			try(PreparedStatement pps = conexao.prepareStatement(sql)){
				pps.setInt(1, ids);
				ResultSet resultado = pps.executeQuery();
				while(resultado.next()){
					categoria = resultado.getString("categoria");
					
				}
			}
			return categoria;			
		} catch (SQLException e) {
			System.out.println("Erro na pesquisa de categorias: "+e.getMessage());
			return categoria;
		}
	}
}
