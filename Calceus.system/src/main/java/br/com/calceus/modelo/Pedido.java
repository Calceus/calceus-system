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
	
}
