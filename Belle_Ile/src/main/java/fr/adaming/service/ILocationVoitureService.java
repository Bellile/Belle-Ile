package fr.adaming.service;

import java.util.List;

import fr.adaming.model.LocationVoiture;

public interface ILocationVoitureService {
	
	
	
	/**<b>add</b>
	 * Méthode pour ajouter un objet LocationVoiture  dans la base de données
	 * @param LocationVoiture  : l'objet persistant à ajouter
	 * @return LocationVoiture  l'objet ajouté dans la base de données
	 */
	public LocationVoiture add(LocationVoiture  location);
	
	/**<b>delete</b>
	 * Méthode pour supprimer un objet LocationVoiture  dans la base de données
	 * @param LocationVoiture  : l'objet à supprimer
	 * @return 1 si l'objet a été supprimé, 0 sinon
	 */
	public int delete(LocationVoiture  location);
	
	
	
	
	/**<b>update</b>
	 * Méthode pour modifier un objet LocationVoiture  dans la base de données
	 * @param LocationVoiture  : le nouvel objet avec modification
	 * @return 1 si l'objet a été modifié, 0 sinon
	 */
	public int update(LocationVoiture  location);
	
	/**<b>searchAll</b>
	 * Méthode pour récupérer tous les objets T dans la base de données
	 * @return List LocationVoiture liste des objets de type T de la base de données
	 */
	
	public List<LocationVoiture > searchAllLC();
	
	/**<b>searchById</b>
	 * Méthode pour récupérer un objet LocationVoiture  selon son id dans la base de données
	 * @param LocationVoiture  : l'objet persistant avec l'id que l'on recherche
	 * @return LocationVoiture  l'objet de la base de données
	 */
	public LocationVoiture  searchById(LocationVoiture  location);
	
	
	

}
