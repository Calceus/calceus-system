package br.com.calceus.modelo;

public class Cargo {
	
	private int idCargo;
	private String nomeCargo;
	private String obs;
	
	
	public Cargo(int idCargo, String nomeCargo, String obs) {
		this.idCargo = idCargo;
		this.nomeCargo = nomeCargo;
		this.obs = obs;
	}

	public int getIdCargo() {
		return idCargo;
	}

	public String getNomeCargo() {
		return nomeCargo;
	}

	public String getObs() {
		return obs;
	}
	
}
