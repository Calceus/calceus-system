package br.com.calceus.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GerenciadorDeConexoes {

	public static Connection getConnection(String tipo, String servidor, String banco, String usuario, String senha){
		
		try {
			if(tipo.equals("mysql")){
				return DriverManager.getConnection("jdbc:"+tipo+"://"+servidor+"/"+banco, usuario, senha);
			}else if(tipo.equals("sqlserver")){
				return DriverManager.getConnection("jdbc:"+tipo+"://"+servidor+"/"+banco, usuario, senha);
			}
		} catch (SQLException e) {
			System.out.println("Tipo de Banco de Dados não suportado ----"+ e.getMessage());
			
		}
		return null;
		
	}
}
