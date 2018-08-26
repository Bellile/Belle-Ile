package fr.adaming.service;

import java.util.ArrayList;
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

	@Override
	public List<Offre> searchByStringOffre(String rech) {
		List<Offre> listOut = new ArrayList<Offre>();
		List<Offre> listIn = new ArrayList<Offre>();
		List<Hotel> listHot2 = rDao.searchByAdresseHotel(rech); 
		List<Hotel> listHot1 = rDao.searchByNameHotel(rech);
		
		//Récupération de tous les hotels correspondant à la recherche
		for (Hotel h:listHot2) {
			listHot1.add(h);
		}
		
		//Nettoyage des doublons
		for (int i=0; i<listHot1.size()-1; i++) {
			for (int j=i+1; j<listHot1.size(); j++) {
				if (listHot1.get(i).getId_hotel()==listHot1.get(j).getId_hotel()) {
					listHot1.remove(j);
				}
			}
		}
		
		//Récupération des offres pour chaque hotel
		for (Hotel h:listHot1) {
			listIn = rDao.searchByHotelOffre(h);
			for(Offre o:listIn) {
				listOut.add(o);
			}
		}
		
		return listOut;
	}

	
}
