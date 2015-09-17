package br.com.calceus.modelo;

public class ItemPedido {
	private Produto produto;;
    
	public void adicionaItemAoPedido(Produto produto){
		this.produto = produto; 
	}
	public void detalhesItem(){
		this.produto.mostra(); 
	}
}
