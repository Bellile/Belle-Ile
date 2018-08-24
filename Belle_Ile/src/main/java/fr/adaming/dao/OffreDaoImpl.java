package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Offre;

@Repository
public class OffreDaoImpl implements IOffreDao {

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
	public Offre addOffre(Offre offre) {
		Session s = sf.getCurrentSession();

		s.save(offre);

		return offre;
	}

	@Override
	public int deleteOffre(Offre offre) {
		Session s = sf.getCurrentSession();

		String req = "DELETE Offre offre WHERE offre.id_offre=:pId";

		Query query = s.createQuery(req);

		query.setParameter("pId", offre.getId_offre());

		return query.executeUpdate();
	}

	@Override
	public int updateOffre(Offre offre) {

		try {
			Session s = sf.getCurrentSession();

			s.saveOrUpdate(offre);

			return 1;
		} catch (Exception e) {
			return 0;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Offre> searchAllOffre() {
		Session s = sf.getCurrentSession();

		String req = "FROM Offre";

		Query query = s.createQuery(req);

		return query.list();
	}

	@Override
	public Offre searchOffreById(Offre offre) {
		Session s = sf.getCurrentSession();

		String req = "FROM Offre offre WHERE offre.id_offre=:pId";

		Query query = s.createQuery(req);

		query.setParameter("pId", offre.getId_offre());

		return (Offre) query.uniqueResult();
	}

}
