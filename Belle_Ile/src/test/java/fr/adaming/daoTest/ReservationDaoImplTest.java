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

import fr.adaming.dao.IReservationDao;
import fr.adaming.model.Accompagnant;
import fr.adaming.model.Client;
import fr.adaming.model.Reservation;
import fr.adaming.service.IAccompagnantService;

//permet de lance
@RunWith(SpringJUnit4ClassRunner.class)
// permet de définir la localisation du fichier de configuration
// application-context pour lire les annotations
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
public class ReservationDaoImplTest {

	@Autowired
	private IReservationDao resaDao;

	public void setResaDao(IReservationDao resaDao) {
		this.resaDao = resaDao;
	}

	@Autowired
	private IAccompagnantService accompService;

	public void setAccompService(IAccompagnantService accompService) {
		this.accompService = accompService;
	}

	@Test
	@Transactional
	public void testSearchAllResaSizeListe() {
		List<Reservation> listeResa = resaDao.searchAllResa();

		assertEquals(2, listeResa.size());
	}

	@Test
	@Transactional
	public void testSearchResaByIdValClient() {

		Reservation resaIn = new Reservation();
		resaIn.setId_resa(2);

		Reservation resaOut = resaDao.searchResaById(resaIn);

		assertEquals(2, resaOut.getClient().getId());

	}

	@Test
	@Transactional
	public void testAddResaSizeListe() {
		Client clIn = new Client();
		clIn.setId(1);

		Reservation resaIn = new Reservation();
		resaIn.setClient(clIn);

		resaDao.addResa(resaIn);

		assertEquals(3, resaDao.searchAllResa().size());
	}

	@Test
	@Transactional
	public void testDeleteResaSizeListe() {
		Client clIn=new Client();
		clIn.setId(2);
		
		Reservation resaIn = new Reservation();
		resaIn.setId_resa(2);
		resaIn.setClient(clIn);

		//on supprime les accompagnants associé à la réservation avant de supprimer la resa
		Accompagnant accomp=new Accompagnant();
		accomp.setId(3);
		
		accompService.deleteAccomp(accomp, resaIn);
		
		resaDao.deleteResa(resaIn);

		assertEquals(1, resaDao.searchAllResa().size());
	}

	@Test
	@Transactional
	public void testUpdateResaValClient() {

		Reservation resaIn = new Reservation();
		resaIn.setId_resa(2);




		Reservation resaOut = resaDao.searchResaById(resaIn);
		resaOut.setNbrePlace(50);

		resaDao.updateResa(resaOut);

		Reservation resaOut2 = resaDao.searchResaById(resaIn);

		assertEquals(50, resaOut2.getNbrePlace());

	}

}
