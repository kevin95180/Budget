package com.budget.dto;

import java.io.Serializable;

public class EntreeDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idEntree;
	private String nomEntree;
	private double sommeEntree;
	
	public String getNomEntree() {
		return nomEntree;
	}
	
	public void setNomEntree(String nomEntree) {
		this.nomEntree = nomEntree;
	}
	
	public double getSommeEntree() {
		return sommeEntree;
	}
	
	public void setSommeEntree(double sommeEntree) {
		this.sommeEntree = sommeEntree;
	}
	
	public int getIdEntree() {
		return idEntree;
	}
	
}
