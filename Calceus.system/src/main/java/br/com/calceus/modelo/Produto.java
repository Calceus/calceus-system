package br.com.calceus.modelo;

public class Produto {
	
	private int idProduto;
	private String nomeProduto;
	private int quantidade;
	private double valor;
	private int idCategoria;
	
	public Produto(int idProduto, String nomeProduto, int quantidade,
			double valor, int idCategoria) {
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.quantidade = quantidade;
		this.valor = valor;
		this.idCategoria = idCategoria;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public double getValor() {
		return valor;
	}

	public int getIdCategoria() {
		return idCategoria;
	}
	
	

}
