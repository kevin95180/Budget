package com.budget.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.budget.dao.ISalaireDao;
import com.budget.dto.SalaireDto;
import com.budget.entity.Salaire;
import com.budget.service.ISalaireService;

@Transactional
@Component
public class SalaireServiceImpl implements ISalaireService {
	
	Logger log = Logger.getLogger(getClass());
	
	@Autowired
	ISalaireDao salaireDao;

	@Override
	public void createSalaire(SalaireDto salaireDto) {
		//BeanUtils.copyProperties(newObject, oldObject);
		Salaire salaire = new Salaire();
		BeanUtils.copyProperties(salaireDto, salaire);
		salaireDao.createSalaire(salaire);
	}

	@Override
	public void updateSalaire(SalaireDto salaireDto) {
		Salaire salaire = new Salaire();
		BeanUtils.copyProperties(salaireDto, salaire);
		salaireDao.updateSalaire(salaire.getNomSalaire(), salaire.getSommeSalaire());
	}

	@Override
	public void deleteSalaire(SalaireDto salaireDto) {
		Salaire salaire = new Salaire();
		BeanUtils.copyProperties(salaireDto, salaire);
		salaireDao.deleteSalaire(salaire.getNomSalaire());
	}

	@Override
	public List<Salaire> findAll() {
		return salaireDao.findAll();
	}

	@Override
	public double totalSalaire() {
		return salaireDao.totalSalaire();
	}

	@Override
	public void editableSalaire(SalaireDto salaireDto) {
		Salaire salaire = new Salaire();
		BeanUtils.copyProperties(salaireDto, salaire);
		salaireDao.editableSalaire(salaire.getNomSalaire());
	}

	@Override
	public boolean findSalaire(SalaireDto salaireDto) {
		Salaire salaire = new Salaire();
		BeanUtils.copyProperties(salaireDto, salaire);
		if(salaireDao.findSalaire(salaire.getNomSalaire())==null){
			return true;
		}
		log.info("Le nom du salaire est deja utilisé");
		return false;
	}

}
