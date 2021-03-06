package fr.adaming.daoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IOffreDao;
import fr.adaming.model.Offre;

//permet de lance
@RunWith(SpringJUnit4ClassRunner.class)
// permet de d�finir la localisation du fichier de configuration
// application-context pour lire les annotations
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
public class OffreDaoImplTest {

	@Autowired
	private IOffreDao offreDao;

	public void setOffreDao(IOffreDao offreDao) {
		this.offreDao = offreDao;
	}

	@Test
	@Ignore
	@Transactional(readOnly = true)
	public void testSearchAllOffreSizeListe () {
		
		assertEquals(2,offreDao.searchAllOffre().size());
	}

	@Test
	@Ignore
	@Transactional(readOnly=true)
	public void testSearchOffreByIdValPrix () {
		
		Offre offreIn=new Offre();
		offreIn.setId_offre(1);
		
		
		Offre offreOut=offreDao.searchOffreById(offreIn);
		
		assertEquals (10, offreOut.getNbDispo());
	}
	
	
	@Test
	@Ignore
	@Transactional
	public void testAddOffreSizeListe () {
		Offre offreIn=new Offre(20, 4000, 20, 0, null);
		
		offreDao.addOffre(offreIn);
		
		assertEquals(3,offreDao.searchAllOffre().size());
	}
	
	
	@Test
	@Ignore
	@Transactional
	public void testDeleteOffreSizeListe () {
		Offre offreIn=new Offre();
		offreIn.setId_offre(1);
		
		offreDao.deleteOffre(offreIn);
		
		assertEquals(1,offreDao.searchAllOffre().size());
	}
	
	@Test
	@Ignore
	@Transactional
	public void testUpdateOffreValNbDipo () {
		Offre offreIn=new Offre();
		offreIn.setId_offre(4);
		
		Offre offreOut=offreDao.searchOffreById(offreIn);
		offreOut.setNbDispo(20);
		
		offreDao.updateOffre(offreOut);
		
		assertEquals (20, offreDao.searchOffreById(offreIn).getNbDispo());
		
	}
}
