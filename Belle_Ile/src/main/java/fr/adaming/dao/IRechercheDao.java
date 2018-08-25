package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Accompagnant;
import fr.adaming.model.Adresse;
import fr.adaming.model.Categorie;
import fr.adaming.model.Client;
import fr.adaming.model.Hotel;
import fr.adaming.model.LocationVoiture;
import fr.adaming.model.Offre;
import fr.adaming.model.Reservation;
import fr.adaming.model.Vol;

/**
 * Interface pour le CRUD des classes
 * @author Thibault
 *
 */
public interface IRechercheDao {

	/**<b>searchByName</b>
	 * Méthode pour récupérer une liste de Hotel selon son nom dans la base de données
	 * @param nom : le String correspondant au nom de la recherche
	 * @return la liste des hotels dont le nom correspond à la recherche
	 */
	public List<Hotel> searchByNameHotel(String nom);
	
	/**<b>searchByAdresse</b>
	 * Méthode pour récupérer une liste de Hotel selon son adresse dans la base de données
	 * @param adresse : la rue, la ville, le code postal ou le pays
	 * @return la liste des hotels dont l'adresse correspond à la recherche
	 */
	public List<Hotel> searchByAdresseHotel(String adresse);
	
	/**<b>searchByCategorie</b>
	 * Méthode pour récupérer une liste de Hotel selon son categorie dans la base de données
	 * @param ocean : la categorie à laquelle appartient les hotels qu'on souhaite rechercher
	 * @return la liste des hotels dont la catégorie correspond à la recherche
	 */
	public List<Hotel> searchByCatHotel(String ocean);
	
	/**<b>searchByHotel</b>
	 * Méthode pour récupérer une liste de Offre selon un hotel dans la base de données
	 * @param hotel : l'objet hotel que l'on recherche
	 * @return la liste des offres dont l'hotel correspond à la recherche
	 */
	public List<Offre> searchByHotelOffre(Hotel hotel);
	
	/**<b>searchByDepart</b>
	 * Méthode pour récupérer une liste de Offre selon un vol dans la base de données
	 * @param Le vol de départ du voyage
	 * @return  la liste des offres dont le vol de départ correspond à la recherche
	 */
	public List<Offre> searchByDepartOffre(Vol vol);
	
	/**<b>searchByRetour</b>
	 * Méthode pour récupérer une liste de Offre selon un vol dans la base de données
	 * @param Le vol de retour du voyage
	 * @return  la liste des offres dont le vol de retour correspond à la recherche
	 */
	public List<Offre> searchByRetourOffre(Vol vol);
	
	/**<b>searchByPromo</b>
	 * Méthode pour récupérer une liste de Offre selon une promotion dans la base de données
	 * @param offre : l'Offre avec la valeur de promo que l'on recherche
	 * @return  la liste des offres dont la promo correspond à la recherche
	 */
	public List<Offre> searchByPromoOffre(Offre offre);
	
	/**<b>searchByPrix</b>
	 * Méthode pour récupérer une liste de Offre selon un hotel dans la base de données
	 * @param offre : l'Offre avec la valeur de prix que l'on recherche
	 * @return  la liste des offres dont le prix correspond à la recherche
	 */
	public List<Offre> searchByPrixOffre(Offre offre);
	
	/**<b>searchByResa</b>
	 * Méthode pour récupérer une liste de Accompagnant selon une reservation dans la base de données
	 * @param resa : l'objet Reservation que l'on recherche
	 * @return la liste des accompagnants d'une reservation
	 */
	public List<Accompagnant> searchByResaAcc(Reservation resa);
	
	/**<b>searchByType</b>
	 * Méthode pour récupérer une liste de location de voiture selon un type de voiture dans la base de données
	 * @param type : le type de voiture que l'on recherche
	 * @return la liste des locations de voirute correspondant à la recherche
	 */
	public List<LocationVoiture> searchByTypeLoc(String type);
	
	/**<b>searchByPrix</b>
	 * Méthode pour récupérer une liste de location de voiture selon un prix à la journée dans la base de données
	 * @param locV : l'objet LocationVoiture avec le prix à la journée que l'on recherche
	 * @return la liste des locations de voirute correspondant à la recherche
	 */
	public List<LocationVoiture> searchByPrixLoc(LocationVoiture locV);
	
	/**<b>searchByClient</b>
	 * Méthode pour récupérer un objet T selon son id dans la base de données
	 * @param client : le Client à l'origine de la recherche
	 * @return la liste des reservations effectuées par un client
	 */
	public List<Reservation> searchByClientResa(Client client);
	
	/**<b>searchByMail</b>
	 * Méthode pour récupérer un client selon son id dans la base de données
	 * @param client : le Client avec le mail qu'on recherche
	 * @return le client correspondant à l'adresse mail recherchée
	 */
	public Client searchByMailClient(Client client);
}
