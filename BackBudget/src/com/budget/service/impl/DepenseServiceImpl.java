package com.budget.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.budget.dao.IDepenseDao;
import com.budget.dto.DepenseDto;
import com.budget.entity.Depense;
import com.budget.service.IDepenseService;

@Transactional
@Component
public class DepenseServiceImpl implements IDepenseService {

	Logger log = Logger.getLogger(getClass());

	@Autowired
	IDepenseDao depenseDao;

	@Override
	public void createDepense(DepenseDto depenseDto) {
		Depense depense = new Depense();
		BeanUtils.copyProperties(depenseDto, depense);
		depenseDao.createDepense(depense);
	}

	@Override
	public void updateDepense(DepenseDto depenseDto) {
		Depense depense = new Depense();
		BeanUtils.copyProperties(depenseDto, depense);
		depenseDao.updateDepense(depense.getNomDepense(), depense.getSommeDepense());
	}

	@Override
	public void deleteDepense(DepenseDto depenseDto) {
		Depense depense = new Depense();
		BeanUtils.copyProperties(depenseDto, depense);
		depenseDao.deleteDepense(depense.getNomDepense());
	}

	@Override
	public List<Depense> findAll() {
		return depenseDao.findAll();
	}

	@Override
	public double totalDepense() {
		return depenseDao.totalDepense();
	}

	@Override
	public void editableDepense(DepenseDto depenseDto) {
		Depense depense = new Depense();
		BeanUtils.copyProperties(depenseDto, depense);
		depenseDao.editableDepense(depense.getNomDepense());
	}

	@Override
	public boolean findDepense(DepenseDto depenseDto) {
		Depense depense = new Depense();
		BeanUtils.copyProperties(depenseDto, depense);
		if(depenseDao.findDepense(depense.getNomDepense())==null){
			return true;
		}
		log.info("Le nom de la dépense est deja utilisé");
		return false;
	}

}
