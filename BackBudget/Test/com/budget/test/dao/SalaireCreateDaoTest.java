package com.budget.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.budget.dao.ISalaireDao;
import com.budget.entity.Salaire;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/test-context.xml")
public class SalaireCreateDaoTest {
	
	@Autowired
	ISalaireDao salaireDao;
	
	@Test
	public void test(){
		Salaire salaire = new Salaire("papa", 1600.99);
		Salaire salaire1 = new Salaire("maman", 1500.00);
		salaireDao.createSalaire(salaire);
		salaireDao.createSalaire(salaire1);
	}

}
