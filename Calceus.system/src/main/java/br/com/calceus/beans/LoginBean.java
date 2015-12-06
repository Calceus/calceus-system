package br.com.calceus.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import br.com.calceus.ctrl.LoginCTRL;
import br.com.calceus.modelo.Login;

@ManagedBean(name = "login")
@RequestScoped
public class LoginBean {

	private String email;
	private String senha;
	
	private Login login;
	
	public LoginBean() {
		// TODO Auto-generated constructor stub
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public void login(ActionEvent event) {
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage message = null;
		boolean loggedIn = false;
		LoginCTRL ctrl = new LoginCTRL();
		System.out.println("Autenticando");
		if (ctrl.autentica(this.getEmail(), this.getSenha())) {
			loggedIn = true;
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem vindo", email);
			
		} else {
			loggedIn = false;
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
		}

		FacesContext.getCurrentInstance().addMessage(null, message);
		context.addCallbackParam("loggedIn", loggedIn);
	}
}
