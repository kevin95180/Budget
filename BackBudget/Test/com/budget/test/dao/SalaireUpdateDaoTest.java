package com.budget.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.budget.dao.ISalaireDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/test-context.xml")
public class SalaireUpdateDaoTest {
	
	@Autowired
	ISalaireDao salaireDao;
	
	@Test
	public void test(){
		salaireDao.updateSalaire("papa", 300.0);
	}

}
