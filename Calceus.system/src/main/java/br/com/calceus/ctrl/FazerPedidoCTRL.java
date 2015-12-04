package br.com.calceus.ctrl;

import br.com.calceus.modelo.Pedido;
import br.com.calceus.modelo.Produto;

public class FazerPedidoCTRL {

	private Pedido pedido;
	private Produto produto;

	public boolean confirmarPedido(Pedido dadosPedido) {
		return false;
	}

	public boolean fazerPedido(int idProduto) {
		return false;
	}

	public boolean adicionarProduto(int idProduto) {
		produto = new Produto();
		
		//verifica se produto está disponível
		if (produto.verificarDisponibilidade(idProduto)) {
			Produto p = new Produto(idProduto);
			getPedido().adicionaItem(p);
			return true;
		} else {
			return false;
		}

	}

	public void calcularFrete(String cep) {

	}

	public void informaTipoPagamento(String boleto) {

	}

	private Pedido getPedido() {
		if (pedido != null) {
			return pedido;
		} else {
			return pedido = new Pedido();
		}
	}
}
