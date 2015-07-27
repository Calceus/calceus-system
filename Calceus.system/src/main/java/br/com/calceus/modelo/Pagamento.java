package br.com.calceus.modelo;

import java.util.Calendar;

public class Pagamento {
	
	//Tabela Pagamento
	private int idPagamento;
	private int idPedido;
	private Calendar vencimento;
	//Tabela FormaPagamento
	private int idFormaPagamento;
	private String descricao;
	private String prazo;
	private double desconto;
	private char situacao;
	public Pagamento(int idPagamento, int idPedido, Calendar vencimento, int idFormaPagamento, String descricao,
			String prazo, double desconto, char situacao) {
		this.idPagamento = idPagamento;
		this.idPedido = idPedido;
		this.vencimento = vencimento;
		this.idFormaPagamento = idFormaPagamento;
		this.descricao = descricao;
		this.prazo = prazo;
		this.desconto = desconto;
		this.situacao = situacao;
	}
	public int getIdPagamento() {
		return idPagamento;
	}
	public int getIdPedido() {
		return idPedido;
	}
	public Calendar getVencimento() {
		return vencimento;
	}
	public int getIdFormaPagamento() {
		return idFormaPagamento;
	}
	public String getDescricao() {
		return descricao;
	}
	public String getPrazo() {
		return prazo;
	}
	public double getDesconto() {
		return desconto;
	}
	public char getSituacao() {
		return situacao;
	}
	
	
}
