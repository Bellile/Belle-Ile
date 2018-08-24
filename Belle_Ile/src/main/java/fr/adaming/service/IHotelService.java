package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Categorie;
import fr.adaming.model.Hotel;

/**
 * Interface pour le CRUD des classes
 * @author Thibault
 *
 */
public interface IHotelService {

	/**<b>add</b>
	 * M�thode pour ajouter une hotel hotel dans la base de donn�es
	 * @param hotel : l'objet hotel persistant � ajouter
	 * @return hotel l'objet ajout� dans la base de donn�es
	 */
	public Hotel addHotel(Hotel hotel, Categorie cat);
	
	/**<b>delete</b>
	 * M�thode pour supprimer une hotel hotel dans la base de donn�es
	 * @param hotel : la hotel � supprimer
	 * @return 1 si l'objet a �t� supprim�, 0 sinon
	 */
	public int deleteHotel(Hotel hotel);
	
	/**<b>update</b>
	 * M�thode pour modifier une hotel hotel dans la base de donn�es
	 * @param hotel : la hotel avec modifihotelion
	 * @return 1 si l'objet a �t� modifi�, 0 sinon
	 */
	public int updateHotel(Hotel hotel);
	
	/**<b>searchAll</b>
	 * M�thode pour r�cup�rer tous les objets une hotel hotel dans la base de donn�es
	 * @return List(hotel) liste des objets de type T de la base de donn�es
	 */
	public List<Hotel> searchAllHotel();
	
	/**<b>searchById</b>
	 * M�thode pour r�cup�rer un objet T selon son id dans la base de donn�es
	 * @param hotel : l'objet hotel avec l'id que l'on recherche
	 * @return hotel l'objet de la base de donn�es
	 */
	public Hotel searchByIdHotel(int id);
}
