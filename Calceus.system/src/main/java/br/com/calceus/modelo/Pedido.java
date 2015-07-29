package br.com.calceus.modelo;

import java.io.LineNumberInputStream;
import java.util.Calendar;

public class Pedido {

	// Tabela Pedido
	private int idPedido;
	private Calendar dataPedido;
	private double valorTotal;
	private int idCliente;
	private int posicaoLivre;;
	private Pedido[] listaDePedidos;

	// Tabele ItemPedido
	private int idItemPedido;
	private int idProduto;

	public Pedido(int idPedido, Calendar dataPedido, double valorTotal, int idCliente, int idItemPedido,
			int idProduto) {
		listaDePedidos = new Pedido[100];
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
		return this.idProduto;
	}

	public void adicionaPedido(Pedido novo) {

		listaDePedidos[posicaoLivre] = novo;
		posicaoLivre++;
	}

	public Pedido consultaPedido(int numero) {
         
        	 return listaDePedidos[numero];
    }
         

	}


