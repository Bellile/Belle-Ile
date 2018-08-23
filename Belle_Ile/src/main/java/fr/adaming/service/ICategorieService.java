package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Categorie;

/**
 * Interface générique pour le CRUD des classes
 * @author Thibault
 *
 */
public interface ICategorieService {

	/**<b>add</b>
	 * Méthode pour ajouter une Categorie cat dans la base de données
	 * @param cat : l'objet Categorie persistant à ajouter
	 * @return Categorie l'objet ajouté dans la base de données
	 */
	public Categorie addCat(Categorie cat);
	
	/**<b>delete</b>
	 * Méthode pour supprimer une Categorie cat dans la base de données
	 * @param cat : la categorie à supprimer
	 * @return 1 si l'objet a été supprimé, 0 sinon
	 */
	public int deleteCat(Categorie cat);
	
	/**<b>update</b>
	 * Méthode pour modifier une Categorie cat dans la base de données
	 * @param cat : la categorie avec modification
	 * @return 1 si l'objet a été modifié, 0 sinon
	 */
	public int updateCat(Categorie cat);
	
	/**<b>searchAll</b>
	 * Méthode pour récupérer tous les objets une Categorie cat dans la base de données
	 * @return List(Categorie) liste des objets de type T de la base de données
	 */
	public List<Categorie> searchAllCat();
	
	/**<b>searchById</b>
	 * Méthode pour récupérer un objet T selon son id dans la base de données
	 * @param cat : l'objet Categorie avec l'id que l'on recherche
	 * @return Categorie l'objet de la base de données
	 */
	public Categorie searchByIdCat(Categorie cat);
	
}
