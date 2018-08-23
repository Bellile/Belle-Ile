package fr.adaming.service;

import java.util.List;

import fr.adaming.model.LocationVoiture;

public interface ILocationVoitureService {
	
	
	
	/**<b>add</b>
	 * M�thode pour ajouter un objet LocationVoiture  dans la base de donn�es
	 * @param LocationVoiture  : l'objet persistant � ajouter
	 * @return LocationVoiture  l'objet ajout� dans la base de donn�es
	 */
	public LocationVoiture add(LocationVoiture  location);
	
	/**<b>delete</b>
	 * M�thode pour supprimer un objet LocationVoiture  dans la base de donn�es
	 * @param LocationVoiture  : l'objet � supprimer
	 * @return 1 si l'objet a �t� supprim�, 0 sinon
	 */
	public int delete(LocationVoiture  location);
	
	
	
	
	/**<b>update</b>
	 * M�thode pour modifier un objet LocationVoiture  dans la base de donn�es
	 * @param LocationVoiture  : le nouvel objet avec modification
	 * @return 1 si l'objet a �t� modifi�, 0 sinon
	 */
	public int update(LocationVoiture  location);
	
	/**<b>searchAll</b>
	 * M�thode pour r�cup�rer tous les objets T dans la base de donn�es
	 * @return List LocationVoiture liste des objets de type T de la base de donn�es
	 */
	
	public List<LocationVoiture > searchAll();
	
	/**<b>searchById</b>
	 * M�thode pour r�cup�rer un objet LocationVoiture  selon son id dans la base de donn�es
	 * @param LocationVoiture  : l'objet persistant avec l'id que l'on recherche
	 * @return LocationVoiture  l'objet de la base de donn�es
	 */
	public LocationVoiture  searchById(LocationVoiture  location);
	
	
	

}
