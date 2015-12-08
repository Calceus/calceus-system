package br.com.calceus.modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.calceus.DAO.PedidoDAO;

public class Pedido {

	// Tabela Pedido
	private int idPedido;
	private Calendar dataPedido;
	private double valorTotal;
	private Cliente cliente;
	private int idPagamento;
	private Date dataEntrega;
	private double frete;
	
	private int prazoEntrega;
	
	// Tabela ItemPedido
	private ItemPedido itemPedido;
	private List<ItemPedido> listaItens;

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
	
	public int getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(int idPagamento) {
		this.idPagamento = idPagamento;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public double getFrete() {
		return frete;
	}

	public void setFrete(double frete) {
		this.frete = frete;
	}

	public int getPrazoEntrega() {
		return prazoEntrega;
	}

	public void setPrazoEntrega(int prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public ItemPedido getItemPedido() {
		return itemPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public void setDataPedido(Calendar dataPedido) {
		this.dataPedido = dataPedido;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Override
	public String toString() {

		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");

		return "Pedido " + this.getIdPedido() + "\nData " + dataFormatada.format(getDataPedido().getTime())
				+ "\nValor: " + this.getValorTotal() + "\nID Cliente " + this.getCliente().getIdCliente();
	}

	public void adicionaItem(Produto p) {
		getListaItens().add(new ItemPedido(p));
	}
	
	public List<ItemPedido> getListaItens() {
		if(listaItens != null){
			return listaItens;
		}else{
			return listaItens = new ArrayList<ItemPedido>();
		}
		
	}

	public List<Pedido> consultarPedidos(int idCliente) {
		PedidoDAO dao = new PedidoDAO();
		return dao.consultarPedidos(idCliente);
	}

	public Pedido listarPedido(int numeroPedido) {
		ItemPedido itemPedido = new ItemPedido();
		Pedido p = new Pedido();
		itemPedido.listarItensPedido(numeroPedido);
		return p;
	}

	public boolean confirmarPedido(Pedido pedido) {
		PedidoDAO dao = new PedidoDAO();
		return dao.confirmarPedido(pedido);
		
	}
	
}
