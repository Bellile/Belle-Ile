package fr.adaming.daoTest;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class ClientDaoImplTest {
	
	@Autowired
	IClientDao cDao;
	
	

	public void setcDao(IClientDao cDao) {
		this.cDao = cDao;
	}
	
	
	@Test
	@Ignore
	@Transactional
	@Rollback(true)
	public void testAdd(){
		
		 
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
