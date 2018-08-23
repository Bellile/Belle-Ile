package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVolDao;
import fr.adaming.model.Vol;

@Service
@Transactional
public class VolServiceImpl implements IVolService {

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

	
	@Override
	public Vol addVol(Vol vol) {
		// TODO Auto-generated method stub
		return volDao.addVol(vol);
	}

	@Override
	public int deleteVol(Vol vol) {
		
		return volDao.deleteVol(vol);
	}

	@Override
	public int updateVol(Vol vol) {
		
		return volDao.updateVol(vol);
	}

	@Override
	public List<Vol> searchAllVol() {
		
		return volDao.searchAllVol();
	}

	@Override
	public Vol searchVolById(Vol vol) {
		
		return volDao.searchVolById(vol);
	}

}
