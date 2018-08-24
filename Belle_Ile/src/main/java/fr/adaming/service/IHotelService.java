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
	 * Méthode pour ajouter une hotel hotel dans la base de données
	 * @param hotel : l'objet hotel persistant à ajouter
	 * @return hotel l'objet ajouté dans la base de données
	 */
	public Hotel addHotel(Hotel hotel, Categorie cat);
	
	/**<b>delete</b>
	 * Méthode pour supprimer une hotel hotel dans la base de données
	 * @param hotel : la hotel à supprimer
	 * @return 1 si l'objet a été supprimé, 0 sinon
	 */
	public int deleteHotel(Hotel hotel);
	
	/**<b>update</b>
	 * Méthode pour modifier une hotel hotel dans la base de données
	 * @param hotel : la hotel avec modifihotelion
	 * @return 1 si l'objet a été modifié, 0 sinon
	 */
	public int updateHotel(Hotel hotel);
	
	/**<b>searchAll</b>
	 * Méthode pour récupérer tous les objets une hotel hotel dans la base de données
	 * @return List(hotel) liste des objets de type T de la base de données
	 */
	public List<Hotel> searchAllHotel();
	
	/**<b>searchById</b>
	 * Méthode pour récupérer un objet T selon son id dans la base de données
	 * @param hotel : l'objet hotel avec l'id que l'on recherche
	 * @return hotel l'objet de la base de données
	 */
	public Hotel searchByIdHotel(int id);
}
