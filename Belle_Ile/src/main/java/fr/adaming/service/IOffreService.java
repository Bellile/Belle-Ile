package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Hotel;
import fr.adaming.model.LocationVoiture;
import fr.adaming.model.Offre;
import fr.adaming.model.Vol;

public interface IOffreService {

	/**<b>add</b>
	 * Méthode pour ajouter un objet Offre dans la base de données
	 * @param Offre : l'objet persistant à ajouter
	 * @return Offre l'objet ajouté dans la base de données
	 */
	public Offre addOffre(Offre offre);
	
	/**<b>delete</b>
	 * Méthode pour supprimer un objet Offre dans la base de données
	 * @param Offre : l'objet à supprimer
	 * @return 1 si l'objet a été supprimé, 0 sinon
	 */
	public int deleteOffre(Offre offre);
	
	/**<b>update</b>
	 * Méthode pour modifier un objet Offre dans la base de données
	 * @param Offre : le nouvel objet avec modification
	 * @return 1 si l'objet a été modifié, 0 sinon
	 */
	public int updateOffre(Offre offre);
	
	/**<b>searchAll</b>
	 * Méthode pour récupérer tous les objets Offre dans la base de données
	 * @return List Offre liste des objets de type Offre de la base de données
	 */
	public List<Offre> searchAllOffre();
	
	/**<b>searchById</b>
	 * Méthode pour récupérer un objet Offre selon son id dans la base de données
	 * @param Offre : l'objet persistant avec l'id que l'on recherche
	 * @return Offre l'objet de la base de données
	 */
	public Offre searchOffreById(Offre offre);
}
