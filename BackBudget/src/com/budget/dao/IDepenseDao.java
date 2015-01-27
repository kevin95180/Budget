package com.budget.dao;

import java.util.List;

import com.budget.entity.Depense;

public interface IDepenseDao {
	
	public void createDepense(Depense entity);
	public void updateDepense(String nomDepense, double somme);
	public void deleteDepense(String nomDepense);
	public Depense findDepense(String nomDepense);
	public List<Depense> findAll();
	public double totalDepense();
	public void editableDepense(String nomDepense);
	
}
