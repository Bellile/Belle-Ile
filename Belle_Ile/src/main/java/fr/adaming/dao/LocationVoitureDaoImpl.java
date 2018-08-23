package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.LocationVoiture;

@Repository
public class LocationVoitureDaoImpl implements ILocationVoitureDao{
	
	
	/*
	 * Création de la session factory de hibernate
	 */	
	@Autowired
	private SessionFactory sf;
	
	/*
	 * Setter 
	 */

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	
	

	@Override
	public LocationVoiture add(LocationVoiture location) {
		
		Session s=sf.getCurrentSession();
		
		s.save(location);
						
		return location;
	}
	
	

	@Override
	public int delete(LocationVoiture location) {
		
		Session s = sf.getCurrentSession();
		
		String req="DELETE FROM LocationVoiture location WHERE location.id_location=:pId_location";
		
		Query query = s.createQuery(req);
		
		query.setParameter("pId_location", location.getId_location());
		
		
		return query.executeUpdate();
	}

	@Override
	public int update(LocationVoiture location) {
		
		Session s=sf.getCurrentSession();
		
		String req="UPDATE FROM LocationVoiture lc SET lc.duree=:pDuree, lc.photo=:pPhoto, lc.prixJournee=:pPrixJournee, lc.typeVoiture=:pTypeVoiture WHERE lc.id_location=:pId_location ";
		
		Query query = s.createQuery(req);
		
		query.setParameter("pDuree", location.getDuree());
		query.setParameter("pPhoto", location.getPhoto());
		query.setParameter("pPrixJournee", location.getPrixJournee());
		query.setParameter("pTypeVoiture", location.getTypeVoiture());
		query.setParameter("pId_location", location.getId_location());
		
		return query.executeUpdate();
	}

	@Override
	public List<LocationVoiture> searchAllLC() {
		
		Session s=sf.getCurrentSession();
		
		String req="FROM LocationVoiture location";
		
		Query query=s.createQuery(req);
		
		List<LocationVoiture> listeLocationVoiture=query.list();
		
		
		return listeLocationVoiture;
	}

	@Override
	public LocationVoiture searchById(LocationVoiture location) {
	
		Session s =sf.getCurrentSession();
		
		String req ="FROM LocationVoiture lc WHERE lc.id_location=:pId_location";
		
		Query query=s.createQuery(req);
		
		query.setParameter("pId_location", location.getId_location());
		
		
		return (LocationVoiture) query.uniqueResult();
	}
	

	
	
	
	
	
	
	

}
