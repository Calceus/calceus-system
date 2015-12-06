package br.com.calceus.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.calceus.ctrl.ManterCadastroClienteCTRL;
import br.com.calceus.modelo.Cliente;

@ManagedBean(name = "cliente")
@RequestScoped

public class ClienteBean {


	private String confirmarSenha;

	private Cliente cliente = new Cliente();
	

	public ClienteBean() {
		// TODO Auto-generated constructor stub
	}

	

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public Cliente getCliente() {
		return cliente;
	}


	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (!this.cliente.getSenha().equalsIgnoreCase(this.confirmarSenha)) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senha confirmada incorretamente", ""));
			return "usuario";
		} else {
//			System.out.println("Salvando...");
			ManterCadastroClienteCTRL ctrl = new ManterCadastroClienteCTRL();
//			System.out.println(getCliente().getNome());
			if (ctrl.cadastrarCliente(this.getCliente())) {
				return "sucesso";
			} else {
				context.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao cadastrar Cliente", ":("));
				return "usuario";
			}
		}

	}
	public String novo(){
		return "usuario";
	}

}
