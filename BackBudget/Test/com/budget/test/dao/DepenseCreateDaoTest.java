package com.budget.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.budget.dao.IDepenseDao;
import com.budget.entity.Depense;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/test-context.xml")
public class DepenseCreateDaoTest {
	
	@Autowired
	IDepenseDao depenseDao;
	
	@Test
	public void test(){
//		Depense depense = new Depense("EDF", 10.95);
//		Depense depense1 = new Depense("Cantine", 70.95);
//		depenseDao.createDepense(depense);
//		depenseDao.createDepense(depense1);
	}

}
