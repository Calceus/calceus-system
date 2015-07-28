package br.com.calceus.modelo;

import java.util.Calendar;

public class Pedido {

	//Tabela Pedido
	private int idPedido;
	private Calendar dataPedido;
	private double valorTotal;
	private int idCliente;
	
	//Tabele ItemPedido
	private int idItemPedido;
	private int idProduto;
	
	public Pedido(int idPedido, Calendar dataPedido, double valorTotal, int idCliente, int idItemPedido,
			int idProduto) {
		this.idPedido = idPedido;
		this.dataPedido = dataPedido;
		this.valorTotal = valorTotal;
		this.idCliente = idCliente;
		this.idItemPedido = idItemPedido;
		this.idProduto = idProduto;
	}
	
	public int getIdPedido() {
		return idPedido;
	}
	public Calendar getDataPedido() {
		return dataPedido;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public int getIdItemPedido() {
		return idItemPedido;
	}
	public int getIdProduto() {
		return idProduto;
	}
	
	
}
