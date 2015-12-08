package br.com.calceus.modelo;

import java.util.List;

import br.com.calceus.DAO.ProdutoDAO;

public class Produto {

	private int idProduto;
	private String nomeProduto;
	private int quantidade;
	private double valor;
	private int idCategoria;
	private int idFornecedor;
	private int idItemProduto;
	private Marca marca;
	private char genero;

	public Produto() {

	}

	public Produto(int idProduto, String nomeProduto, int quantidade, double valor) {
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.quantidade = quantidade;
		this.valor = valor;

	}

	public Produto(int idProduto, String nomeProduto, int idCategoria, int idFornecedor, int idItemProduto,
			int quantidade, double valor, Marca marca) {
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.idCategoria = idCategoria;
		this.idFornecedor = idFornecedor;
		this.idItemProduto = idItemProduto;
		this.quantidade = quantidade;
		this.valor = valor;
		this.marca = marca;

	}

	public Produto(int idProduto2) {
		this.idProduto = idProduto2;
	}

	public Marca getMarca() {
		return marca;
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

	public boolean verificarDisponibilidade(int idProduto) {
		return false;
	}

	public List<Produto> consultarProdutosEmPromocao(List<Produto> produtosEmPromocao) {
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

	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public void setIdProduto(int idFornecedor) {
		this.idProduto = idFornecedor;

	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;

	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;

	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void setGenero(long genero) {
		this.genero = (char) genero;

	}

	public void setIdItemProduto(int idItemProduto) {
		this.idItemProduto = idItemProduto;

	}

	public Produto consultarProduto(int idProduto2) {
		ProdutoDAO dao = new ProdutoDAO();

		return dao.consultarProduto(idProduto2);
	}

	public Produto buscarProduto(int idProduto) {
		ProdutoDAO dao = new ProdutoDAO();

		return dao.buscarProduto(idProduto);
	}
}
