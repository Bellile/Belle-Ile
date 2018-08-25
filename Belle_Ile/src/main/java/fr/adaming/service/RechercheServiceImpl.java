package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IRechercheDao;
import fr.adaming.model.Accompagnant;
import fr.adaming.model.Client;
import fr.adaming.model.Hotel;
import fr.adaming.model.LocationVoiture;
import fr.adaming.model.Offre;
import fr.adaming.model.Reservation;
import fr.adaming.model.Vol;

@Service
@Transactional
public class RechercheServiceImpl implements IRechercheService{

	@Autowired
	private IRechercheDao rDao;
	
	public void setrDao(IRechercheDao rDao) {
		this.rDao = rDao;
	}

	@Override
	public List<Hotel> searchByNameHotel(String nom) {
		// TODO Auto-generated method stub
		return rDao.searchByNameHotel(nom);
	}

	@Override
	public List<Hotel> searchByAdresseHotel(String adresse) {
		// TODO Auto-generated method stub
		return rDao.searchByAdresseHotel(adresse);
	}

	@Override
	public List<Hotel> searchByCatHotel(String ocean) {
		// TODO Auto-generated method stub
		return rDao.searchByCatHotel(ocean);
	}

	@Override
	public List<Offre> searchByHotelOffre(Hotel hotel) {
		// TODO Auto-generated method stub
		return rDao.searchByHotelOffre(hotel);
	}

	@Override
	public List<Offre> searchByDepartOffre(Vol vol) {
		// TODO Auto-generated method stub
		return rDao.searchByDepartOffre(vol);
	}

	@Override
	public List<Offre> searchByRetourOffre(Vol vol) {
		// TODO Auto-generated method stub
		return rDao.searchByRetourOffre(vol);
	}

	@Override
	public List<Offre> searchByPromoOffre(Offre offre) {
		// TODO Auto-generated method stub
		return rDao.searchByPromoOffre(offre);
	}

	@Override
	public List<Offre> searchByPrixOffre(Offre offre) {
		// TODO Auto-generated method stub
		return rDao.searchByPrixOffre(offre);
	}

	@Override
	public List<Accompagnant> searchByResaAcc(Reservation resa) {
		// TODO Auto-generated method stub
		return rDao.searchByResaAcc(resa);
	}

	@Override
	public List<LocationVoiture> searchByTypeLoc(String type) {
		// TODO Auto-generated method stub
		return rDao.searchByTypeLoc(type);
	}

	@Override
	public List<LocationVoiture> searchByPrixLoc(LocationVoiture locV) {
		// TODO Auto-generated method stub
		return rDao.searchByPrixLoc(locV);
	}

	@Override
	public List<Reservation> searchByClientResa(Client client) {
		// TODO Auto-generated method stub
		return rDao.searchByClientResa(client);
	}

	@Override
	public Client searchByMailClient(Client client) {
		// TODO Auto-generated method stub
		return rDao.searchByMailClient(client);
	}

	
}
