package br.com.calceus.programa;

import br.com.calceus.modelo.Pessoa;

public class AdicionaClientesFuncionarios {
	private Pessoa[] arrayDePessoas;
	private int posicaoLivre;

	public AdicionaClientesFuncionarios() {
		this.arrayDePessoas = new Pessoa[100];

	}

	public void adiciona(Pessoa nova) {
		this.arrayDePessoas[posicaoLivre] = nova;
		this.posicaoLivre++;
	}

	public Pessoa pegaUmaPessoa(int posicao) {
		return this.arrayDePessoas[posicao];

	}
	public void listaPessoas(){
	
		for(int i  = 0; i < this.arrayDePessoas.length; i++){
		     System.out.println("Nome " + this.arrayDePessoas[i].getNome() + " Id " + this.arrayDePessoas[i].getIdPessoa());
		}
	
	}
}
