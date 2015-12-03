package br.com.calceus.ctrl;

import br.com.calceus.modelo.Funcionario;
import br.com.calceus.modelo.Login;

public class LoginCTRL {

	private Funcionario funcionario;
	
	public LoginCTRL() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean autentica(String usuario, String senha){
		
		Login login = new Login(usuario, senha);
		return login.autentica();
	}
	
}
