package br.com.calceus.modelo;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Cliente extends Pessoa implements Consultas {

	private int idCliente;
	private int tipoCliente;
	private char status;
	private int idPessoa;

	public Cliente(int idCliente, int tipoCliente, char status, int idPessoa) {
		super();
		this.idCliente = idCliente;
		this.tipoCliente = tipoCliente;
		this.status = status;
		this.idPessoa = idPessoa;

	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public int getTipoCliente() {
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

	@Override
	public void consulta(int idProduto) {

	}

	@Override
	public Pedido consultaPedido(int numero) {
		return null;

	}

	@Override
	public Produto consultaProduto(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto consultaproduto(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

}
