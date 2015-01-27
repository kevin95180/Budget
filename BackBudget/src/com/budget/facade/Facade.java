package com.budget.facade;

import com.budget.service.IDepenseService;
import com.budget.service.IEntreeService;
import com.budget.service.ISalaireService;

public interface Facade {
	
	public ISalaireService getSalaireService();
	public IDepenseService getDepenseService();
	public IEntreeService getEntreeService();
	
}
