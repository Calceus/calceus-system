package br.com.calceus.modelo;
/**
 * 
 *
 * @author Heisenberg
 * TODO Discutir a relação de contatos 
 * CRIAR UMA LISTA DE CONTATO PARA CADA PESSOA OU FORNECEDOR
 */

public class Contato {
	
	private int idTelefone;
	private int ddd;
	private int telefone;
	private String tipoTelefone;
	private int idPessoa;
	public Contato(int idTelefone, int ddd, int telefone, String tipoTelefone, int idPessoa) {
		this.idTelefone = idTelefone;
		this.ddd = ddd;
		this.telefone = telefone;
		this.tipoTelefone = tipoTelefone;
		this.idPessoa = idPessoa;
	}
	public int getIdTelefone() {
		return idTelefone;
	}
	public int getDdd() {
		return ddd;
	}
	public int getTelefone() {
		return telefone;
	}
	public String getTipoTelefone() {
		return tipoTelefone;
	}
	public int getIdPessoa() {
		return idPessoa;
	}
	
	
}
