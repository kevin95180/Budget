package com.budget.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Salaire.nomSalaireFindByNom", query="SELECT c FROM Salaire c WHERE c.nomSalaire = :nomSalaire")
public class Salaire {
	
	@Id
	@GeneratedValue
	private int idSalaire;
	private String nomSalaire;
	private double sommeSalaire;
	private boolean editable;
	
	public Salaire() {
		super();
	}

	public Salaire(String nomSalaire, double sommeSalaire) {
		super();
		this.nomSalaire = nomSalaire;
		this.sommeSalaire = sommeSalaire;
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
	
	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	@Override
	public String toString() {
		return "Salaire [idSalaire=" + idSalaire + ", nomSalaire=" + nomSalaire
				+ ", sommeSalaire=" + sommeSalaire + "]";
	}
	
}
