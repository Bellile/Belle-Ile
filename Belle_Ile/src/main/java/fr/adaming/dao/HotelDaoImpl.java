package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Hotel;

/**
 * Classe implémentant l'interface ICategorieDao
 * 
 * @author Thibault
 *
 */
@Repository
public class HotelDaoImpl implements IHotelDao {

	// Recupération du sessionFactory
	@Autowired
	private SessionFactory sf;

	// Setter utilisé pour l'injection dépendance
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Hotel addHotel(Hotel hotel) {
		// Récupération de la session hibernate
		Session s = sf.getCurrentSession();

		// Appel de la méthode
		s.save(hotel);

		return hotel;
	}

	@Override
	public int deleteHotel(Hotel hotel) {
		// Récupération de la session hibernate
		Session s = sf.getCurrentSession();

		// Création de la requête HQL
		String req = "DELETE Hotel h WHERE h.id_hotel=:pId";

		// Récuépration d'une query hibernate
		Query query = s.createQuery(req);

		// Paramétrage de la requête
		query.setParameter("pId", hotel.getId_hotel());

		return query.executeUpdate();
	}

	@Override
	public int updateHotel(Hotel hotel) {
		// Récupération de la session hibernate
		Session s = sf.getCurrentSession();

		// Création de la requête HQL
		String req = "UPDATE Hotel h SET h.prestation=:pPrest, h.piscine=:pPisc, h.plage=:pPlage, h.photo=:pPhoto, h.rue=:pRue, h.ville=:pVille, h.cp=:pCp, h.pays=:pPays WHERE h.id_hotel=:pId";

		// Récuépration d'une query hibernate
		Query query = s.createQuery(req);

		// Paramétrage de la requête
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
		//Récupération de la session hibernate
		Session s = sf.getCurrentSession();
		
		//Création de la requête HQL
		String req = "FROM Hotel";
		
		//Récuépration d'une query hibernate
		Query query = s.createQuery(req);
				
		return query.list();
	}

	@Override
	public Hotel searchByIdhotel(Hotel hotel) {
		//Récupération de la session hibernate
		Session s = sf.getCurrentSession();

		return (Hotel) s.get(Hotel.class, hotel);
	}

}
