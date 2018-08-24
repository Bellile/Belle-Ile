package fr.adaming.serviceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


import fr.adaming.model.Adresse;
import fr.adaming.model.Categorie;
import fr.adaming.model.Hotel;
import fr.adaming.service.IHotelService;

/**
 * Class test du Service Hotel
 * @author Adaming
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class HotelServiceImplTest {
	
		//Association IHotelService
		@Autowired
		IHotelService hService;
		
		
		//----Test de la méthode afficher liste
		//Test de la longueur
		@Test
		@Ignore
		@Transactional(readOnly=true)
		public void testSearchAllHotelSize() {
			
			assertEquals(1, hService.searchAllHotel().size());
		}
		
		//Test du premier objet de la liste
		@Test
		@Ignore
		@Transactional(readOnly=true)
		public void testSearchAllHotelFirst() {
			
			assertEquals("Le Palme", hService.searchAllHotel().get(0).getNom());
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
			hService.addHotel(h, cat);
			assertEquals(2, hService.searchAllHotel().size());
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
			hService.addHotel(h, cat);
			assertEquals(1, hService.searchAllHotel().get(1).getCategorie().getId_cat());
		}
		
		//----Test de la méthode suppr
		@Test
		@Ignore
		@Transactional
		public void testDeleteHotelSize() {
			Hotel h = new Hotel();
			h.setId_hotel(1);
			
			hService.deleteHotel(h);
			assertEquals(0, hService.searchAllHotel().size());
		}
		
		//----Test de la méthode modifier
		@Test
		@Ignore
		@Transactional
		public void testUpdateHotelName() {
			//Instanciation d'un hotel
			Adresse adresse = new Adresse("Royal Road","35051" ,"Pointe aux Piments" , "île Maurice");
			Hotel h = new Hotel(1, "Demi-pension", "Recif Attitude", true, true, null, adresse);

			hService.updateHotel(h);
			
			assertEquals("Recif Attitude", hService.searchAllHotel().get(0).getNom());
		}
		
		//----Test de la méthode getById
		@Test
		@Ignore
		@Transactional
		public void testSearchByIdHotel() {
			Hotel h = new Hotel();
			h.setId_hotel(1);
			
			assertEquals("Le Palme", hService.searchByIdHotel(h).getNom());
			
			
		}

}
