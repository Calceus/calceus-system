package br.com.calceus.ctrl;

import java.util.Calendar;

import br.com.calceus.externo.Correios;
import br.com.calceus.modelo.Cliente;
import br.com.calceus.modelo.Pagamento;
import br.com.calceus.modelo.Pedido;
import br.com.calceus.modelo.Produto;
import br.com.calceus.modelo.Promocao;

public class FazerPedidoCTRL {

	private Pedido pedido;
	private Produto produto;
	private Promocao promocao;
	
	public boolean confirmarPedido(Pedido dadosPedido, Cliente c) {
		Cliente cliente = new Cliente();
		
		return cliente.verificarCliente(c);
	}

	public boolean fazerPedido(int idProduto) {
		return false;
	}

	public boolean adicionarProduto(int idProduto) {
		produto = new Produto();
		
		//verifica se produto está disponível
		if (produto.verificarDisponibilidade(idProduto)) {
			Produto p = new Produto(idProduto);
			p = p.consultarProduto(idProduto);
			
			double desconto = getPromocao().verificarPromocao(idProduto);
			if(desconto != 0){
				//aplica desconto
				p.setValor(p.getValor() - p.getValor()* desconto);
			}
			
			getPedido().adicionaItem(p);
			return true;
		} else {
			return false;
		}

	}

	public void calcularFrete(String cep) {
		Correios correios = new Correios();
		getPedido().setFrete(correios.calcularFrete(cep));
	}

	public void informaTipoPagamento(String boleto) {
		Pagamento pagamento = new Pagamento(getPedido().getIdPedido(), Calendar.getInstance(), 1, "Pagamento boleto", "", 0, 'A');
		
		if(pagamento.fazerPagamento()){
			Pedido p = new Pedido();
			p.confirmarPedido(getPedido());
		}
		getPedido().setIdPagamento(pagamento.getIdPagamento());
	}

	private Pedido getPedido() {
		if (pedido != null) {
			return pedido;
		} else {
			return pedido = new Pedido();
		}
	}
	public Promocao getPromocao() {
		if (promocao != null) {
			return promocao;
		} else {
			return promocao = new Promocao();
		}
	}
}
