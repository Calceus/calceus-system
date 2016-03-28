package br.com.calceus.ctrl;

import java.util.List;

import br.com.calceus.modelo.Compra;
import br.com.calceus.modelo.ItemCompra;
import br.com.calceus.modelo.Produto;

public class ComprarProdutoCTRL {

	private Compra compra;

	public ComprarProdutoCTRL() {
		// TODO Auto-generated constructor stub
	}

	public boolean cadastrarNotaFiscal (int notaFiscal, List<ItemCompra> lista){
		compra = new Compra();
		int idCompra = compra.cadastrarNotaFiscal(notaFiscal);
		
		if(idCompra != 0){
			for (int i = 0; i < lista.size(); i++) {
				lista.get(i).setIdCompra(idCompra);
				int idItemCompra = compra.getItemCompra().cadastrarItemCompra(lista.get(i));
				if(idItemCompra != 0){
					lista.get(i).getProduto().setIdItemProduto(idItemCompra);
					compra.getItemCompra().getProduto().cadastrarProduto(lista.get(i).getProduto());
				}
			}
			return true;
		}else{
			return false;
		}
	}
	public boolean consultarNotaFiscal(int notaFiscal) {
		compra = new Compra();
		return compra.consultarNotaFiscal(notaFiscal);

	}

	public List<Produto> consultarProdutosNotaFiscal(int notaFiscal) {
		compra = new Compra();
		return compra.consultarProdutosNotaFiscal(notaFiscal);
	}
}
