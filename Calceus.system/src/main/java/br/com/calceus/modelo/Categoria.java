package br.com.calceus.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.calceus.DAO.CategoriaDAO;

public class Categoria {

	private int idCategoria;
	private String categoria;
	private String descricao;
	private CategoriaDAO dao;
	
	public Categoria() {
		// TODO Auto-generated constructor stub
	}
	
	public Categoria(String categoria, String descricao) {
		this.categoria = categoria;
		this.descricao = descricao;
	}
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

	public List<String> listar() {
		List<String> categorias = new ArrayList<>();
		dao = new CategoriaDAO();
		for(Categoria c: dao.listar()){
			categorias.add(c.getCategoria());
		}
		return categorias;
	}

	public boolean salvar(Categoria c) {
		dao = new CategoriaDAO();
		
		return dao.salvar(c);
	}
	
}
