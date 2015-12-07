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

	public List<Produto> consultarProdutosNotaFiscal(int notaFiscal) {
		compra = new Compra();
		return compra.consultarProdutosNotaFiscal(notaFiscal);
	}
}
