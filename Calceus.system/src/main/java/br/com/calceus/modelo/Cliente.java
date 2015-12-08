package br.com.calceus.modelo;

import java.util.Calendar;
import java.util.Date;

import br.com.calceus.DAO.ClienteDAO;


public class Cliente {

	private int idCliente;
	private String tipoCliente;
	private String status;
	protected String nome;
	protected String cpf;
	protected String sexo;
	protected Calendar dataNascimento;
	private String telefone;
	private String celular;
	protected String email;
	private String senha;
	
	private Date data;
	
	private Endereco endereco;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(int idCliente, String tipoCliente, String status, String nome, String cpf, String sexo,
			Calendar dataNascimento, String telefone, String celular, String email, Endereco endereco) {
		this.idCliente = idCliente;
		this.tipoCliente = tipoCliente;
		this.status = status;
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String string) {
		this.celular = string;
	}

	public void setCpf(String string) {
		this.cpf = string;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return this.cpf;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSexo() {
		return this.sexo;
	}

	public String getNome() {
		return this.nome;
	}

	public String getEmail() {
		return this.email;
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public String getTipoCliente() {
		return this.tipoCliente;
	}

	public String getStatus() {
		return this.status;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Endereco getEndereco() {
		if(endereco == null)
			return endereco = new Endereco();
		
		return endereco;
	}
	public void setData(Date data) {
		this.data = data;
	}

	private void dateToCalendar(Date data) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		setDataNascimento(cal);
	}
	
	public Date getData() {
		return data;
	}
	
	private void calendarToDate() {
		setData(getDataNascimento().getTime());
		
	}

	@Override
	public String toString() {
		return "Cliente " + this.getNome();
	}

	public boolean cadastrarCliente(Cliente cliente) {
		ClienteDAO dao = new ClienteDAO();
		int retorno = dao.cadastrarCliente(cliente);
		if(retorno == 0){
			return false;
		}else{
			return true;
		}
		
	}

	public boolean verificarCliente(Cliente cliente) {
		ClienteDAO dao = new ClienteDAO();
		return dao.verificarCliente(cliente);
	}

}
