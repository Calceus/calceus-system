package br.com.calceus.modelo;

import java.util.List;

import br.com.calceus.DAO.ItemCompraDAO;

public class ItemCompra {

	private ItemCompraDAO dao;
	
	public ItemCompra() {
		// TODO Auto-generated constructor stub
	}

	public List<Produto> consultarProdutosNotaFiscal(int notaFiscal) {
		dao = new ItemCompraDAO();
		int idCompra = dao.consultarIdNotaFiscal(notaFiscal);
		return dao.consultarProdutos(idCompra);
	}

}
