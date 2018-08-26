package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Accompagnant;
import fr.adaming.model.Client;
import fr.adaming.model.Hotel;
import fr.adaming.model.LocationVoiture;
import fr.adaming.model.Offre;
import fr.adaming.model.Reservation;
import fr.adaming.model.Vol;

public interface IRechercheService {

	/**<b>searchByName</b>
	 * M�thode pour r�cup�rer une liste de Hotel selon son nom dans la base de donn�es
	 * @param nom : le String correspondant au nom de la recherche
	 * @return la liste des hotels dont le nom correspond � la recherche
	 */
	public List<Hotel> searchByNameHotel(String nom);
	
	/**<b>searchByAdresse</b>
	 * M�thode pour r�cup�rer une liste de Hotel selon son adresse dans la base de donn�es
	 * @param adresse : la rue, la ville, le code postal ou le pays
	 * @return la liste des hotels dont l'adresse correspond � la recherche
	 */
	public List<Hotel> searchByAdresseHotel(String adresse);
	
	/**<b>searchByCategorie</b>
	 * M�thode pour r�cup�rer une liste de Hotel selon son categorie dans la base de donn�es
	 * @param ocean : la categorie � laquelle appartient les hotels qu'on souhaite rechercher
	 * @return la liste des hotels dont la cat�gorie correspond � la recherche
	 */
	public List<Hotel> searchByCatHotel(String ocean);
	
	/**<b>searchByHotel</b>
	 * M�thode pour r�cup�rer une liste de Offre selon un hotel dans la base de donn�es
	 * @param hotel : l'objet hotel que l'on recherche
	 * @return la liste des offres dont l'hotel correspond � la recherche
	 */
	public List<Offre> searchByHotelOffre(Hotel hotel);
	
	/**<b>searchByString</b>
	 * M�thode pour r�cup�rer une liste de Offre selon un hotel dans la base de donn�es
	 * @param l'intitul� de la recherche
	 * @return la liste des offres dont la recherche correspond � la recherche
	 */
	public List<Offre> searchByStringOffre(String rech);
	
	/**<b>searchByDepart</b>
	 * M�thode pour r�cup�rer une liste de Offre selon un vol dans la base de donn�es
	 * @param Le vol de d�part du voyage
	 * @return  la liste des offres dont le vol de d�part correspond � la recherche
	 */
	public List<Offre> searchByDepartOffre(Vol vol);
	
	/**<b>searchByRetour</b>
	 * M�thode pour r�cup�rer une liste de Offre selon un vol dans la base de donn�es
	 * @param Le vol de retour du voyage
	 * @return  la liste des offres dont le vol de retour correspond � la recherche
	 */
	public List<Offre> searchByRetourOffre(Vol vol);
	
	/**<b>searchByPromo</b>
	 * M�thode pour r�cup�rer une liste de Offre selon une promotion dans la base de donn�es
	 * @param offre : l'Offre avec la valeur de promo que l'on recherche
	 * @return  la liste des offres dont la promo correspond � la recherche
	 */
	public List<Offre> searchByPromoOffre(Offre offre);
	
	/**<b>searchByPrix</b>
	 * M�thode pour r�cup�rer une liste de Offre selon un hotel dans la base de donn�es
	 * @param offre : l'Offre avec la valeur de prix que l'on recherche
	 * @return  la liste des offres dont le prix correspond � la recherche
	 */
	public List<Offre> searchByPrixOffre(Offre offre);
	
	/**<b>searchByResa</b>
	 * M�thode pour r�cup�rer une liste de Accompagnant selon une reservation dans la base de donn�es
	 * @param resa : l'objet Reservation que l'on recherche
	 * @return la liste des accompagnants d'une reservation
	 */
	public List<Accompagnant> searchByResaAcc(Reservation resa);
	
	/**<b>searchByType</b>
	 * M�thode pour r�cup�rer une liste de location de voiture selon un type de voiture dans la base de donn�es
	 * @param type : le type de voiture que l'on recherche
	 * @return la liste des locations de voirute correspondant � la recherche
	 */
	public List<LocationVoiture> searchByTypeLoc(String type);
	
	/**<b>searchByPrix</b>
	 * M�thode pour r�cup�rer une liste de location de voiture selon un prix � la journ�e dans la base de donn�es
	 * @param locV : l'objet LocationVoiture avec le prix � la journ�e que l'on recherche
	 * @return la liste des locations de voirute correspondant � la recherche
	 */
	public List<LocationVoiture> searchByPrixLoc(LocationVoiture locV);
	
	/**<b>searchByClient</b>
	 * M�thode pour r�cup�rer un objet T selon son id dans la base de donn�es
	 * @param client : le Client � l'origine de la recherche
	 * @return la liste des reservations effectu�es par un client
	 */
	public List<Reservation> searchByClientResa(Client client);
	
	/**<b>searchByMail</b>
	 * M�thode pour r�cup�rer un client selon son id dans la base de donn�es
	 * @param client : le Client avec le mail qu'on recherche
	 * @return le client correspondant � l'adresse mail recherch�e
	 */
	public Client searchByMailClient(Client client);
}
