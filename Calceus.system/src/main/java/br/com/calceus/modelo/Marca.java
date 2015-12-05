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
		try {
			return dao.salvar(marca);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public List<String> listar() throws SQLException {
		List<String> marcas = new ArrayList<String>();
		dao = new MarcaDAO();
		try {
			for (Marca m : dao.listar()) {
				marcas.add(m.getMarca());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return marcas;
	}
	public static void main(String[] args) throws SQLException {
		Marca m = new Marca();
		System.out.println("Listando:" + m.listar());
	}

}
