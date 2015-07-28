package br.com.calceus.modelo;

public class Cliente {

	private int idCliente;
	private int tipoCliente;
	private char status;
	private int idPessoa;
	
	public Cliente(int idCliente, int tipoCliente, char status, int idPessoa) {
		this.idCliente = idCliente;
		this.tipoCliente = tipoCliente;
		this.status = status;
		this.idPessoa = idPessoa;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public int getTipoCliente() {
		return tipoCliente;
	}
	public char getStatus() {
		return status;
	}
	public int getIdPessoa() {
		return idPessoa;
	}
	
	
}
