package br.com.calceus.modelo;

public interface Consultas {

	public void consulta(int idProduto);
    
	public Pedido consultaPedido(int numero); 
	
	public Produto consultaProduto(String nome); 
	public Produto consultaproduto(int codigo);
}
