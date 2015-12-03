package br.com.calceus.modelo;

import java.util.List;

import br.com.calceus.DAO.CompraDAO;

public class Compra {

	private int idCompra;
	private int numPedido;
	private int idFuncionario;

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

	public CompraDAO getDao() {
		return dao;
	}

	public void setDao(CompraDAO dao) {
		this.dao = dao;
	}

	public int consultarNotaFiscalEntrada(int notaFiscal) {
		dao = new CompraDAO();

		return dao.consultarNotaFiscalEntrada(notaFiscal);

	}

	public List<Produto> consultarProdutos(int idCompra) {
		dao = new CompraDAO();
		return dao.consultarProdutos(idCompra);

	}

	public boolean consultarNotaFiscal(int notaFiscal) {
		dao = new CompraDAO();
		return dao.consultarNotaFiscal(notaFiscal);
	}

}
