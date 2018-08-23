package fr.adaming.serviceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.LocationVoiture;
import fr.adaming.service.ILocationVoitureService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
public class LocationVoitureServiceImplTest {

	/*
	 * Uml en java
	 */
	@Autowired
	private ILocationVoitureService lcService;

	/*
	 * setter
	 */

	public void setLocationService(ILocationVoitureService locationService) {
		this.lcService = locationService;
	}

	//@Test
	@Ignore
	@Transactional
	@Rollback(true)
	public void testAdd() {

		int expected = 1;
		LocationVoiture lcTest = new LocationVoiture(5, "bmw", 5, null);

		assertEquals(1, lcService.searchAllLC().size());

	}

	//@Test
	@Ignore
	@Transactional(readOnly = true)
	public void testSerchAll() {
		assertEquals("bmw", lcService.searchAllLC().get(0).getTypeVoiture());

	}

	//@Test
	@Ignore
	@Transactional
	@Rollback(true)
	public void testUpdate() {
		LocationVoiture lc1 = new LocationVoiture(5, "bmw", 5, null);
		LocationVoiture lc2 = new LocationVoiture(6, "r21", 6, null);

		assertNotSame(lc1, lcService.update(lc2));

	}

	//@Test
	@Ignore
	@Transactional
	public void testDelete() {

		LocationVoiture lc1 = new LocationVoiture();
		lc1.setId_location(1);
		lcService.delete(lc1);
		assertEquals(0, lcService.searchAllLC().size());

	}

	//@Test
	@Ignore
	@Transactional
	public void testGetById() {

		LocationVoiture lc = new LocationVoiture();
		lc.setId_location(1);

		assertEquals(1, lcService.searchById(lc).getId_location());

	}

}
