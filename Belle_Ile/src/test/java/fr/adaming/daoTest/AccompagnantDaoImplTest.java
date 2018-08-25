package fr.adaming.daoTest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAccompagnantDao;
import fr.adaming.model.Accompagnant;
import fr.adaming.model.Reservation;

//permet de lance
@RunWith(SpringJUnit4ClassRunner.class)
//permet de définir la localisation du fichier de configuration
//application-context pour lire les annotations
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
public class AccompagnantDaoImplTest {
	
	//injection dépendance
	@Autowired
	private IAccompagnantDao accompDao;

	//setter pour l'injection dépendance
	public void setAccompDao(IAccompagnantDao accompDao) {
		this.accompDao = accompDao;
	}

	@Test
	@Ignore
	@Transactional
	public void testSearchAllAccompSizeListe () {
		List<Accompagnant> liste = accompDao.searchAllAccomp();
		
		assertEquals(3, liste.size());
			
	}
	
	@Test
	@Ignore
	@Transactional
	public void testSearchAccompByIdValNom () {
		
		Accompagnant accompIn=new Accompagnant();
		accompIn.setId(1);
		
		Accompagnant accompOut=accompDao.searchAccompById(accompIn);
		
		assertEquals("cccc", accompOut.getNom());
	}
	
	
	@Test
	@Ignore
	@Transactional
	public void testSearchAccompByResaSizeListe () {
		Reservation resaIn=new Reservation();
		resaIn.setId_resa(1);
		
		List <Accompagnant> listeResa=accompDao.searchAccompByIdResa(resaIn);
		
		assertEquals(2, listeResa.size());
	}
	
	@Test
	@Ignore
	@Transactional
	public void testAddAccomp () {
		Accompagnant accomp=new Accompagnant();
		accomp.setNom("TOTO");
		
		accompDao.addAccomp(accomp);
		
		assertEquals(4, accompDao.searchAllAccomp().size());
	}
	
	@Test
	@Ignore
	@Transactional
	public void testDeleteAccomp () {
		Accompagnant accomp=new Accompagnant();
		accomp.setId(1);
		
		accompDao.deleteAccomp(accomp);
		
		assertEquals(2, accompDao.searchAllAccomp().size());
		
	}
	
	@Test
	@Ignore
	@Transactional
	public void testUpdateAccomp () {
		Accompagnant accompIn=new Accompagnant();
		accompIn.setId(1);
		
		Accompagnant accompOut=accompDao.searchAccompById(accompIn);
		accompOut.setNom("Clement");
		
		accompDao.updateAccomp(accompOut);
		
		Accompagnant accompOut2=accompDao.searchAccompById(accompIn);
		
		assertEquals("Clement", accompOut2.getNom());
	}
}












