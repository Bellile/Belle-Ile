package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Vol;

/**
 * Interface pour le CRUD de vol
 * @author Camille
 *
 */
public interface IVolService {

	/**<b>add</b>
	 * M�thode pour ajouter un objet Vol dans la base de donn�es
	 * @param Vol : l'objet persistant � ajouter
	 * @return Vol l'objet ajout� dans la base de donn�es
	 */
	public Vol addVol(Vol vol);
	
	/**<b>delete</b>
	 * M�thode pour supprimer un objet vol dans la base de donn�es
	 * @param Vol : l'objet � supprimer
	 * @return 1 si l'objet a �t� supprim�, 0 sinon
	 */
	public int deleteVol(Vol vol);
	
	/**<b>update</b>
	 * M�thode pour modifier un objet Vol dans la base de donn�es
	 * @param Vol : le nouvel objet avec modification
	 * @return 1 si l'objet a �t� modifi�, 0 sinon
	 */
	public int updateVol(Vol vol);
	
	/**<b>searchAll</b>
	 * M�thode pour r�cup�rer tous les objets vol dans la base de donn�es
	 * @return List Vol liste des objets de type Vol de la base de donn�es
	 */
	public List<Vol> searchAllVol();
	
	/**<b>searchById</b>
	 * M�thode pour r�cup�rer un objet Vol selon son id dans la base de donn�es
	 * @param Vol : l'objet persistant avec l'id que l'on recherche
	 * @return Vol l'objet de la base de donn�es
	 */
	public Vol searchVolById(Vol vol);
}
