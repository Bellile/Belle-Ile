package fr.adaming.dao;

import java.util.List;


import fr.adaming.model.Vol;

/**
 * Interface pour le CRUD de vol
 * @author Camille
 *
 */
public interface IVolDao {
	
	/**<b>add</b>
	 * Méthode pour ajouter un objet Vol dans la base de données
	 * @param Vol : l'objet persistant à ajouter
	 * @return Vol l'objet ajouté dans la base de données
	 */
	public Vol addVol(Vol vol);
	
	/**<b>delete</b>
	 * Méthode pour supprimer un objet vol dans la base de données
	 * @param Vol : l'objet à supprimer
	 * @return 1 si l'objet a été supprimé, 0 sinon
	 */
	public int deleteVol(Vol vol);
	
	/**<b>update</b>
	 * Méthode pour modifier un objet Vol dans la base de données
	 * @param Vol : le nouvel objet avec modification
	 * @return 1 si l'objet a été modifié, 0 sinon
	 */
	public int updateVol(Vol vol);
	
	/**<b>searchAll</b>
	 * Méthode pour récupérer tous les objets vol dans la base de données
	 * @return List Vol liste des objets de type Vol de la base de données
	 */
	public List<Vol> searchAllVol();
	
	/**<b>searchById</b>
	 * Méthode pour récupérer un objet Vol selon son id dans la base de données
	 * @param Vol : l'objet persistant avec l'id que l'on recherche
	 * @return Vol l'objet de la base de données
	 */
	public Vol searchVolById(Vol vol);
}
