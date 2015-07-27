package br.com.calceus.modelo;

public class Categoria {

	private int idCategoria;
	private String categoria;
	private String descricao;
	public Categoria(int idCategoria, String categoria, String descricao) {
		this.idCategoria = idCategoria;
		this.categoria = categoria;
		this.descricao = descricao;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public String getCategoria() {
		return categoria;
	}
	public String getDescricao() {
		return descricao;
	}
	
	
	
}
