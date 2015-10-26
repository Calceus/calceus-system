package br.com.calceus.modelo;

public class Fornecedor {

	private int idFornecedor;
	private String cnpj;
	private String razaoSocial; 
	private int telefone;
	private String site;
	private String obs;
	
	public Fornecedor(int idFornecedor, String razaoSocial, String cnpj, int telefone, String site, String obs) {
		this.idFornecedor = idFornecedor;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.site = site;
		this.obs = obs;
	}
	
	public int getIdFornecedor() {
		return idFornecedor;
	}
	public String getCnpj() {
		return cnpj;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public int getTelefone(){
		return telefone;
	}
	public String getSite() {
		return site;
	}
	public String getObs() {
		return obs;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getRazaoSocial();
	}
}
