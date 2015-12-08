package br.com.calceus.modelo;

import java.util.Date;
import java.util.List;

import br.com.calceus.DAO.PromocaoDAO;

public class Promocao {
 
	private int idPromocao;
	 
	private String descricao;
	 
	private Date dataValidade;
	 
	private int desconto;
	 
	public boolean cadastrarPromocao(Promocao promocao, Produto Produto) {
		return false;
	}
	 
	public void desativarPromocao() {
	 
	}
	 
	public void atualizarPromocao() {
	 
	}
	 
	public void enviarEmailMarketing() {
	 
	}
	 
	public Promocao consultarPromocao() {
		return null;
	}
	 
	public double verificarPromocao(int idProduto) {
		PromocaoDAO dao = new PromocaoDAO();
		
		return dao.verificaPromocao(idProduto);
	}
	 
	public List<Promocao> consultarPromocoes() {
		return null;
	}

	public int getIdPromocao() {
		return idPromocao;
	}

	public void setIdPromocao(int idPromocao) {
		this.idPromocao = idPromocao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public int getDesconto() {
		return desconto;
	}

	public void setDesconto(int desconto) {
		this.desconto = desconto;
	}
	
	 
}
 
