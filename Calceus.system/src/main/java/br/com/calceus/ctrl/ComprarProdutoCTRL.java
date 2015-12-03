package br.com.calceus.ctrl;

import java.util.List;

import br.com.calceus.modelo.Compra;
import br.com.calceus.modelo.Produto;

public class ComprarProdutoCTRL {

	private Compra compra;

	public ComprarProdutoCTRL() {
		// TODO Auto-generated constructor stub
	}

	public boolean consultarNotaFiscal(int notaFiscal) {
		compra = new Compra();
		return compra.consultarNotaFiscal(notaFiscal);

	}

	public List<Produto> consultarNotaFiscalEntrada(int notaFiscal) {
		compra = new Compra();
		int idCompra = compra.consultarNotaFiscalEntrada(notaFiscal);
		return consultarProdutos(idCompra);

	}

	private List<Produto> consultarProdutos(int idCompra) {
		compra = new Compra();
		return compra.consultarProdutos(idCompra);

	}
}
