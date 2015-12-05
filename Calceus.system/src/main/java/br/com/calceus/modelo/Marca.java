package br.com.calceus.modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.calceus.DAO.MarcaDAO;

public class Marca {

	private int idMarca;
	private String marca;
	private MarcaDAO dao;

	public Marca() {
		// TODO Auto-generated constructor stub
	}

	public Marca(String marca) {

		this.marca = marca;
	}

	public int getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public boolean salvar(Marca marca) throws SQLException {
		dao = new MarcaDAO();
		return dao.salvar(marca);
	}

	public List<String> listar() throws SQLException {
		List<String> marcas = new ArrayList<String>();
		dao = new MarcaDAO();
		for (Marca m : dao.listar()) {
			marcas.add(m.getMarca());
		}
		return marcas;
	}
	public static void main(String[] args) throws SQLException {
		Marca m = new Marca();
		System.out.println("Listando:" + m.listar());
	}

}
