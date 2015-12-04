package br.com.calceus.modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Pedido {

	// Tabela Pedido
	private int idPedido;
	private Calendar dataPedido;
	private double valorTotal;
	private int idCliente;
	private int posicaoLivre;;
	private static Pedido[] listaDePedidos;

	// Tabela ItemPedido
	private int idItemPedido;
	private int idProduto;
	private List<ItemPedido> itens;


	public Pedido() {
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


	public void adicionaPedido(Pedido novo) {

		Pedido.listaDePedidos[posicaoLivre] = novo;
		this.posicaoLivre++;
	}

	public static Pedido consultaPedido(int numero) {
		Pedido achado = listaDePedidos[numero];
		/// System.out.println();;
		return achado;
	}

	@Override
	public String toString() {

		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");

		return "Pedido " + this.getIdPedido() + "\nData " + dataFormatada.format(getDataPedido().getTime())
				+ "\nValor: " + this.getValorTotal() + "\nID Cliente " + this.getIdCliente();
	}

	public void adicionaItem(Produto p) {
		getItens().add(new ItemPedido(p));
	}
	
	public List<ItemPedido> getItens() {
		if(itens != null){
			return itens;
		}else{
			return itens = new ArrayList<ItemPedido>();
		}
		
	}

}
