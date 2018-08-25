package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Accompagnant;
import fr.adaming.model.Reservation;

public interface IAccompagnantService {

	public List<Accompagnant> searchAllAccomp ();
	
	public Accompagnant searchAccompById(Accompagnant accomp);
	
	public Accompagnant searchAccompByIdResa (Reservation resa);
	
	public Accompagnant addAccomp(Accompagnant accomp, Reservation resa);
	
	public int deleteAccomp(Accompagnant accomp, Reservation resa);
	
	public int updateAccomp(Accompagnant accomp, Reservation resa);
}
