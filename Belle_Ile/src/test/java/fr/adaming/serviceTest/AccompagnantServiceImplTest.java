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

import fr.adaming.model.Accompagnant;
import fr.adaming.model.Reservation;
import fr.adaming.service.IAccompagnantService;

//permet de lance
@RunWith(SpringJUnit4ClassRunner.class)
// permet de définir la localisation du fichier de configuration
// application-context pour lire les annotations
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
public class AccompagnantServiceImplTest {

	// injection dépendance
	@Autowired
	private IAccompagnantService accompService;

	// setter pour l'injection dépendance
	public void setAccompService(IAccompagnantService accompService) {
		this.accompService = accompService;
	}

	@Test
	@Ignore
	@Transactional
	public void testSearchAllAccompSizeListe() {
		List<Accompagnant> liste = accompService.searchAllAccomp();

		assertEquals(3, liste.size());

	}

	@Test
	@Ignore
	@Transactional
	public void testSearchAccompByIdValNom() {

		Accompagnant accompIn = new Accompagnant();
		accompIn.setId(1);

		Accompagnant accompOut = accompService.searchAccompById(accompIn);

		assertEquals("aaaa", accompOut.getNom());
	}

	@Test
	@Ignore
	@Transactional
	public void testSearchAccompByResaSizeListe() {
		Reservation resaIn = new Reservation();
		resaIn.setId_resa(1);

		List<Accompagnant> listeResa = accompService.searchAccompByIdResa(resaIn);

		assertEquals(2, listeResa.size());
	}

	@Test
	@Ignore
	@Transactional
	public void testAddAccomp() {
		Accompagnant accomp = new Accompagnant();
		accomp.setNom("TOTO");

		Reservation resa = new Reservation();
		resa.setId_resa(1);

		accompService.addAccomp(accomp, resa);

		assertEquals(4, accompService.searchAllAccomp().size());
	}

	@Test
	@Ignore
	@Transactional
	public void testDeleteAccomp() {
		Accompagnant accomp = new Accompagnant();
		accomp.setId(1);
		Reservation resa = new Reservation();
		resa.setId_resa(1);

		accompService.deleteAccomp(accomp, resa);

		assertEquals(2, accompService.searchAllAccomp().size());

	}

	@Test
	@Ignore
	@Transactional
	public void testUpdateAccomp() {
		Accompagnant accompIn = new Accompagnant();
		accompIn.setId(1);
		Reservation resa = new Reservation();
		resa.setId_resa(1);

		Accompagnant accompOut = accompService.searchAccompById(accompIn);
		accompOut.setNom("Clement");

		accompService.updateAccomp(accompOut, resa);

		Accompagnant accompOut2 = accompService.searchAccompById(accompIn);

		assertEquals("Clement", accompOut2.getNom());
	}
}
