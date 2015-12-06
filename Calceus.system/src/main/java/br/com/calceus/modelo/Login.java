package br.com.calceus.modelo;

import br.com.calceus.DAO.LoginDAO;

public class Login {

	private String usuario;
	private String senha;
	private LoginDAO dao;
	public Login() {
		// TODO Auto-generated constructor stub
	}
	public Login(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public boolean autentica(){
		dao = new LoginDAO();
		return dao.autenticaFuncionario(this);
	}
	public String getUsuario() {
		return usuario;
	}
	public String getSenha() {
		return senha;
	}
	
	public boolean autenticaCliente(){
		dao = new LoginDAO();
		System.out.println(usuario+senha);
		return dao.autenticaCliente(this);
	}
}
