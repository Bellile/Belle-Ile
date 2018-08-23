package fr.adaming.daoTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import javax.xml.bind.annotation.XmlRegistry;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ILocationVoitureDao;
import fr.adaming.model.LocationVoiture;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class LocationVoitureDaoImplTest {
	
	@Autowired
	ILocationVoitureDao lcDao;
	
	
	
	public void setLcDao(ILocationVoitureDao lcDao) {
		this.lcDao = lcDao;
	}


	//@Test
	@Ignore
	@Transactional
	@Rollback(true)
	public void testAdd() {

		int expected = 1;
		LocationVoiture lcTest = new LocationVoiture(5, "bmw", 5, null);

		assertEquals(1, lcDao.searchAllLC().size());

	}
	
	
	//@Test
	@Ignore
	@Transactional(readOnly=true)
	public void testSerchAll(){
		assertEquals("bmw", lcDao.searchAllLC().get(0).getTypeVoiture());
		
	}
	
	//@Test
	@Ignore
	@Transactional
	@Rollback(true)
	public void testUpdate(){
		LocationVoiture lc1=new LocationVoiture(5, "bmw", 5, null);
		LocationVoiture lc2 = new LocationVoiture(6, "r21", 6, null);
		
		assertNotSame(lc1, lcDao.update(lc2));
				
	}
	
	//@Test
	@Ignore
	@Transactional
	public void testDelete(){
		
		LocationVoiture lc1=new LocationVoiture();
		lc1.setId_location(1);
		lcDao.delete(lc1);
		assertEquals(0, lcDao.searchAllLC().size());
		
	}
	
	
	
	//@Test
	@Ignore
	@Transactional
	public void testGetById(){
		
		LocationVoiture lc = new LocationVoiture();
		lc.setId_location(1);		
		
		assertEquals(1, lcDao.searchById(lc).getId_location());
		
		
		
		
	}
	
	
	
	
	
	
	

}
