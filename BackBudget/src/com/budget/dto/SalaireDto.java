package com.budget.dto;

import java.io.Serializable;

public class SalaireDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idSalaire;
	private String nomSalaire;
	private double sommeSalaire;
	
	public SalaireDto() {
	}
	
	public String getNomSalaire() {
		return nomSalaire;
	}
	
	public void setNomSalaire(String nomSalaire) {
		this.nomSalaire = nomSalaire;
	}
	
	public double getSommeSalaire() {
		return sommeSalaire;
	}
	
	public void setSommeSalaire(double sommeSalaire) {
		this.sommeSalaire = sommeSalaire;
	}
	
	public int getIdSalaire() {
		return idSalaire;
	}
	
	@Override
	public String toString() {
		return "SalaireDto [idSalaire=" + idSalaire + ", nomSalaire="
				+ nomSalaire + ", sommeSalaire=" + sommeSalaire + "]";
	}

}
