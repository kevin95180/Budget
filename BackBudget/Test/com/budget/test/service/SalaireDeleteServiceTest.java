package com.budget.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.budget.dto.SalaireDto;
import com.budget.service.ISalaireService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/test-context.xml")
public class SalaireDeleteServiceTest {
	
	@Autowired
	ISalaireService salaireService;
	
	@Test
	public void test(){
		SalaireDto salaireDto = new SalaireDto();
		salaireDto.setNomSalaire("kevin");
		salaireService.deleteSalaire(salaireDto);
	}

}
