package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Client;

@Service("clService")
@Transactional
public class ClientServiceImpl implements IClientService {

	/*
	 * Association uml en java
	 */
	@Autowired
	private IClientDao cDao;

	/*
	 * setter
	 */
	public void setcDao(IClientDao cDao) {
		this.cDao = cDao;
	}
	
	
	

	@Override
	public Client addCl(Client c) {
		
		return cDao.addCl(c);
	}

	@Override
	public int deleteCl(Client c) {
		
		return cDao.deleteCl(c);
	}

	@Override
	public int updateCl(Client c) {
		
		return cDao.updateCl(c);
	}

	@Override
	public List<Client> searchAllCl() {
		
		return cDao.searchAllCl();
	}

	@Override
	public Client searchByIdCl(Client c) {
		
		return cDao.searchByIdCl(c);
	}

}
