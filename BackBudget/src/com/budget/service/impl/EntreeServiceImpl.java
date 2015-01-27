package com.budget.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.budget.dao.IEntreeDao;
import com.budget.dto.EntreeDto;
import com.budget.entity.Entree;
import com.budget.service.IEntreeService;

@Transactional
@Component
public class EntreeServiceImpl implements IEntreeService {
	
	Logger log = Logger.getLogger(getClass());
	
	@Autowired
	IEntreeDao entreeDao;

	@Override
	public void createEntree(EntreeDto entreeDto) {
		Entree entree = new Entree();
		BeanUtils.copyProperties(entreeDto, entree);
		entreeDao.createEntree(entree);
	}

	@Override
	public void updateEntree(EntreeDto entreeDto) {
		Entree entree = new Entree();
		BeanUtils.copyProperties(entreeDto, entree);
		entreeDao.updateEntree(entree.getNomEntree(), entree.getSommeEntree());
	}

	@Override
	public void deleteEntree(EntreeDto entreeDto) {
		Entree entree = new Entree();
		BeanUtils.copyProperties(entreeDto, entree);
		entreeDao.deleteEntree(entree.getNomEntree());
	}

	@Override
	public List<Entree> findAll() {
		return entreeDao.findAll();
	}

	@Override
	public double totalEntree() {
		return entreeDao.totalEntree();
	}

	@Override
	public void editableEntree(EntreeDto entreeDto) {
		Entree entree = new Entree();
		BeanUtils.copyProperties(entreeDto, entree);
		entreeDao.editableEntree(entree.getNomEntree());
	}

	@Override
	public boolean findEntree(EntreeDto entreeDto) {
		Entree entree = new Entree();
		BeanUtils.copyProperties(entreeDto, entree);
		if(entreeDao.findEntree(entree.getNomEntree())==null){
			return true;
		}
		log.info("Le nom de l'entrée est deja utilisé");
		return false;
	}

}
