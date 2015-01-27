package com.budget.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Entree.nomEntreeFindByNom", query="SELECT c FROM Entree c WHERE c.nomEntree = :nomEntree")
public class Entree {
	
	@Id
	@GeneratedValue
	private int idEntree;
	private String nomEntree;
	private double sommeEntree;
	private boolean editable;
	
	public Entree() {
		super();
	}

	public Entree(String nomEntree, double sommeEntree) {
		super();
		this.nomEntree = nomEntree;
		this.sommeEntree = sommeEntree;
	}

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
	
	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	@Override
	public String toString() {
		return "Entree [idEntree=" + idEntree + ", nomEntree=" + nomEntree
				+ ", sommeEntree=" + sommeEntree + "]";
	}
	
}
