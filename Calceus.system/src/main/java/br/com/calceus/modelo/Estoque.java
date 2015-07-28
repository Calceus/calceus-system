package br.com.calceus.modelo;

import java.util.Calendar;

public class Estoque {

	//Tabela Estoque
	private int idEstoque;
	private Calendar dataMovimentacao;
	private int idPedido;
	
	//Tabela TipoMovimentação
	private int idTipoMovimentacao;
	private String descricao;
	public Estoque(int idEstoque, Calendar dataMovimentacao, int idPedido, int idTipoMovimentacao, String descricao) {
		this.idEstoque = idEstoque;
		this.dataMovimentacao = dataMovimentacao;
		this.idPedido = idPedido;
		this.idTipoMovimentacao = idTipoMovimentacao;
		this.descricao = descricao;
	}
	public int getIdEstoque() {
		return idEstoque;
	}
	public Calendar getDataMovimentacao() {
		return dataMovimentacao;
	}
	public int getIdPedido() {
		return idPedido;
	}
	public int getIdTipoMovimentacao() {
		return idTipoMovimentacao;
	}
	public String getDescricao() {
		return descricao;
	}
	
	
}
