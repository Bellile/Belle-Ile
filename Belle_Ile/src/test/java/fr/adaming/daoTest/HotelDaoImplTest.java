package fr.adaming.daoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ICategorieDao;
import fr.adaming.dao.IHotelDao;
import fr.adaming.model.Adresse;
import fr.adaming.model.Categorie;
import fr.adaming.model.Hotel;

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
	
	@Autowired
	ICategorieDao catDao;
	
	//----Test de la méthode afficher liste
	//Test de la longueur
	@Test
	@Ignore
	@Transactional(readOnly=true)
	public void testSearchAllHotelSize() {
		
		assertEquals(1, hDao.searchAllHotel().size());
	}
	
	//Test du premier objet de la liste
	@Test
	@Ignore
	@Transactional(readOnly=true)
	public void testSearchAllHotelFirst() {
		
		assertEquals("Le Palme", hDao.searchAllHotel().get(0).getNom());
	}
	
	//----Test de la méthode ajouter
	@Test
	@Ignore
	@Transactional
	public void testAddHotelSize() {
		//Instanciation d'un hotel
		Adresse adresse = new Adresse("Royal Road","35051" ,"Pointe aux Piments" , "île Maurice");
		Hotel h = new Hotel("Demi-pension", "Recif Attitude", true, true, null, adresse);
		Categorie cat = new Categorie();
		cat.setId_cat(1);
		Categorie catIn = catDao.searchByIdCat(cat);
		h.setCategorie(catIn);
		hDao.addHotel(h);
		assertEquals(2, hDao.searchAllHotel().size());
	}
	@Test
	@Ignore
	@Transactional
	public void testAddHotelCat() {
		//Instanciation d'un hotel
		Adresse adresse = new Adresse("Royal Road","35051" ,"Pointe aux Piments" , "île Maurice");
		Hotel h = new Hotel("Demi-pension", "Recif Attitude", true, true, null, adresse);
		Categorie cat = new Categorie();
		cat.setId_cat(1);
		Categorie catIn = catDao.searchByIdCat(cat);
		h.setCategorie(catIn);
		hDao.addHotel(h);
		assertEquals(1, hDao.searchAllHotel().get(1).getCategorie().getId_cat());
	}
	
	//----Test de la méthode suppr
	@Test
	@Ignore
	@Transactional
	public void testDeleteHotelSize() {
		Hotel h = new Hotel();
		h.setId_hotel(1);
		
		hDao.deleteHotel(h);
		assertEquals(0, hDao.searchAllHotel().size());
	}
	
	//----Test de la méthode modifier
	@Test
	@Ignore
	@Transactional
	public void testUpdateHotelName() {
		//Instanciation d'un hotel
		Adresse adresse = new Adresse("Royal Road","35051" ,"Pointe aux Piments" , "île Maurice");
		Hotel h = new Hotel(1, "Demi-pension", "Recif Attitude", true, true, null, adresse);
		Categorie cat = new Categorie();
		cat.setId_cat(1);
		Categorie catIn = catDao.searchByIdCat(cat);
		h.setCategorie(catIn);
		hDao.updateHotel(h);
		
		assertEquals("Recif Attitude", hDao.searchAllHotel().get(0).getNom());
	}
	
	//----Test de la méthode getById
	@Test
	@Ignore
	@Transactional
	public void testSearchByIdHotel() {
		Hotel h = new Hotel();
		h.setId_hotel(1);
		
		assertEquals("Le Palme", hDao.searchByIdhotel(h).getNom());
		
		
	}
	
}
