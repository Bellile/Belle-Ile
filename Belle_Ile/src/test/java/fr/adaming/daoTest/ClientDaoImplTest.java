package fr.adaming.daoTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Adresse;
import fr.adaming.model.Client;
import fr.adaming.model.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
public class ClientDaoImplTest {

	@Autowired
	IClientDao cDao;

	/*
	 * Setter pour l'injection dépendance
	 */
	
	public void setcDao(IClientDao cDao) {
		this.cDao = cDao;
	}

	@Test
	@Ignore
	@Transactional
	@Rollback(true)
	public void testAdd() {

		int expected = 1;
		Client clTest = new Client();
		clTest.setNom("Zuk");
		clTest.setPrenom("val");
		
		cDao.addCl(clTest);

		assertEquals(2, cDao.searchAllCl().size());

	}


	@Test	
	@Ignore
	@Transactional
	@Rollback(true)
	public void testUpdate(){
		
		
		Role role = new Role();		
		role.setId_role(1);
		Adresse adresse = new Adresse();
	
		
		Client cl2Test = new Client();
		cl2Test.setId(1);
		cl2Test.setNom("aaaaa");
		 cl2Test.setRole(role);
		 cl2Test.setAdresse(adresse);
		 
		 cDao.updateCl(cl2Test);
		 
		 assertEquals("aaaaa", cDao.searchByIdCl(cl2Test).getNom());
	}

	
	@Test
	@Ignore
	@Transactional(readOnly=true)	
	public void testGetAllCL(){
		
		assertEquals("Valentin", cDao.searchAllCl().get(0).getPrenom());
		
	}
	
	@Test
	@Ignore
	@Transactional
	public void testGetById(){
		
		Client cl = new Client();
		cl.setId(1);
		
		assertEquals(1, cDao.searchByIdCl(cl).getId());
		
	}
	
	@Test
	@Ignore
	@Transactional
	public void testDeleteCL(){
		
		Client cl1=new Client();
		cl1.setId(2);
		cDao.deleteCl(cl1);
		
		assertEquals(1, cDao.searchAllCl().size());
		
		
	}
	
	
	
	
	
	
	
	
	
}
