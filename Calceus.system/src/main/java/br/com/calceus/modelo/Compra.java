package br.com.calceus.modelo;

import java.util.List;

import br.com.calceus.DAO.CompraDAO;

public class Compra {

	private int idCompra;
	private int numPedido;
	private int idFuncionario;
	private ItemCompra itemCompra;

	private CompraDAO dao;

	public Compra() {
		// TODO Auto-generated constructor stub
	}

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public int getNumPedido() {
		return numPedido;
	}

	public void setNumPedido(int numPedido) {
		this.numPedido = numPedido;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public ItemCompra getItemCompra() {
		if(itemCompra !=  null){
			return itemCompra;
		}else{
			return itemCompra = new ItemCompra();
		}
		
	}

	public List<Produto> consultarProdutosNotaFiscal(int notaFiscal) {
		dao = new CompraDAO();
		itemCompra = new ItemCompra();
		return itemCompra.consultarProdutosNotaFiscal(notaFiscal);

	}

	public boolean consultarNotaFiscal(int notaFiscal) {
		dao = new CompraDAO();
		return dao.consultarNotaFiscal(notaFiscal);
	}

	public int cadastrarNotaFiscal(int notaFiscal) {
		dao = new CompraDAO();
		return dao.cadastrarProduto(notaFiscal);
	}

}
