package br.com.calceus.modelo;

public class Cliente extends Pessoa{

	private int idCliente;
	private String tipoCliente;
	private char status;
	private int idPessoa;

	public Cliente(int idCliente, String tipoCliente, char status, int idPessoa) {
		super();
		this.idCliente = idCliente;
		this.tipoCliente = tipoCliente;
		this.status = status;
		this.idPessoa = idPessoa;

	}
	public Cliente(){}

	public int getIdCliente() {
		return this.idCliente;
	}

	public String getTipoCliente() {
		return this.tipoCliente;
	}

	public char getStatus() {
		return this.status;
	}

	public int getIdPessoa() {
		return this.idPessoa;
	}

	@Override
	public String toString() {
		return "Cliente " + this.getTipoCliente();
	}

}
