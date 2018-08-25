package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;

@Repository
public class ClientDaoImpl implements IClientDao {

	
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
	public Client addCl(Client c) {

		Session s = sf.getCurrentSession();

		s.save(c);

		return null;
	}

	@Override
	public int deleteCl(Client c) {

		Session s = sf.getCurrentSession();

		String req = "DELETE FROM Client cl Where cl.id=:pId";

		Query query = s.createQuery(req);

		query.setParameter("pId", c.getId());

		return query.executeUpdate();
	}

	@Override
	public int updateCl(Client c) {

		Session s = sf.getCurrentSession();

		String req = "UPDATE Client cl SET cl.mail=:pMail, cl.mdp=:pMdp, cl.nom=:pNom, cl.prenom=:pPrenom, cl.dn=:pDn, cl.tel=:pTel, cl.adresse.rue=:pRue, cl.adresse.cp=:pCp, cl.adresse.ville=:pVille, cl.adresse.pays=:pPays WHERE cl.id=:pId";

		Query query = s.createQuery(req);

		query.setParameter("pMail", c.getMail());
		query.setParameter("pMdp", c.getMdp());
		query.setParameter("pNom", c.getNom());
		query.setParameter("pPrenom", c.getPrenom());
		query.setParameter("pDn", c.getDn());
		query.setParameter("pTel", c.getTel());
		query.setParameter("pRue", c.getAdresse().getRue());
		query.setParameter("pCp", c.getAdresse().getCp());
		query.setParameter("pVille", c.getAdresse().getVille());
		query.setParameter("pPays", c.getAdresse().getPays());
		query.setParameter("pId", c.getId());

		return query.executeUpdate();
	}

	@Override
	public List<Client> searchAllCl() {
		
		Session s=sf.getCurrentSession();
		
		String req ="From Client cl";
		
		Query query = s.createQuery(req);
		
		List<Client> listeClient=query.list();		
		
		return listeClient;
	}

	@Override
	public Client searchByIdCl(Client c) {
		
		Session s = sf.getCurrentSession();
		
		String req ="From Client cl Where cl.id=:pId";
		
		Query query=s.createQuery(req);
		
		query.setParameter("pId", c.getId());
		
		
	
		return (Client) query.uniqueResult();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
