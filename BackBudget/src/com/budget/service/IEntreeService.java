package com.budget.service;

import java.util.List;

import com.budget.dto.EntreeDto;
import com.budget.entity.Entree;

public interface IEntreeService {
	
	public void createEntree(EntreeDto entity);
	public void updateEntree(EntreeDto entity);
	public void deleteEntree(EntreeDto entity);
	public List<Entree> findAll();
	public double totalEntree();
	public void editableEntree(EntreeDto entity);
	public boolean findEntree(EntreeDto entity);
	
}
