package br.com.calceus.modelo;

import java.util.List;

public class Produto {

	private int idProduto;
	private String nomeProduto;
	private int quantidade;
	private double valor;
	private int idCategoria;
	private int idFornecedor;
	private int idItemProduto;
	private int idMarca;
	private char genero;

	public Produto() {

	}

	public Produto(int idProduto, String nomeProduto, int quantidade,
			double valor) {
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.quantidade = quantidade;
		this.valor = valor;

	}

	public Produto(int idProduto, String nomeProduto, int idCategoria,
			int idFornecedor, int idItemProduto, int quantidade, double valor, int idMarca) {
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.idCategoria = idCategoria;
		this.idFornecedor = idFornecedor;
		this.idItemProduto = idItemProduto;
		this.quantidade = quantidade;
		this.valor = valor;
		this.idMarca = idMarca;

	}



	public Produto(int idProduto2) {
		this.idProduto = idProduto2;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public int getIdFornecedor() {
		return idFornecedor;
	}

	public char getGenero() {
		return genero;
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

	public int getIdItemProduto() {
		return idItemProduto;
	}
	public int getIdMarca() {
		return idMarca;
	}
	public boolean verificarDisponibilidade(int idProduto) {
		return false;
	}

	public List<Produto> consultarProdutosEmPromocao(
			List<Produto> produtosEmPromocao) {
		return null;
	}

	public boolean cadastrarProduto() {
		return false;
	}

	public List<Produto> consultarProdutos() {
		return null;
	}

	public Produto alterarProduto() {
		return null;
	}

	public boolean excluirProduto() {
		return false;
	}

	public boolean atualizarEstoque() {
		return false;
	}

	
}
