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
	
	public Estoque(int idEstoque, Calendar dataMovimentacao, int idTipoMovimentacao, int idPedido) {
		this.idEstoque = idEstoque;
		this.dataMovimentacao = dataMovimentacao;
		this.idTipoMovimentacao = idTipoMovimentacao;
		this.idPedido = idPedido;
	}

	public int getIdEstoque() {
		return idEstoque;
	}

	public Calendar getDataMovimentacao() {
		return dataMovimentacao;
	}

	public int getIdTipoMovimentacao() {
		return idTipoMovimentacao;
	}

	public int getIdPedido() {
		return idPedido;
	}
	
	
}
