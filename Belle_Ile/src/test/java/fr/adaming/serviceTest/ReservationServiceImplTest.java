package fr.adaming.serviceTest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IOffreDao;
import fr.adaming.model.Client;
import fr.adaming.model.Offre;
import fr.adaming.model.Reservation;
import fr.adaming.service.IReservationService;

//permet de lance
@RunWith(SpringJUnit4ClassRunner.class)
// permet de définir la localisation du fichier de configuration
// application-context pour lire les annotations
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
public class ReservationServiceImplTest {

	@Autowired
	private IReservationService resaService;

	public void setResaService(IReservationService resaService) {
		this.resaService = resaService;
	}

	@Autowired
	private IOffreDao offreDao;

	public void setOffreDao(IOffreDao offreDao) {
		this.offreDao = offreDao;
	}

	@Test
	@Ignore
	@Transactional
	public void testSearchAllResaSizeListe() {
		List<Reservation> listeResa = resaService.searchAllResa();

		assertEquals(2, listeResa.size());
	}

	@Test
	@Ignore
	@Transactional
	public void testSearchResaByIdValClient() {

		Reservation resaIn = new Reservation();
		resaIn.setId_resa(2);

		Reservation resaOut = resaService.searchResaById(resaIn);

		assertEquals(2, resaOut.getClient().getId());

	}

	@Test
	@Ignore
	@Transactional
	public void testAddResaSizeListe() {
		Client clIn = new Client();
		clIn.setId(1);

		Offre offreIn = new Offre();
		offreIn.setId_offre(1);

		Reservation resaIn = new Reservation();
		resaIn.setNbrePlace(20);

		resaService.addResa(resaIn, clIn, offreIn);

		assertEquals(1, resaService.searchResaById(resaIn).getOffre().getId_offre());
	}

	@Test
	@Ignore
	@Transactional
	public void testDeleteResaSizeListe() {
		Client clIn = new Client();
		clIn.setId(2);

		Offre offreIn = new Offre();
		offreIn.setId_offre(1);

		Reservation resaIn = new Reservation();
		resaIn.setId_resa(2);

		resaService.deleteResa(resaIn, clIn, offreIn);

		assertEquals(1, resaService.searchAllResa().size());
	}

	@Test
	@Ignore
	@Transactional
	public void testUpdateResaValClient() {
		Reservation resaIn = new Reservation();
		resaIn.setId_resa(2);

		Reservation resaOut = resaService.searchResaById(resaIn);
		resaOut.setNbrePlace(50);
		;

		Client clIn = new Client();
		clIn.setId(2);

		Offre offreIn = new Offre();
		offreIn.setId_offre(1);

		resaService.updateResa(resaIn, clIn, offreIn);

		Reservation resaOut2 = resaService.searchResaById(resaIn);

		assertEquals(50, resaOut2.getNbrePlace());

	}

	@Test
	@Ignore
	@Transactional
	public void testVerifNbrePlace () {
		
		Reservation resaIn = new Reservation();
		resaIn.setId_resa(2);
		resaIn.setNbrePlace(11);
		
		Offre offreIn=new Offre();
		offreIn.setId_offre(1);
		
		resaService.verifNbrePlaceDispo(resaIn, offreIn);
		
		assertEquals(10, offreDao.searchOffreById(offreIn).getNbDispo());
		
	}
}
