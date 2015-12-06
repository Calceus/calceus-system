package br.com.calceus.modelo;

import br.com.calceus.DAO.EnderecoDAO;

public class Endereco {

	private int idEndereco;
	private String cep;
	private String logradouro;
	private String complemento;
	private String numero;
	private String bairro;
	private String pais;
	private String cidade;
	private String estado;
	
	public Endereco() {
		// TODO Auto-generated constructor stub
	}
	public Endereco(int idEndereco, String cep, String logradouro, String complemento, String numero, String bairro,
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
	
	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getIdEndereco() {
		return idEndereco;
	}
	public String getCep() {
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
	public Endereco buscaCep(String cep){
		EnderecoDAO dao = new EnderecoDAO();
		return dao.buscaCep(cep);
	}
	public String buscarCep(){
		EnderecoDAO dao = new EnderecoDAO();
		
		Endereco e = dao.buscaCep(this.getCep());
		
		setarAtributos(e);
		
//		System.out.println(e.toString());
		return "ok";
	}
	private void setarAtributos(Endereco e) {
		setLogradouro(e.getLogradouro());
		setBairro(e.getBairro());
		setCidade(e.getCidade());
		setEstado(e.getEstado());
	}
	public int cadastrarEndereco(Endereco e){
		EnderecoDAO dao = new EnderecoDAO();
		return dao.cadastrarEndereco(e);
	}
	public boolean alterarEndereco(Endereco e){
		EnderecoDAO dao = new EnderecoDAO();
		return dao.alterarEndereco(e);
	}
	public boolean excluirEndereco(int idEndereco){
		EnderecoDAO dao = new EnderecoDAO();
		return dao.excluirEndereco(idEndereco);
	}
	public Endereco consultarEndereco(int idEndereco){
		EnderecoDAO dao = new EnderecoDAO();
		return dao.consultarEndereco(idEndereco);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getLogradouro() + this.getNumero()+this.getBairro() + this.getCep();
	}
}
