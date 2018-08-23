package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ILocationVoitureDao;
import fr.adaming.model.LocationVoiture;

@Service("lcService")
@Transactional
public class LocationVoitureServiceImpl implements ILocationVoitureService {

	/*
	 * Uml en java
	 */
	@Autowired
	private ILocationVoitureDao locationDao;

	/*
	 * setter
	 */

	public void setLocationDao(ILocationVoitureDao locationDao) {
		this.locationDao = locationDao;
	}
	
	

	@Override
	public LocationVoiture add(LocationVoiture location) {
		
		return locationDao.add(location);
	}

	@Override
	public int delete(LocationVoiture location) {
		
		return locationDao.delete(location);
	}

	@Override
	public int update(LocationVoiture location) {
		
		return locationDao.update(location);
	}

	@Override
	public List<LocationVoiture> searchAll() {

		return locationDao.searchAll();
	}

	@Override
	public LocationVoiture searchById(LocationVoiture location) {
		
		return locationDao.searchById(location);
	}

}
