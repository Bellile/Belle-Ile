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

import fr.adaming.dao.IOffreDao;
import fr.adaming.model.Hotel;
import fr.adaming.model.LocationVoiture;
import fr.adaming.model.Offre;
import fr.adaming.model.Vol;
import fr.adaming.service.IOffreService;

//permet de lance
@RunWith(SpringJUnit4ClassRunner.class)
// permet de définir la localisation du fichier de configuration
// application-context pour lire les annotations
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
public class OffreServiceImplTest {

	@Autowired
	private IOffreService offreService;

	public void setOffreDao(IOffreService offreService) {
		this.offreService = offreService;
	}

	@Test
	@Ignore
	@Transactional(readOnly = true)
	public void testSearchAllOffreSizeListe () {
		
		assertEquals(3,offreService.searchAllOffre().size());
	}

	@Test
	@Ignore
	@Transactional(readOnly=true)
	public void testSearchOffreByIdValPrix () {
		
		Offre offreIn=new Offre();
		offreIn.setId_offre(1);
		
		
		Offre offreOut=offreService.searchOffreById(offreIn);
		
		assertEquals (10, offreOut.getNbDispo());
	}
	
	
	@Test
	@Ignore
	@Transactional
	public void testAddOffreSizeListe () {
		Offre offreIn=new Offre(20, 4000, 20, 0, null);
			
		offreService.addOffre(offreIn);
		
		assertEquals(4,offreService.searchAllOffre().size());
	}
	
	
	@Test
	@Ignore
	@Transactional
	public void testDeleteOffreSizeListe () {
		Offre offreIn=new Offre();
		offreIn.setId_offre(1);
		
		offreService.deleteOffre(offreIn);
		
		assertEquals(2,offreService.searchAllOffre().size());
	}
	
	@Test
	@Ignore
	@Transactional
	public void testUpdateOffreValNbDipo () {
		Offre offreIn=new Offre();
		offreIn.setId_offre(4);
		
		Offre offreOut=offreService.searchOffreById(offreIn);
		offreOut.setNbDispo(20);

		
		offreService.updateOffre(offreOut);
		
		assertEquals (20, offreService.searchOffreById(offreIn).getNbDispo());
		
	}
}
