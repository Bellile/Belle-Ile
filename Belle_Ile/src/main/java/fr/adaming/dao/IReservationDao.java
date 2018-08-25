package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Reservation;

public interface IReservationDao {
	
	public List<Reservation> searchAllResa ();
	
	public Reservation searchResaById (Reservation resa);
	
	public Reservation addResa (Reservation resa);
	
	public int deleteResa(Reservation resa);
	
	public int updateResa(Reservation resa);
	
	

}
