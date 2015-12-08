package br.com.calceus.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.calceus.DAO.ItemPedidoDAO;

public class ItemPedido {
	
	private Produto produto;
	
    private int idItemProduto;
    private int idProduto;
    private int idPedido;
    private int quantidade;
    
	private List<Produto> listaProdutos;
    
	public ItemPedido() {
		
	}
	
	public ItemPedido(Produto p) {
		getListaProdutos().add(p);
	}

	public int getIdItemProduto() {
		return idItemProduto;
	}

	public void setIdItemProduto(int idItemProduto) {
		this.idItemProduto = idItemProduto;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public List<Produto> getListaProdutos() {
		if(listaProdutos != null){
			return listaProdutos;
		}else{
			return listaProdutos = new ArrayList<Produto>();
		}
		
	}
	
	public Produto getProduto() {
		return produto;
	}
	public void adicionaItem(Produto produto){
		this.getListaProdutos().add(produto);
	}

	public List<ItemPedido> listarItensPedido(int numeroPedido) {
		
		ItemPedidoDAO dao = new ItemPedidoDAO();
		List<ItemPedido> itens = dao.listaItensPedido(numeroPedido);
		for(ItemPedido i : itens){
			getListaProdutos().add(buscarProduto(i.getIdProduto()));
		}
		return itens;
		
	}
	public Produto buscarProduto(int idProduto){
		produto = new Produto();
		
		return produto.buscarProduto(idProduto);
	}
	
}
