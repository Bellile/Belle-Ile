package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Reservation;

@Repository
public class ReservationDaoImpl implements IReservationDao {

	/**
	 * Attribut pour l'injection de dépendance
	 */
	@Autowired
	private SessionFactory sf;

	/**
	 * Setter pour l'injection dépendance
	 * 
	 * @param sf
	 */
	// un setter pour l'injection de dependance
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Reservation> searchAllResa() {
		Session s = sf.getCurrentSession();
		
		String req="FROM Reservation";
		
		Query query=s.createQuery(req);
		
		return query.list();
	}

	@Override
	public Reservation searchResaById(Reservation resa) {
		Session s = sf.getCurrentSession();
		
		Reservation resaOut= (Reservation) s.get(Reservation.class, resa.getId_resa());
		
		return resaOut;
	}

	@Override
	public Reservation addResa(Reservation resa) {
		Session s = sf.getCurrentSession();
		
		s.save(resa);
		
		return resa;
	}

	@Override
	public int deleteResa(Reservation resa) {
		Session s = sf.getCurrentSession();
		
		String req="DELETE FROM Reservation resa WHERE resa.id_resa=:pId AND resa.client.id=:pIdCl";
		
		Query query=s.createQuery(req);
		
		query.setParameter("pId", resa.getId_resa());
		query.setParameter("pIdCl", resa.getClient().getId());
		
		return query.executeUpdate();
	}

	@Override
	public int updateResa(Reservation resa) {
		Session s = sf.getCurrentSession();
		
		String req="UPDATE Reservation resa SET resa.nbrePlace=:pNb WHERE resa.id_resa=:pId AND resa.client.id=:pIdCl";
		
		Query query=s.createQuery(req);
		
		query.setParameter("pNb", resa.getNbrePlace());
		query.setParameter("pId", resa.getId_resa());
		query.setParameter("pIdCl", resa.getClient().getId());
		
		return query.executeUpdate();
	}

}
