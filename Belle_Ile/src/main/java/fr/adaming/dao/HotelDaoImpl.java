package fr.adaming.dao;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Hotel;

/**
 * Classe impl�mentant l'interface ICategorieDao
 * 
 * @author Thibault
 *
 */
@Repository
public class HotelDaoImpl implements IHotelDao {

	// Recup�ration du sessionFactory
	@Autowired
	private SessionFactory sf;

	// Setter utilis� pour l'injection d�pendance
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Hotel addHotel(Hotel hotel) {
		// R�cup�ration de la session hibernate
		Session s = sf.getCurrentSession();

		// Appel de la m�thode
		s.save(hotel);

		return hotel;
	}

	@Override
	public int deleteHotel(Hotel hotel) {
		// R�cup�ration de la session hibernate
		Session s = sf.getCurrentSession();

		// Cr�ation de la requ�te HQL
		String req = "DELETE Hotel h WHERE h.id_hotel=:pId";

		// R�cu�pration d'une query hibernate
		Query query = s.createQuery(req);

		// Param�trage de la requ�te
		query.setParameter("pId", hotel.getId_hotel());

		return query.executeUpdate();
	}

	@Override
	public int updateHotel(Hotel hotel) {
		// R�cup�ration de la session hibernate
		Session s = sf.getCurrentSession();

		// Cr�ation de la requ�te HQL
		String req = "UPDATE Hotel h SET h.prestation=:pPrest, h.piscine=:pPisc, h.plage=:pPlage, h.photo=:pPhoto, h.rue=:pRue, h.ville=:pVille, h.cp=:pCp, h.pays=:pPays WHERE h.id_hotel=:pId";

		// R�cu�pration d'une query hibernate
		Query query = s.createQuery(req);

		// Param�trage de la requ�te
		query.setParameter("pId", hotel.getId_hotel());
		query.setParameter("pPrest", hotel.getPrestation());
		query.setParameter("pPisc", hotel.isPiscine());
		query.setParameter("pPlage", hotel.isPlage());
		query.setParameter("pPhoto", hotel.getPhoto());
		query.setParameter("pRue", hotel.getAdresse().getRue());
		query.setParameter("pVille", hotel.getAdresse().getVille());
		query.setParameter("pCp", hotel.getAdresse().getCp());
		query.setParameter("pPays", hotel.getAdresse().getPays());

		return query.executeUpdate();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Hotel> searchAllHotel() {
		//R�cup�ration de la session hibernate
		Session s = sf.getCurrentSession();
		
		//Cr�ation de la requ�te HQL
		String req = "FROM Hotel";
		
		//R�cu�pration d'une query hibernate
		Query query = s.createQuery(req);
		
		List<Hotel> allHotel = query.list();
		
		for (Hotel h : allHotel) {
			h.setImage("data:image/png);base64," + Base64.encodeBase64String(h.getPhoto()));
		}
		
		return null;
	}

	@Override
	public Hotel searchByIdhotel(Hotel hotel) {
		//R�cup�ration de la session hibernate
		Session s = sf.getCurrentSession();
		
		Hotel hOut = (Hotel) s.get(Hotel.class, hotel);
		
		hOut.setImage("data:image/png);base64," + Base64.encodeBase64String(h.getPhoto()));
		
		return hOut;
	}

}
