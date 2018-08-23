package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Categorie;

/**
 * Classe impl�mentant l'interface ICategorieDao
 * @author Thibault
 *
 */
@Repository
public class CategorieDaoImpl implements ICategorieDao{

	//Recup�ration du sessionFactory
	@Autowired
	private SessionFactory sf;
	
	// Setter utilis� pour l'injection d�pendance
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Categorie addCat(Categorie cat) {
		//R�cup�ration de la session hibernate
		Session s = sf.getCurrentSession();
		
		//Appel de la m�thode save
		s.save(cat);
		
		//renvoie de l'objet ajoute
		return cat;
	}

	@Override
	public int deleteCat(Categorie cat) {
		//R�cup�ration de la session hibernate
		Session s = sf.getCurrentSession();
		
		//Cr�ation de la requ�te HQL
		String req = "DELETE Categorie cat WHERE cat.id_cat=:pId";
		
		//R�cu�pration d'une query hibernate
		Query query = s.createQuery(req);
		
		//Param�trage de la requ�te
		query.setParameter("pId", cat.getId_cat());
		
		return query.executeUpdate();
	}

	@Override
	public int updateCat(Categorie cat) {
		//R�cup�ration de la session hibernate
		Session s = sf.getCurrentSession();
		
		//Cr�ation de la requ�te HQL
		String req = "UPDATE Categorie cat SET cat.ocean=:pOcean WHERE cat.id_cat=:pId";
		
		//R�cu�pration d'une query hibernate
		Query query = s.createQuery(req);
		
		//Param�trage de la requ�te
		query.setParameter("pId", cat.getId_cat());
		query.setParameter("pOcean", cat.getOcean());
		
		return query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categorie> searchAllCat() {
		//R�cup�ration de la session hibernate
		Session s = sf.getCurrentSession();
		
		//Cr�ation de la requ�te HQL
		String req = "FROM Categorie";
		
		//R�cu�pration d'une query hibernate
		Query query = s.createQuery(req);
		
		return query.list();
	}

	@Override
	public Categorie searchByIdCat(Categorie cat) {
		//R�cup�ration de la session hibernate
		Session s = sf.getCurrentSession();
		
		return (Categorie) s.get(Categorie.class, cat.getId_cat());
	}

}
