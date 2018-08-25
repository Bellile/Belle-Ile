package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Accompagnant;
import fr.adaming.model.Reservation;

public interface IAccompagnantDao {
	
	public List<Accompagnant> searchAllAccomp ();
	
	public Accompagnant searchAccompById(Accompagnant accomp);
	
	public List<Accompagnant> searchAccompByIdResa (Reservation resa);
	
	public Accompagnant addAccomp(Accompagnant accomp);
	
	public int deleteAccomp(Accompagnant accomp);
	
	public int updateAccomp(Accompagnant accomp);

}
