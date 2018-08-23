package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Categorie;

/**
 * Classe implémentant l'interface ICategorieDao
 * @author Thibault
 *
 */
@Repository
public class CategorieDaoImpl implements ICategorieDao{

	//Recupération du sessionFactory
	@Autowired
	private SessionFactory sf;
	
	// Setter utilisé pour l'injection dépendance
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Categorie addCat(Categorie cat) {
		//Récupération de la session hibernate
		Session s = sf.getCurrentSession();
		
		//Appel de la méthode save
		s.save(cat);
		
		//renvoie de l'objet ajoute
		return cat;
	}

	@Override
	public int deleteCat(Categorie cat) {
		//Récupération de la session hibernate
		Session s = sf.getCurrentSession();
		
		//Création de la requête HQL
		String req = "DELETE Categorie cat WHERE cat.id_cat=:pId";
		
		//Récuépration d'une query hibernate
		Query query = s.createQuery(req);
		
		//Paramétrage de la requête
		query.setParameter("pId", cat.getId_cat());
		
		return query.executeUpdate();
	}

	@Override
	public int updateCat(Categorie cat) {
		//Récupération de la session hibernate
		Session s = sf.getCurrentSession();
		
		//Création de la requête HQL
		String req = "UPDATE Categorie cat SET cat.ocean=:pOcean WHERE cat.id_cat=:pId";
		
		//Récuépration d'une query hibernate
		Query query = s.createQuery(req);
		
		//Paramétrage de la requête
		query.setParameter("pId", cat.getId_cat());
		query.setParameter("pOcean", cat.getOcean());
		
		return query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categorie> searchAllCat() {
		//Récupération de la session hibernate
		Session s = sf.getCurrentSession();
		
		//Création de la requête HQL
		String req = "FROM Categorie";
		
		//Récuépration d'une query hibernate
		Query query = s.createQuery(req);
		
		return query.list();
	}

	@Override
	public Categorie searchByIdCat(Categorie cat) {
		//Récupération de la session hibernate
		Session s = sf.getCurrentSession();
		
		return (Categorie) s.get(Categorie.class, cat.getId_cat());
	}

}
