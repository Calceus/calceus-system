package br.com.calceus.modelo;

import java.util.List;

import br.com.calceus.DAO.ProdutoDAO;

public class Produto {

	private int idProduto;
	private String nomeProduto;
	private int quantidade;
	private double valor;
	private Categoria categoria;
	
	private Fornecedor fornecedor;
	
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

	public Produto(int idProduto, String nomeProduto, int idItemProduto,
			int quantidade, double valor) {
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		
		this.idItemProduto = idItemProduto;
		this.quantidade = quantidade;
		this.valor = valor;

	}

	public Produto(int idProduto2) {
		this.idProduto = idProduto2;
	}

	public Marca getMarca() {
		if(marca != null){
			return marca;
		}else
			return marca = new Marca();
	}


	public int getIdProduto() {
		return idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public Fornecedor getFornecedor() {
		if(fornecedor != null)
			return fornecedor;
		else
			return fornecedor = new Fornecedor();
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

	public Categoria getCategoria() {
		if(categoria != null)
			return categoria;
		else
			return categoria = new Categoria();
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
		ProdutoDAO dao = new ProdutoDAO();
		List<Produto> listaProdutos = dao.listarProdutos();
		
		for(int i = 0; i<listaProdutos.size(); i++){
			
			int ids = listaProdutos.get(i).getFornecedor().getIdFornecedor();
			listaProdutos.get(i).getFornecedor().setRazaoSocial(getFornecedor().consultarFornecedor(ids));
			
//			System.out.println(listaProdutos.get(i).getFornecedor().getRazaoSocial());
			
			ids = listaProdutos.get(i).getMarca().getIdMarca();
			listaProdutos.get(i).getMarca().setMarca(getMarca().consultarMarca(ids));
			
			ids = listaProdutos.get(i).getCategoria().getIdCategoria();
			listaProdutos.get(i).getCategoria().setCategoria(getCategoria().consultarCategoria(ids));
			
		}
		
		return listaProdutos;
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

	
	public void setIdProduto(int idFornecedor) {
		this.idProduto = idFornecedor;

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
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getNomeProduto()+getQuantidade()+getValor();
	}

	public Produto consultarProduto(int idProduto2) {
		ProdutoDAO dao = new ProdutoDAO();

		return dao.consultarProduto(idProduto2);
	}

	public Produto buscarProduto(int idProduto) {
		ProdutoDAO dao = new ProdutoDAO();

		return dao.buscarProduto(idProduto);
	}

	public Produto consultarProduto(String produto) {
		
		return null;
	}

	public boolean cadastrarProduto(Produto produto) {
		ProdutoDAO dao = new ProdutoDAO();
		return dao.cadastrarProduto(produto);
	}
}
