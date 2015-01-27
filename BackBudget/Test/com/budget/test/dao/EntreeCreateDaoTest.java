package com.budget.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.budget.dao.IEntreeDao;
import com.budget.entity.Entree;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/test-context.xml")
public class EntreeCreateDaoTest {
	
	@Autowired
	IEntreeDao entreeDao;
	
	@Test
	public void test(){
		Entree entree = new Entree("CAF", 49.99);
		Entree entree1 = new Entree("APL", 29.99);
		entreeDao.createEntree(entree);
		entreeDao.createEntree(entree1);
	}

}
