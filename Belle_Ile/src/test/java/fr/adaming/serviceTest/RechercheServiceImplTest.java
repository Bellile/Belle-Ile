package fr.adaming.serviceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVolDao;
import fr.adaming.model.Client;
import fr.adaming.model.Hotel;
import fr.adaming.model.LocationVoiture;
import fr.adaming.model.Offre;
import fr.adaming.model.Reservation;
import fr.adaming.model.Vol;
import fr.adaming.service.IRechercheService;

/**
 * Class test du Service recherche
 * @author Adaming
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class RechercheServiceImplTest {

	@Autowired
	IRechercheService reService;
	
	@Autowired
	IVolDao vDao;
	
	//----Methode de recherche hotel par nom
		@Test
		@Ignore
		@Transactional(readOnly=true)
		public void testSearchHotelName() {
			
			assertEquals(2, reService.searchByNameHotel("Hotel").size());
		}
		
		@Test
		@Ignore
		@Transactional(readOnly=true)
		public void testSearchHotelAdresse() {
			
			assertEquals(1, reService.searchByAdresseHotel("France").size());
		}
		
		@Test
		@Ignore
		@Transactional(readOnly=true)
		public void testSearchHotelCat() {
			
			assertEquals(1, reService.searchByCatHotel("Pacifique").size());
		}
		
		@Test
		@Ignore
		@Transactional(readOnly=true)
		public void testSearchOffreHotel() {
			Hotel hotel = new Hotel();
			hotel.setNom("Hotel");
			assertEquals(1, reService.searchByHotelOffre(hotel).size());
		}
		
		
		@Test
		@Ignore
		@Transactional(readOnly=true)
		public void testSearchOffrePromo() {
			Offre offre = new Offre();
			offre.setPromo(0.50);
			assertEquals(0, reService.searchByPromoOffre(offre).size());
		}
		
		@Test
		@Ignore
		@Transactional(readOnly=true)
		public void testSearchOffrePrix() {
			Offre offre = new Offre();
			offre.setPrix(880);
			assertEquals(1, reService.searchByPrixOffre(offre).size());
		}
		
		@Test
		@Ignore
		@Transactional(readOnly=true)
		public void testSearchAccResa() {
			Reservation resa = new Reservation();
			resa.setId_resa(2);
			assertEquals(0, reService.searchByResaAcc(resa).size());
		}
		
		@Test
		@Ignore
		@Transactional(readOnly=true)
		public void testSearchLocType() {
			
			assertEquals(1, reService.searchByTypeLoc("C").size());
		}
		
		@Test
		@Ignore
		@Transactional(readOnly=true)
		public void testSearchLocPrix() {
			LocationVoiture locV = new LocationVoiture();
			locV.setPrixJournee(10.80);
			assertEquals(0, reService.searchByPrixLoc(locV).size());
		}
		
		@Test
		@Ignore
		@Transactional(readOnly=true)
		public void testSearchResaClient() {
			Client client = new Client();
			client.setId(2);
			assertEquals(0, reService.searchByClientResa(client).size());
		}
		
		@Test
		@Ignore
		@Transactional(readOnly=true)
		public void testSearchClientMail() {
			Client client = new Client();
			client.setMail("a@a");
			assertEquals("Bob", reService.searchByMailClient(client).getNom());
		}
		
		@Test
		@Ignore
		@Transactional(readOnly=true)
		public void testSearchOffreDepart () {
			Vol vol = new Vol();
			vol.setId_vol(2);
			assertEquals(0, reService.searchByDepartOffre(vDao.searchVolById(vol)).size());
		}
		
		@Test
		@Ignore
		@Transactional(readOnly=true)
		public void testSearchOffreRetour () {
			Vol vol = new Vol();
			vol.setId_vol(1);
			assertEquals(1, reService.searchByRetourOffre(vDao.searchVolById(vol)).size());
		}
}
