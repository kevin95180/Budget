package com.budget.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.budget.service.IDepenseService;
import com.budget.service.IEntreeService;
import com.budget.service.ISalaireService;

@Component("facade")
public class FacadeImpl implements Facade {

	@Autowired
	private ISalaireService salaireService;
	
	@Autowired
	private IEntreeService entreeService;
	
	@Autowired
	private IDepenseService depenseService;
	
	@Override
	public ISalaireService getSalaireService() {
		return salaireService;
	}

	@Override
	public IDepenseService getDepenseService() {
		return depenseService;
	}

	@Override
	public IEntreeService getEntreeService() {
		return entreeService;
	}

}
