package br.com.calceus.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.calceus.conexao.ConnectionPool;
import br.com.calceus.modelo.Cliente;
import br.com.calceus.modelo.Login;

public class LoginDAO {

	public boolean autenticaFuncionario(Login login){
		boolean autenticado = false;
		try(Connection conexao = new ConnectionPool().getConnection()){
			String sql = "SELECT * FROM Funcionario where login like ?";
			try(PreparedStatement stmt = conexao.prepareStatement(sql)){
				stmt.setString(1, login.getUsuario());
				ResultSet rs = stmt.executeQuery();
				while(rs.next()){
					if(login.getUsuario().equals(rs.getString("login"))){
						if(login.getSenha().equals(rs.getString("senha"))){
							autenticado = true;
						}
					}
				}
				
				rs.close();
				return autenticado;
			}catch (Exception e) {
				e.printStackTrace();
				return autenticado;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return autenticado;
		}
	}
	public boolean autenticaCliente(Login cliente){
		boolean autenticado = false;
		try(Connection conexao = new ConnectionPool().getConnection()){
			String sql = "SELECT email, senha FROM cliente where email like ?";
			try(PreparedStatement stmt = conexao.prepareStatement(sql)){
				stmt.setString(1, cliente.getUsuario());
				ResultSet rs = stmt.executeQuery();
				while(rs.next()){
					if(cliente.getUsuario().equals(rs.getString("email"))){
						if(cliente.getSenha().equals(rs.getString("senha"))){
							autenticado = true;
						}
					}
				}
				
				rs.close();
				return autenticado;
			}catch (Exception e) {
				e.printStackTrace();
				return autenticado;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return autenticado;
		}
	}
}
