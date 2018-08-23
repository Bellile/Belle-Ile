/**
 * 
 */
package fr.adaming.dao;

import java.util.List;

/**
 * Interface g�n�rique pour le CRUD des classes
 * @author Thibault
 *
 */
public interface ICrudDao<T> {

	/**<b>add</b>
	 * M�thode pour ajouter un objet T dans la base de donn�es
	 * @param T : l'objet persistant � ajouter
	 * @return T l'objet ajout� dans la base de donn�es
	 */
	public T add(T t);
	
	/**<b>delete</b>
	 * M�thode pour supprimer un objet T dans la base de donn�es
	 * @param T : l'objet � supprimer
	 * @return 1 si l'objet a �t� supprim�, 0 sinon
	 */
	public int delete(T t);
	
	/**<b>update</b>
	 * M�thode pour modifier un objet T dans la base de donn�es
	 * @param T : le nouvel objet avec modification
	 * @return 1 si l'objet a �t� modifi�, 0 sinon
	 */
	public int update(T t);
	
	/**<b>searchAll</b>
	 * M�thode pour r�cup�rer tous les objets T dans la base de donn�es
	 * @return List<T> liste des objets de type T de la base de donn�es
	 */
	public List<T> searchAll();
	
	/**<b>searchById</b>
	 * M�thode pour r�cup�rer un objet T selon son id dans la base de donn�es
	 * @param T : l'objet persistant avec l'id que l'on recherche
	 * @return T l'objet de la base de donn�es
	 */
	public T searchById(T t);
	
}
