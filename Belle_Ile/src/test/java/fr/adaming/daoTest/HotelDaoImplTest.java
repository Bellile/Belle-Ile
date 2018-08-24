package fr.adaming.daoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IHotelDao;

/**
 * Class test du DAO categorie
 * @author Adaming
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class HotelDaoImplTest {

	//Association IHotelDao
	@Autowired
	IHotelDao hDao;
	
	//----Test de la méthode afficher liste
	//Test de la longueur
	@Test
	@Transactional(readOnly=true)
	public void testSearchAllHotelSize() {
		
		assertEquals(1, hDao.searchAllHotel().size());
	}
	
	//Test du premier objet de la liste
	@Test
	@Ignore
	@Transactional(readOnly=true)
	public void testSearchAllHotelFirst() {
		
	}
	
}
