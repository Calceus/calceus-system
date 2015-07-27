package br.com.calceus.modelo;

public class Fornecedor {

	private int idFornecedor;
	private String cnpj;
	private String razaoSocial; //campo nomeFornecedor no banco de dados
	private String site;
	private String obs;
	public Fornecedor(int idFornecedor, String cnpj, String razaoSocial, String site, String obs) {
		this.idFornecedor = idFornecedor;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
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
	public String getSite() {
		return site;
	}
	public String getObs() {
		return obs;
	}
	
	
}
