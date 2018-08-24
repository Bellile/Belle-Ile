package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Offre;

/**
 * Interface pour le CRUD de vol
 * @author Camille
 *
 */
public interface IOffreDao {

		
		/**<b>add</b>
		 * M�thode pour ajouter un objet Offre dans la base de donn�es
		 * @param Offre : l'objet persistant � ajouter
		 * @return Offre l'objet ajout� dans la base de donn�es
		 */
		public Offre addOffre(Offre offre);
		
		/**<b>delete</b>
		 * M�thode pour supprimer un objet Offre dans la base de donn�es
		 * @param Offre : l'objet � supprimer
		 * @return 1 si l'objet a �t� supprim�, 0 sinon
		 */
		public int deleteOffre(Offre offre);
		
		/**<b>update</b>
		 * M�thode pour modifier un objet Offre dans la base de donn�es
		 * @param Offre : le nouvel objet avec modification
		 * @return 1 si l'objet a �t� modifi�, 0 sinon
		 */
		public int updateOffre(Offre offre);
		
		/**<b>searchAll</b>
		 * M�thode pour r�cup�rer tous les objets Offre dans la base de donn�es
		 * @return List Offre liste des objets de type Offre de la base de donn�es
		 */
		public List<Offre> searchAllOffre();
		
		/**<b>searchById</b>
		 * M�thode pour r�cup�rer un objet Offre selon son id dans la base de donn�es
		 * @param Offre : l'objet persistant avec l'id que l'on recherche
		 * @return Offre l'objet de la base de donn�es
		 */
		public Offre searchOffreById(Offre offre);
}
