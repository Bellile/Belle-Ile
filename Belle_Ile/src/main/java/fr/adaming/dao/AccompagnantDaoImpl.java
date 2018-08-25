package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Accompagnant;
import fr.adaming.model.Reservation;

@Repository
public class AccompagnantDaoImpl implements IAccompagnantDao {

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
	public List<Accompagnant> searchAllAccomp() {
		Session s = sf.getCurrentSession();

		String req = "FROM Accompagnant";

		Query query = s.createQuery(req);

		return query.list();
	}

	@Override
	public Accompagnant searchAccompById(Accompagnant accomp) {
		Session s = sf.getCurrentSession();

		Accompagnant accompOut = (Accompagnant) s.get(Accompagnant.class, accomp.getId());
		
		return accompOut;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Accompagnant> searchAccompByIdResa(Reservation resa) {
		Session s=sf.getCurrentSession();
		
		String req="FROM Accompagnant accomp WHERE accomp.reservation.id_resa=:pIdResa";
		
		Query query=s.createQuery(req);
		
		query.setParameter("pIdResa", resa.getId_resa());
		
		return query.list();
	}

	@Override
	public Accompagnant addAccomp(Accompagnant accomp) {
		Session s=sf.getCurrentSession();
		
		s.save(accomp);
		
		return accomp;
	}

	@Override
	public int deleteAccomp(Accompagnant accomp) {
		Session s=sf.getCurrentSession();
		
		String req="DELETE FROM Accompagnant a WHERE a.id=:pId";
		
		Query query=s.createQuery(req);
		
		query.setParameter("pId", accomp.getId());
		
		return query.executeUpdate();
	}

	@Override
	public int updateAccomp(Accompagnant accomp) {
		Session s=sf.getCurrentSession();
		
		String req="UPDATE Accompagnant a SET a.nom=:pNom, a.prenom=:pPrenom, a.dn=:pDn, a.tel=:pTel, a.adresse.rue=:pRue, a.adresse.cp=:pCp, a.adresse.ville=:pVille, a.adresse.pays=:pPays WHERE a.id=:pId";
		
		Query query=s.createQuery(req);
		
		query.setParameter("pNom", accomp.getNom());
		query.setParameter("pPrenom", accomp.getPrenom());
		query.setParameter("pDn", accomp.getDn());
		query.setParameter("pTel", accomp.getTel());
		query.setParameter("pRue", accomp.getAdresse().getRue());
		query.setParameter("pCp", accomp.getAdresse().getCp());
		query.setParameter("pVille", accomp.getAdresse().getVille());
		query.setParameter("pPays", accomp.getAdresse().getPays());
		query.setParameter("pId", accomp.getId());	
				
		return query.executeUpdate();
	}

	
	
	
	
	
	
}
