package br.com.calceus.ctrl;

import java.sql.SQLException;
import java.util.List;

import br.com.calceus.modelo.Categoria;
import br.com.calceus.modelo.Marca;

public class ProdutoCTRL {

	public boolean salvar(String marca) throws SQLException{
		Marca m = new Marca(marca);
		return m.salvar(m);
	}
	public List<String> listarMarcas() throws SQLException{
		Marca m = new Marca();
		return m.listar();
	}
	
	public boolean salvarCategoria(String categoria, String descricao){
		Categoria c= new Categoria(categoria, descricao);
		return c.salvar(c);
	}
	public List<String> listarCategorias(){
		Categoria c = new Categoria();
		return c.listar();
	}
}
