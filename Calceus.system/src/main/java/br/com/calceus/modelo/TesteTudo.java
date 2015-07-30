package br.com.calceus.modelo;

import br.com.calceus.programa.AdicionaClientesFuncionarios;

public class TesteTudo {
	public static void main(String[] args) {
		Pedido pedido1 = new Pedido(1, null, 12, 1000, 1, 1);
		Pedido pedido2 = new Pedido(2, null, 12, 1000, 2, 2);

		Pedido armario = new Pedido();
		armario.adicionaPedido(pedido1);
		armario.adicionaPedido(pedido2);

		Cliente joao = new Cliente(001, 1, 'A', 1205);
		joao.setNome("Joao");

		Cliente maria = new Cliente(002, 2, 'A', 1035);
		maria.setNome("Maria");

		AdicionaClientesFuncionarios programa = new AdicionaClientesFuncionarios();

		programa.adiciona(joao);
		programa.adiciona(maria);

		try {
			programa.listaPessoas();
		} catch (NullPointerException e) {
			System.out.println("Erro 404 pessoas nao encontradas");
		}
		System.out.println(joao.consultaPedido(0));
	   

	}

}
