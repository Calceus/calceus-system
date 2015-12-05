package br.com.calceus.DAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import com.mysql.jdbc.Statement;

import br.com.calceus.conexao.ConnectionPool;
import br.com.calceus.modelo.Endereco;

public class EnderecoDAO {

	private String urlPesquisaCEP = "http://api.postmon.com.br/v1/cep/";

	public String getUrlPesquisaCEP() {
		return urlPesquisaCEP;
	}

	public Endereco buscaCep(String cep) {
		Endereco end = null;
		try {
			JSONObject json = readJsonFromUrl(urlPesquisaCEP+cep);
			end = new Endereco();
			end.setLogradouro(json.getString("logradouro"));
			end.setCep(json.getString("cep"));
			end.setBairro(json.getString("bairro"));
			end.setCidade(json.getString("cidade"));
			end.setEstado(json.getString("estado"));
			return end;
		} catch (IOException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return end;
		}
		
	}

	public int cadastrarEndereco(Endereco e){
		try(Connection conexao = new ConnectionPool().getConnection()){
			String sql = "INSERT INTO endereco (logradouro, numero, complemento, bairro, cep, cidade, estado, pais) VALUES (?,?,?,?,?,?,?,?)";
			try(PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
				stmt.setString(1, e.getLogradouro());
				stmt.setString(2, e.getNumero());
				stmt.setString(3, e.getComplemento());
				stmt.setString(4, e.getBairro());
				stmt.setString(5, e.getCep());
				stmt.setString(6, e.getCidade());
				stmt.setString(7, e.getEstado());
				stmt.setString(8, e.getPais());
				
				stmt.execute();
				ResultSet rs = stmt.getGeneratedKeys();
				int chavePrimaria = 0;
				while(rs.next()){
					chavePrimaria = rs.getInt(1);
				}
				return chavePrimaria;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return -1;
		}
	}
	public boolean alterarEndereco(Endereco e){
		try(Connection conexao = new ConnectionPool().getConnection()){
			String sql = "UPDATE endereco SET logradouro = ?, numero = ?, complemento = ?, bairro = ?, cep = ?, cidade = ?, estado = ?, pais = ? WHERE idEndereco = ?";
			try(PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
				stmt.setString(1, e.getLogradouro());
				stmt.setString(2, e.getNumero());
				stmt.setString(3, e.getComplemento());
				stmt.setString(4, e.getBairro());
				stmt.setString(5, e.getCep());
				stmt.setString(6, e.getCidade());
				stmt.setString(7, e.getEstado());
				stmt.setString(8, e.getPais());
				stmt.setInt(9, e.getIdEndereco());
				
				stmt.executeUpdate();
				
				return true;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}
	public Endereco consultarEndereco(int idEndereco){
		try(Connection conexao = new ConnectionPool().getConnection()){
			String sql = "SELECT * FROM endereco WHERE idEndereco = ?";
			try(PreparedStatement stmt = conexao.prepareStatement(sql)){
				stmt.setInt(1, idEndereco);
				
				ResultSet rs = stmt.executeQuery();
				Endereco e = null;
				while(rs.next()){
					e = new Endereco();
					e.setIdEndereco(rs.getInt("idEndereco"));
					e.setLogradouro(rs.getString("logradouro"));
					e.setNumero(rs.getString("numero"));
					e.setComplemento(rs.getString("complemento"));
					e.setCep(rs.getString("cep"));
					e.setBairro(rs.getString("bairro"));
					e.setCidade(rs.getString("cidade"));
					e.setEstado(rs.getString("estado"));
					e.setPais(rs.getString("pais"));
				}
				return e;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
	}
	
	
	public boolean excluirEndereco(int idEndereco){
		try(Connection conexao = new ConnectionPool().getConnection()){
			String sql = "DELETE FROM endereco WHERE idEndereco = ?";
			try(PreparedStatement stmt = conexao.prepareStatement(sql)){
				stmt.setInt(1, idEndereco);
				
				stmt.execute();
				return true;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}
	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	private static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}
	
//	public static void main(String[] args) {
//		EnderecoDAO dao = new EnderecoDAO();
//		System.out.println("Buscando cep: 02801000");
//		Endereco e = dao.buscaCep("02801000");
//		e.setNumero("238");
//		e.setComplemento("");
//		e.setPais("Bresil");
//		int chave  =dao.cadastrarEndereco(e);
//		System.out.println("Cadastrando endereço: "+chave);
//		Endereco e1 = dao.consultarEndereco(chave);
//		System.out.println("consultando endereço: "+e1.toString());
//		e1.setNumero("239");
//		
//		if(dao.alterarEndereco(e1))
//			System.out.println("Alterando endereço: "+dao.consultarEndereco(chave).toString());
//		else
//			System.out.println("Errors fuck");
//		if(dao.excluirEndereco(chave)){
//			System.out.println("Excluindo endereço");
//		}
//	}
}
