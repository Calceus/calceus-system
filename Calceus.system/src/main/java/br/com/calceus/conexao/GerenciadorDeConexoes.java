package br.com.calceus.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GerenciadorDeConexoes {

	
	/**
	 * MÉTODO PARA UTILIZAR QUANDO FOR UMA CONEXÃO SQLSERVER
	 * @param tipo
	 * @param servidor
	 * @param banco
	 * @param usuario
	 * @param senha
	 * @return
	 */
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
	/**
	 * USAR MÉTODO DE CONEXÃO PARA CONECTAR NO MYSQL
	 * @param servidor
	 * @param banco
	 * @param usuario
	 * @param senha
	 * @return
	 */
	public static Connection getConnection(String servidor, String banco){
		
		try {
			return DriverManager.getConnection("jdbc:mysql://"+servidor+"/"+banco, "root", "");
		} catch (SQLException e) {
			System.out.println("Verifique os dados de conexão **** "+ e.getMessage() + " **** "+"jdbc:mysql://"+servidor+"/"+banco+"/");
			
		}
		return null;
		
	}
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/calceus", "root", "");
		} catch (SQLException e) {
			System.out.println("Verifique os dados de conexão **** "+ e.getMessage() );
			
		}
		return null;
	}
}
