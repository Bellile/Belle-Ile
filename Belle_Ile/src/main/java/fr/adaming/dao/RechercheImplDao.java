package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Accompagnant;
import fr.adaming.model.Client;
import fr.adaming.model.Hotel;
import fr.adaming.model.LocationVoiture;
import fr.adaming.model.Offre;
import fr.adaming.model.Reservation;
import fr.adaming.model.Vol;

/**
 * Classe implémentant l'interface IRechercheDao
 * 
 * @author Thibault
 *
 */
@Repository
public class RechercheImplDao implements IRechercheDao{

	// Recupération du sessionFactory
	@Autowired
	private SessionFactory sf;
	
	// Setter utilisé pour l'injection dépendance
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Hotel> searchByNameHotel(String nom) {
		//Récupération de la session hibernate
		Session s = sf.getCurrentSession();
		
		//Création de la requête HQL
		String req ="FROM Hotel h WHERE h.nom LIKE :pNom";
		
		//Récupération de la query
		Query query = s.createQuery(req);
		
		//Paramétrages de la query
		String rech = "%" + nom + "%";
		query.setParameter("pNom", rech);		
		
		//Appel de la méthode
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Hotel> searchByAdresseHotel(String adresse) {
		//Récupération de la session hibernate
		Session s = sf.getCurrentSession();
		
		//Création de la requête HQL
		String req ="FROM Hotel h WHERE h.adresse.ville LIKE :pVille OR h.adresse.pays LIKE :pPays OR h.adresse.rue LIKE :pRue OR h.adresse.cp LIKE :pCp";
		
		//Récupération de la query
		Query query = s.createQuery(req);
		
		//Paramétrages de la query
		String rech = "%" + adresse + "%";
		query.setParameter("pVille", rech);
		query.setParameter("pPays", rech);	
		query.setParameter("pRue", rech);	
		query.setParameter("pCp", rech);	
		
		//Appel de la méthode
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Hotel> searchByCatHotel(String ocean) {
		//Récupération de la session hibernate
		Session s = sf.getCurrentSession();
		
		//Création de la requête HQL
		String req ="FROM Hotel h WHERE h.categorie.ocean LIKE :pOcean";
		
		//Récupération de la query
		Query query = s.createQuery(req);
		
		//Paramétrages de la query
		String rech = "%" + ocean + "%";
		query.setParameter("pOcean", rech);	
		
		//Appel de la méthode
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Offre> searchByHotelOffre(Hotel hotel) {
		//Récupération de la session hibernate
		Session s = sf.getCurrentSession();
		
		//Création de la requête HQL
		String req ="FROM Offre o WHERE o.hotel.nom LIKE :pNom";
		
		//Récupération de la query
		Query query = s.createQuery(req);
		
		//Paramétrages de la query
		String rech = "%" + hotel.getNom() + "%";
		query.setParameter("pNom", rech);	
		
		//Appel de la méthode
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Offre> searchByDepartOffre(Vol vol) {
		//Récupération de la session hibernate
		Session s = sf.getCurrentSession();
		
		//Création de la requête HQL
		String req ="FROM Offre o WHERE o.vol.dDepart=:pDepart";
		
		//Récupération de la query
		Query query = s.createQuery(req);
		
		//Paramétrages de la query
		query.setParameter("pDepart", vol.getdDepart());	
		
		//Appel de la méthode
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Offre> searchByRetourOffre(Vol vol) {
		//Récupération de la session hibernate
		Session s = sf.getCurrentSession();
		
		//Création de la requête HQL
		String req ="FROM Offre o WHERE o.vol.dArrivee=:pRetour";
		
		//Récupération de la query
		Query query = s.createQuery(req);
		
		//Paramétrages de la query
		query.setParameter("pRetour", vol.getdArrivee());	
		
		//Appel de la méthode
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Offre> searchByPromoOffre(Offre offre) {
		//Récupération de la session hibernate
		Session s = sf.getCurrentSession();
		
		//Création de la requête HQL
		String req ="FROM Offre o WHERE o.promo BETWEEN :pPromo AND 1.00";
		
		//Récupération de la query
		Query query = s.createQuery(req);
		
		//Paramétrages de la query
		query.setParameter("pPromo", offre.getPromo());
		
		//Appel de la méthode
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Offre> searchByPrixOffre(Offre offre) {
		//Récupération de la session hibernate
		Session s = sf.getCurrentSession();
		
		//Création de la requête HQL
		String req ="FROM Offre o WHERE o.prix BETWEEN :pMin AND :pMax";
		
		//Récupération de la query
		Query query = s.createQuery(req);
		
		//Paramétrages de la query
		Double min = offre.getPrix() - offre.getPrix()*0.05;
		Double max = offre.getPrix() + offre.getPrix()*0.05;
		query.setParameter("pMin", min);
		query.setParameter("pMax", max);
		
		//Appel de la méthode
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Accompagnant> searchByResaAcc(Reservation resa) {
		//Récupération de la session hibernate
		Session s = sf.getCurrentSession();
		
		//Création de la requête HQL
		String req ="FROM Accompagnant a WHERE a.reservation.id_resa=:pResa";
		
		//Récupération de la query
		Query query = s.createQuery(req);
		
		//Paramétrages de la query
		query.setParameter("pResa", resa.getId_resa());
		
		//Appel de la méthode
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LocationVoiture> searchByTypeLoc(String type) {
		//Récupération de la session hibernate
		Session s = sf.getCurrentSession();
		
		//Création de la requête HQL
		String req ="FROM LocationVoiture lv WHERE lv.typeVoiture LIKE :pType";
		
		//Récupération de la query
		Query query = s.createQuery(req);
		
		//Paramétrages de la query
		String rech = "%" + type + "%";
		query.setParameter("pType", rech);
		
		//Appel de la méthode
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LocationVoiture> searchByPrixLoc(LocationVoiture locV) {
		//Récupération de la session hibernate
		Session s = sf.getCurrentSession();
		
		//Création de la requête HQL
		String req ="FROM LocationVoiture lv WHERE lv.prixJournee BETWEEN :pMin AND :pMax";
		
		//Récupération de la query
		Query query = s.createQuery(req);
		
		//Paramétrages de la query
		Double min = locV.getPrixJournee()-locV.getPrixJournee()*0.05;
		Double max = locV.getPrixJournee()+locV.getPrixJournee()*0.05;
		query.setParameter("pMin", min);
		query.setParameter("pMax", max);
		
		//Appel de la méthode
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reservation> searchByClientResa(Client client) {
		//Récupération de la session hibernate
		Session s = sf.getCurrentSession();
		
		//Création de la requête HQL
		String req ="FROM Reservation r WHERE r.client.id=:pClient";
		
		//Récupération de la query
		Query query = s.createQuery(req);
		
		//Paramétrages de la query
		query.setParameter("pClient", client.getId());
		
		//Appel de la méthode
		return query.list();
	}

	@Override
	public Client searchByMailClient(Client client) {
		//Récupération de la session hibernate
		Session s = sf.getCurrentSession();
		
		//Création de la requête HQL
		String req ="FROM Client cl WHERE cl.mail=:pMail";
		
		//Récupération de la query
		Query query = s.createQuery(req);
		
		//Paramétrages de la query
		query.setParameter("pMail", client.getMail());
		
		//Appel de la méthode
		return (Client) query.uniqueResult();
	}

}
