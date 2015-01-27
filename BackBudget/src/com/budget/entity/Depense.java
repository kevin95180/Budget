package com.budget.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Depense.nomDepenseFindByNom", query="SELECT c FROM Depense c WHERE c.nomDepense = :nomDepense")
public class Depense {
	
	@Id
	@GeneratedValue
	private int idDepense;
	private String nomDepense;
	private Double sommeDepense;
	private boolean editable;
	
	public Depense() {
		super();
	}

	public Depense(String nomDepense, Double sommeDepense) {
		super();
		this.nomDepense = nomDepense;
		this.sommeDepense = sommeDepense;
	}

	public String getNomDepense() {
		return nomDepense;
	}
	
	public void setNomDepense(String nomDepense) {
		this.nomDepense = nomDepense;
	}
	
	public Double getSommeDepense() {
		return sommeDepense;
	}
	
	public void setSommeDepense(Double sommeDepense) {
		this.sommeDepense = sommeDepense;
	}
	
	public int getIdDepense() {
		return idDepense;
	}
	
	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	@Override
	public String toString() {
		return "Depense [idDepense=" + idDepense + ", nomDepense=" + nomDepense
				+ ", sommeDepense=" + sommeDepense + "]";
	}
	
}
