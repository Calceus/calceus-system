package br.com.calceus.ctrl;

import java.sql.SQLException;
import java.util.List;

import br.com.calceus.modelo.Marca;

public class MarcaCTRL {

	public boolean salvar(String marca) throws SQLException{
		Marca m = new Marca(marca);
		return m.salvar(m);
	}
	
	public List<String> listar() throws SQLException{
		Marca m = new Marca();
		return m.listar();
	}
}
