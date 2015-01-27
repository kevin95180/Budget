package com.budget.dto;

import java.io.Serializable;

public class DepenseDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idDepense;
	private String nomDepense;
	private double sommeDepense;
	
	public String getNomDepense() {
		return nomDepense;
	}
	
	public void setNomDepense(String nomDepense) {
		this.nomDepense = nomDepense;
	}
	
	public double getSommeDepense() {
		return sommeDepense;
	}
	
	public void setSommeDepense(double sommeDepense) {
		this.sommeDepense = sommeDepense;
	}
	
	public int getIdDepense() {
		return idDepense;
	}
	
}
