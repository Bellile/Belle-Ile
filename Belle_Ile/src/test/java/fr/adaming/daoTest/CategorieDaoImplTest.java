/**
 * 
 */
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
import fr.adaming.model.Categorie;

/**
 * Class test du DAO categorie
 * @author Adaming
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class CategorieDaoImplTest {

	@Autowired
	ICategorieDao catDao;
	
	//-----Test de la méthode searchAllCat
	//Test par rapport à la longueur de la liste
	@Test
	@Ignore
	@Transactional(readOnly=true)
	public void testSearchAllCatSize() {
		
		assertEquals(3, catDao.searchAllCat().size());
	}
	
	//Test par rapport au premier objet de la liste
	@Test
	@Ignore
	@Transactional(readOnly=true)
	public void testSearchAllCatFirst() {
		
		assertEquals("Indien", catDao.searchAllCat().get(0).getOcean());
	}
	
	//-----Test de la méthode searchByIdCat
	//Test par rapport à une valeur
	@Test
	@Ignore
	@Transactional(readOnly=true)
	public void testSearchByIdCat() {
		//Instanciation d'une catégorie
		Categorie cat = new Categorie();
		cat.setId_cat(2);
		
		assertEquals("Pacifique", catDao.searchByIdCat(cat).getOcean());
	}
	
	//-----Test de la méthode addCat
	//Test par rapport à la longueur de liste
	@Test
	@Ignore
	@Transactional
	public void testAddCat() {
		//Instanciation d'une catégorie à ajouter
		Categorie cat = new Categorie("Arctique");
		
		catDao.addCat(cat);
		
		assertEquals(4, catDao.searchAllCat().size());
	}
	
	//-----Test de la méthode deleteCat
	//Test par rapport à la longueur de liste
	@Test
	@Ignore
	@Transactional
	public void testDeleteCat() {
		//Instanciation d'une catégorie à ajouter
		Categorie cat = new Categorie();
		cat.setId_cat(2);
		
		catDao.deleteCat(cat);
		
		assertEquals(2, catDao.searchAllCat().size());
	}
	
	//-----Test de méthode updateCat
	//Par rapport à l'ocean
	@Test
	@Ignore
	@Transactional
	public void testUpdateCat() {
		//Instanciation d'une catégorie à ajouter
		Categorie cat = new Categorie(2, "Arctique");
		
		catDao.updateCat(cat);
		
		assertEquals(cat.getOcean(), catDao.searchByIdCat(cat).getOcean());
	}
}
