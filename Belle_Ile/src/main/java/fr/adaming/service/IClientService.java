package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Client;

public interface IClientService {
	
	

	public Client addCl(Client c);
	
	public int deleteCl(Client c);
	
	public int updateCl(Client c);
	
	public List<Client> searchAllCl();
	
	public Client searchByIdCl(Client c);
	
	public void sendMail(Client c, String messageMail);

}
