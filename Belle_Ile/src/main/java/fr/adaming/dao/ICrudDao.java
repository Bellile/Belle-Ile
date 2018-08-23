/**
 * 
 */
package fr.adaming.dao;

import java.util.List;

/**
 * Interface générique pour le CRUD des classes
 * @author Thibault
 *
 */
public interface ICrudDao<T> {

	/**<b>add</b>
	 * Méthode pour ajouter un objet T dans la base de données
	 * @param T : l'objet persistant à ajouter
	 * @return T l'objet ajouté dans la base de données
	 */
	public T add(T t);
	
	/**<b>delete</b>
	 * Méthode pour supprimer un objet T dans la base de données
	 * @param T : l'objet à supprimer
	 * @return 1 si l'objet a été supprimé, 0 sinon
	 */
	public int delete(T t);
	
	/**<b>update</b>
	 * Méthode pour modifier un objet T dans la base de données
	 * @param T : le nouvel objet avec modification
	 * @return 1 si l'objet a été modifié, 0 sinon
	 */
	public int update(T t);
	
	/**<b>searchAll</b>
	 * Méthode pour récupérer tous les objets T dans la base de données
	 * @return List<T> liste des objets de type T de la base de données
	 */
	public List<T> searchAll();
	
	/**<b>searchById</b>
	 * Méthode pour récupérer un objet T selon son id dans la base de données
	 * @param T : l'objet persistant avec l'id que l'on recherche
	 * @return T l'objet de la base de données
	 */
	public T searchById(T t);
	
}
