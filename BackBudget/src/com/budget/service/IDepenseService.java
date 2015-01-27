package com.budget.service;

import java.util.List;

import com.budget.dto.DepenseDto;
import com.budget.entity.Depense;

public interface IDepenseService {
	
	public void createDepense(DepenseDto depenseDto);
	public void updateDepense(DepenseDto depenseDto);
	public void deleteDepense(DepenseDto depenseDto);
	public List<Depense> findAll();
	public double totalDepense();
	public void editableDepense(DepenseDto depenseDto);
	public boolean findDepense(DepenseDto depenseDto);
	
}
