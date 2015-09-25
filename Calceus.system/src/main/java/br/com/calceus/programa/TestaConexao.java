package br.com.calceus.programa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.calceus.conexao.GerenciadorDeConexoes;

public class TestaConexao {

	// mudar para localhost onde est� o IP e mudar o usuario e para root a senha do root
	
	public static void main(String[] args) throws SQLException {
		
		Connection conn = GerenciadorDeConexoes.getConnection("mysql", "localhost", "calceus", "root", "camila2015");
		
		Statement st  = conn.createStatement();
		boolean resultado = st.execute("select * from Cargo"); //boolean para ser tratado depois
		ResultSet rs = st.getResultSet();
		
		while(rs.next()){
			String id = rs.getString("idCargo");
			System.out.println(id);
			String nome = rs.getString("nomeCargo");
			System.out.println(nome);
			String obs = rs.getString("obs");
			System.out.println(obs);
		}
		
		rs.close();
		st.close();
		conn.close();
		
	}
}
