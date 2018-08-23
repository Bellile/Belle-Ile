package fr.adaming.serviceTest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVolDao;
import fr.adaming.model.Vol;
import fr.adaming.service.IVolService;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//permet de lance
@RunWith(SpringJUnit4ClassRunner.class)
//permet de définir la localisation du fichier de configuration application-context pour lire les annotations
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class VolServiceImplTest {

	/**
	 * Attribut pour l'injection de dépendance
	 */
	@Autowired
	private IVolService volService;

	/**
	 * Setter pour l'injection dépendance
	 * 
	 * @param volDao
	 */
	public void setVolService(IVolService volService) {
		this.volService = volService;
	}

	private List<Vol> listeVol;

	/**
	 * Permet d'instancier une liste pour faire les différents test de méthode
	 */
	@Before
	public void beforeMethod() {
		this.listeVol = volService.searchAllVol();
	}

	/**
	 * Vérifie la taille de la liste
	 */
	@Test
	@Ignore
	@Transactional(readOnly = true)
	public void testSearchAllVolSizeListe() {

		List<Vol> liste = volService.searchAllVol();

		assertEquals(listeVol.size(), liste.size());
	}

	/**
	 * vérifie la valeur de l'attribut depart du premier element de la liste
	 */
	@Test
	@Ignore
	@Transactional(readOnly = true)
	public void testSearchAllVolFirst() {

		List<Vol> liste = volService.searchAllVol();

		assertEquals("Taiti", liste.get(0).getArrivee());
	}

	@Test
	@Ignore
	@Transactional(readOnly = true)
	public void testSearchVolByIdValDepart() {

		Vol volIn = new Vol();
		volIn.setId_vol(1);

		Vol volOut = volService.searchVolById(volIn);

		assertEquals("Taiti", volOut.getArrivee());
	}

	@Test
	@Ignore
	@Transactional
	public void testAddVolSizeListe() {

		Vol volIn = new Vol("Paris", "La Réunion", null, null);

		volService.addVol(volIn);

		assertEquals(3, volService.searchAllVol().size());
	}

	@Test
	@Ignore
	@Transactional
	public void testDeleteVolSizeListe() {

		Vol volIn = new Vol();
		volIn.setId_vol(2);

		volService.deleteVol(volIn);

		assertEquals(1, volService.searchAllVol().size());
	}

	@Test
	@Ignore
	@Transactional
	public void testUpdateVolValDepart() {
		Vol volIn = new Vol();
		volIn.setId_vol(1);
		
		Vol volOut=volService.searchVolById(volIn);

		volOut.setDepart("Lyon");
		
		volService.updateVol(volOut);

		assertEquals("Lyon", volService.searchVolById(volIn).getDepart());

	}
}
