package br.com.calceus.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GerenciadorDeConexoes {

	/**
	 * M�TODO PARA UTILIZAR QUANDO FOR UMA CONEX�O SQLSERVER
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
			System.out.println("Tipo de Banco de Dados n�o suportado ----"+ e.getMessage());
			
		}
		return null;
		
	}
	/**
	 * USAR M�TODO DE CONEX�O PARA CONECTAR NO MYSQL
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
			System.out.println("Verifique os dados de conex�o **** "+ e.getMessage() + " **** "+"jdbc:mysql://"+servidor+"/"+banco+"/");
			
		}
		return null;
		
	}
}
