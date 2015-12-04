package br.com.calceus.modelo;

public class ItemPedido {
	private Produto produto;;
    
	public ItemPedido(Produto p) {
		
	}

	public void adicionaItemAoPedido(Produto produto){
		this.produto = produto; 
	}
	
}
