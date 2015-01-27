package com.budget.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.budget.dao.IDepenseDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/test-context.xml")
public class DepenseListDaoTest {
	
	@Autowired
	IDepenseDao depenseDao;
	
	@Test
	public void test(){
		System.out.println(depenseDao.findAll());
	}
	
}
