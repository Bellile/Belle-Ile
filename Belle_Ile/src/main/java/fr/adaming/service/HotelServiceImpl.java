package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IHotelDao;
import fr.adaming.model.Categorie;
import fr.adaming.model.Hotel;

/**
 * Classe implémentant l'interface IHotelService
 * @author Thibault
 *
 */
@Service
@Transactional
public class HotelServiceImpl implements IHotelService{

	//Transformation de l'association UML en JAVA
	@Autowired
	private IHotelDao hDao;
	
	@Override
	public Hotel addHotel(Hotel hotel, Categorie cat) {
		hotel.setCategorie(cat);
		
		return hDao.addHotel(hotel);
	}

	@Override
	public int deleteHotel(Hotel hotel) {
		
		return hDao.deleteHotel(hotel);
	}

	@Override
	public int updateHotel(Hotel hotel) {
		
		return hDao.updateHotel(hotel);
	}

	@Override
	public List<Hotel> searchAllHotel() {
		
		return hDao.searchAllHotel();
	}

	@Override
	public Hotel searchByIdHotel(Hotel hotel) {
		
		return hDao.searchByIdHotel(hotel);
	}

}
