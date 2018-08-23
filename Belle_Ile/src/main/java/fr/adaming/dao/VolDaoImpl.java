package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Vol;

@Repository
public class VolDaoImpl implements IVolDao {

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

	@Override
	public Vol addVol(Vol vol) {
		Session s = sf.getCurrentSession();

		s.save(vol);

		return vol;
	}

	@Override
	public int deleteVol(Vol vol) {
		Session s = sf.getCurrentSession();

		String req = "DELETE FROM Vol vol WHERE vol.id_vol=:pId";

		Query query = s.createQuery(req);

		query.setParameter("pId", vol.getId_vol());

		return query.executeUpdate();
	}

	@Override
	public int updateVol(Vol vol) {
		Session s = sf.getCurrentSession();

		String req = "UPDATE Vol vol SET vol.depart=:pDepart, vol.arrivee=:pArrivee, vol.dDepart=:pDateDepart, vol.dArrivee=:pDateArrivee WHERE vol.id_vol=:pId";
		
		Query query=s.createQuery(req);
		
		query.setParameter("pDepart", vol.getDepart());
		query.setParameter("pArrivee", vol.getArrivee());
		query.setParameter("pDateDepart", vol.getdDepart());
		query.setParameter("pDateArrivee", vol.getdArrivee());
		query.setParameter("pId", vol.getId_vol());
		
		return query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vol> searchAllVol() {
		Session s = sf.getCurrentSession();

		String req = "FROM Vol";

		Query query = s.createQuery(req);

		return query.list();
	}

	@Override
	public Vol searchVolById(Vol vol) {
		Session s = sf.getCurrentSession();

		Vol volOut = (Vol) s.get(Vol.class, vol.getId_vol());

		return volOut;
	}

}
