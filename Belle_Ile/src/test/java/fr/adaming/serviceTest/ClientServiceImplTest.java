package fr.adaming.serviceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Adresse;
import fr.adaming.model.Client;
import fr.adaming.model.Role;
import fr.adaming.service.IClientService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
public class ClientServiceImplTest {

	/*
	 * Association Uml en java
	 */
	@Autowired
	private IClientService cService;

	/*
	 * Setter pour l'injection dépendance
	 */
	
	public void setcService(IClientService cService) {
		this.cService = cService;
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
		
		cService.addCl(clTest);

		assertEquals(2, cService.searchAllCl().size());

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
		 
		 cService.updateCl(cl2Test);
		 
		 assertEquals("aaaaa", cService.searchByIdCl(cl2Test).getNom());
	}

	
	@Test
	@Ignore
	@Transactional(readOnly=true)	
	public void testGetAllCL(){
		
		assertEquals("Valentin", cService.searchAllCl().get(0).getPrenom());
		
	}
	
	@Test
	@Ignore
	@Transactional
	public void testGetById(){
		
		Client cl = new Client();
		cl.setId(1);
		
		assertEquals(1, cService.searchByIdCl(cl).getId());
		
	}
	
	@Test
	@Ignore
	@Transactional
	public void testDeleteCL(){
		
		Client cl1=new Client();
		cl1.setId(2);
		cService.deleteCl(cl1);
		
		assertEquals(1, cService.searchAllCl().size());
		
		
	}
	
	
	
	
	
	
	
	

}
