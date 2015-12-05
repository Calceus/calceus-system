package br.com.calceus.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.calceus.conexao.GerenciadorDeConexoes;
import br.com.calceus.modelo.Marca;

public class MarcaDAO {

	public boolean salvar(Marca marca) throws SQLException {
		String sql = "INSERT INTO marca (marca) VALUES (?)";
		try(Connection conn = GerenciadorDeConexoes.getConnection()){
		

			try (PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, marca.getMarca());
				ps.execute();
			
				return true;
			} catch (SQLException e) {
			System.out.println("Erro ao inserir no banco " + e.getMessage());
			return false;
	
			}
		}
	}

	public List<Marca> listar() {
		Connection conn = GerenciadorDeConexoes.getConnection();
		String sql = "SELECT * FROM Marca";
		Statement st = null;
		ResultSet rs = null;
		Marca marca = null;
		List<Marca> marcas = new ArrayList<Marca>();
		
		try{
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				
				marca = new Marca();
				marca.setIdMarca(rs.getInt("idMarca"));
				marca.setMarca(rs.getString("marca"));
				
				marcas.add(marca);
			}
			st.close();
			rs.close();
			return marcas;
		}catch(SQLException e){
			System.out.println("Erro na pesquisa de marcas: "+e.getMessage());
			return null;
		}finally {
			try{
				conn.close();
			}catch(Exception e){
				System.out.println("Erro ao fechar operações de consulta. Mensagem: " + e.getMessage());
			}
		}
	}

}
