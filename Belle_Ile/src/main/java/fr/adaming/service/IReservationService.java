package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Client;
import fr.adaming.model.Reservation;

public interface IReservationService {

	public List<Reservation> searchAllResa ();
	
	public Reservation searchResaById (Reservation resa);
	
	public Reservation addResa (Reservation resa, Client cl);
	
	public int deleteResa(Reservation resa, Client cl);
	
	public int updateResa(Reservation resa, Client cl);
}
