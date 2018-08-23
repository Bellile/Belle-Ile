/**
 * 
 */
package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Categorie;

/**
 * Interface g�n�rique pour le CRUD des classes
 * @author Thibault
 *
 */
public interface ICategorieDao {

	/**<b>add</b>
	 * M�thode pour ajouter une Categorie cat dans la base de donn�es
	 * @param cat : l'objet Categorie persistant � ajouter
	 * @return Categorie l'objet ajout� dans la base de donn�es
	 */
	public Categorie addCat(Categorie cat);
	
	/**<b>delete</b>
	 * M�thode pour supprimer une Categorie cat dans la base de donn�es
	 * @param cat : la categorie � supprimer
	 * @return 1 si l'objet a �t� supprim�, 0 sinon
	 */
	public int deleteCat(Categorie cat);
	
	/**<b>update</b>
	 * M�thode pour modifier une Categorie cat dans la base de donn�es
	 * @param cat : la categorie avec modification
	 * @return 1 si l'objet a �t� modifi�, 0 sinon
	 */
	public int updateCat(Categorie cat);
	
	/**<b>searchAll</b>
	 * M�thode pour r�cup�rer tous les objets une Categorie cat dans la base de donn�es
	 * @return List(Categorie) liste des objets de type T de la base de donn�es
	 */
	public List<Categorie> searchAllCat();
	
	/**<b>searchById</b>
	 * M�thode pour r�cup�rer un objet T selon son id dans la base de donn�es
	 * @param cat : l'objet Categorie avec l'id que l'on recherche
	 * @return Categorie l'objet de la base de donn�es
	 */
	public Categorie searchByIdCat(Categorie cat);
	
}
