package br.com.calceus.modelo;

import java.util.List;

import br.com.calceus.DAO.ItemCompraDAO;

public class ItemCompra {

	private ItemCompraDAO dao;
	private int idItemCompra;
	private int idCompra;
	private int numSequencial;
	private int quantidade;
	private Produto produto;
	
	public ItemCompra() {
		// TODO Auto-generated constructor stub
	}

	
	public ItemCompraDAO getDao() {
		return dao;
	}


	public void setDao(ItemCompraDAO dao) {
		this.dao = dao;
	}


	public int getIdItemCompra() {
		return idItemCompra;
	}


	public void setIdItemCompra(int idItemCompra) {
		this.idItemCompra = idItemCompra;
	}


	public int getIdCompra() {
		return idCompra;
	}


	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}


	public int getNumSequencial() {
		return numSequencial;
	}


	public void setNumSequencial(int numSequencial) {
		this.numSequencial = numSequencial;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		if(produto != null){
			return produto;
		}else
			return produto = new Produto();
	}

	public int cadastrarItemCompra(ItemCompra i){
		dao = new ItemCompraDAO();
		return dao.cadastrarItemCompra(i);
	}
	public List<Produto> consultarProdutosNotaFiscal(int notaFiscal) {
		dao = new ItemCompraDAO();
		int idCompra = dao.consultarIdNotaFiscal(notaFiscal);
		return dao.consultarProdutos(idCompra);
	}

}
