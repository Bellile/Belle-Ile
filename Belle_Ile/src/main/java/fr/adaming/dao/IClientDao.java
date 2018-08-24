package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Client;

public interface IClientDao {
	
	
	public Client addCl(Client c);
	
	public int deleteCl(Client c);
	
	public int updateCl(Client c);
	
	public List<Client> searchAllCl();
	
	public Client searchByIdCl(Client c);

}
