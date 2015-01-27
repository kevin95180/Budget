package com.budget.service;

import java.util.List;

import com.budget.dto.SalaireDto;
import com.budget.entity.Salaire;

public interface ISalaireService {
	
	public void createSalaire(SalaireDto entity);
	public void updateSalaire(SalaireDto entity);
	public void deleteSalaire(SalaireDto entity);
	public List<Salaire> findAll();
	public double totalSalaire();
	public void editableSalaire(SalaireDto entity);
	public boolean findSalaire(SalaireDto entity);
	
}
