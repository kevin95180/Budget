package com.budget.dao;

import java.util.List;

import com.budget.entity.Salaire;

public interface ISalaireDao {
	
	public void createSalaire(Salaire entity);
	public void updateSalaire(String nomSalaire, double sommeSalaire);
	public void deleteSalaire(String nomSalaire);
	public Salaire findSalaire(String nomSalaire);
	public List<Salaire> findAll();
	public double totalSalaire();
	public void editableSalaire(String nomSalaire);
	
}
