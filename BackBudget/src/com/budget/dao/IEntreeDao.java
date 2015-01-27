package com.budget.dao;

import java.util.List;

import com.budget.entity.Entree;

public interface IEntreeDao {
	
	public void createEntree(Entree entity);
	public void updateEntree(String nomEntree, double sommeEntity);
	public void deleteEntree(String nomEntree);
	public Entree findEntree(String nomEntree);
	public List<Entree> findAll();
	public double totalEntree();
	public void editableEntree(String nomEntree);
	
}
