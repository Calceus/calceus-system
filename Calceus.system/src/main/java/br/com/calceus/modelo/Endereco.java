package br.com.calceus.modelo;

public class Endereco {

	private int idEndereco;
	private int cep;
	private String logradouro;
	private String complemento;
	private String numero;
	private String bairro;
	private String pais;
	private String cidade;
	private String estado;
	
	public Endereco(int idEndereco, int cep, String logradouro, String complemento, String numero, String bairro,
			String pais, String cidade, String estado) {
		this.idEndereco = idEndereco;
		this.cep = cep;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.numero = numero;
		this.bairro = bairro;
		this.pais = pais;
		this.cidade = cidade;
		this.estado = estado;
	}
	public int getIdEndereco() {
		return idEndereco;
	}
	public int getCep() {
		return cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public String getNumero() {
		return numero;
	}
	public String getBairro() {
		return bairro;
	}
	public String getPais() {
		return pais;
	}
	public String getCidade() {
		return cidade;
	}
	public String getEstado() {
		return estado;
	}
	
	
}
