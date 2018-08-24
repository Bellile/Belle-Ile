package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IOffreDao;
import fr.adaming.model.Hotel;
import fr.adaming.model.LocationVoiture;
import fr.adaming.model.Offre;
import fr.adaming.model.Vol;

@Service
@Transactional
public class OffreServiceImpl implements IOffreService {

	/**
	 * Attribut pour l'injection de dépendance
	 */
	@Autowired
	private IOffreDao offreDao;

	/**
	 * Setter pour l'injection dépendance
	 * 
	 * @param volDao
	 */
	public void setOffreDao(IOffreDao offreDao) {
		this.offreDao = offreDao;
	}

	@Override
	public Offre addOffre(Offre offre) {

	
		return offreDao.addOffre(offre);
	}

	@Override
	public int deleteOffre(Offre offre) {

		return offreDao.deleteOffre(offre);
	}

	@Override
	public int updateOffre(Offre offre, Hotel hotel, LocationVoiture location, Vol vol) {
		Offre offreOut = this.searchOffreById(offre);

		offreOut.setNbNuit(offre.getNbNuit());
		offreOut.setPrix(offre.getPrix());
		offreOut.setNbDispo(offre.getNbDispo());
		offreOut.setPromo(offre.getPromo());

		// si offre contient une photo (chargement d'une nouvelle photo) alors
		// on la charge pour la modifier, sinon, on ne la touche pas
		if (offre.getPhoto() != null) {
			offreOut.setPhoto(offre.getPhoto());
		}

		if (offre.getVol() != null) {
			offreOut.setVol(offre.getVol());
		}

		if (offre.getHotel() != null) {
			offreOut.setHotel(offre.getHotel());
		}

		if (offre.getLocation() != null) {
			offreOut.setLocation(offre.getLocation());
		}

		return offreDao.updateOffre(offreOut);
	}

	@Override
	public List<Offre> searchAllOffre() {

		return offreDao.searchAllOffre();
	}

	@Override
	public Offre searchOffreById(Offre offre) {

		return offreDao.searchOffreById(offre);
	}

}
