package fr.adaming.daoTest;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVolDao;
import fr.adaming.model.Vol;

//permet de lance
@RunWith(SpringJUnit4ClassRunner.class)
// permet de définir la localisation du fichier de configuration
// application-context pour lire les annotations
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
public class VolDaoImplTest {

	/**
	 * Attribut pour l'injection de dépendance
	 */
	@Autowired
	private IVolDao volDao;

	/**
	 * Setter pour l'injection dépendance
	 * 
	 * @param volDao
	 */
	public void setVolDao(IVolDao volDao) {
		this.volDao = volDao;
	}

	private List<Vol> listeVol;

	/**
	 * Permet d'instancier une liste pour faire les différents test de méthode
	 */
	@Before
	public void beforeMethod() {
		this.listeVol = volDao.searchAllVol();
	}

	/**
	 * Vérifie la taille de la liste
	 */
	//@Test
	@Ignore
	@Transactional(readOnly = true)
	public void testSearchAllVolSizeListe() {

		List<Vol> liste = volDao.searchAllVol();

		assertEquals(listeVol.size(), liste.size());
	}

	/**
	 * vérifie la valeur de l'attribut depart du premier element de la liste
	 */
	//@Test
	@Ignore
	@Transactional(readOnly = true)
	public void testSearchAllVolFirst() {

		List<Vol> liste = volDao.searchAllVol();

		assertEquals("Taiti", liste.get(0).getArrivee());
	}

	//@Test
	@Ignore
	@Transactional(readOnly = true)
	public void testSearchVolByIdValDepart() {

		Vol volIn = new Vol();
		volIn.setId_vol(1);

		Vol volOut = volDao.searchVolById(volIn);

		assertEquals("Taiti", volOut.getArrivee());
	}

	//@Test
	@Ignore
	@Transactional
	public void testAddVolSizeListe() {

		Vol volIn = new Vol("Paris", "La Réunion", null, null);

		volDao.addVol(volIn);

		assertEquals(3, volDao.searchAllVol().size());
	}

	//@Test
	@Ignore
	@Transactional
	public void testDeleteVolSizeListe() {

		Vol volIn = new Vol();
		volIn.setId_vol(2);

		volDao.deleteVol(volIn);

		assertEquals(1, volDao.searchAllVol().size());
	}

	//@Test
	@Ignore
	@Transactional
	public void testUpdateVolValDepart() {
		Vol volIn = new Vol();
		volIn.setId_vol(1);
		
		Vol volOut=volDao.searchVolById(volIn);

		volOut.setDepart("Lyon");
		
		volDao.updateVol(volOut);

		assertEquals("Lyon", volDao.searchVolById(volIn).getDepart());

	}
}
