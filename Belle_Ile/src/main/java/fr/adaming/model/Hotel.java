/**
 * 
 */
package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Classe du model Hotel
 * @author Thibault
 *  
 */
@Entity
@Table(name="hotels")
public class Hotel implements Serializable{

	//Attributs
	/*
	 * Le nom de l'entier correspondant à l'id de l'hotel dans la base de données
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_hotel")
	private int id_hotel;
	
	/*
	 * Le type de prestation que propose un hotel
	 */
	private String prestation;
	
	/*
	 * Un indicateur qui permet de savoir si l'hotel possède un hotel ou non
	 */
	private boolean piscine;
	/*
	 * Un indicateur qui permet de savoir si l'hotel a accès à une plage ou non
	 */
	private boolean plage;
	
	/**
	 * 
	 * @Lob permet de confirmer que la photo est une blob dans la base SQL
	 */
	@Lob
	private byte[] photo;
	
	/**
	 * Attribut utilisé pour afficher l'image dans la vue
	 * @Transient evite que l'attribut selectionne ne soit integre a la base de
	 *            donnees.
	 */
	@Transient
	private String image;
	
	//Association UML en JAVA
	/*
	 * Association avec la classe adresse
	 */
	@Embedded
	private Adresse adresse;
	
	/*
	 * Association avec la classe offre
	 */
	@OneToMany(mappedBy="hotel")
	private List<Offre> listeOffre;
	
	/*
	 * Association avec la classe offre
	 */
	@ManyToOne
	@JoinColumn(name="cat_id", referencedColumnName="id_cat")
	private Categorie categorie;
	//Constructeur
	/*
	 * Un constructeur permettant d'instancier des objets "hotel" vides
	 */
	public Hotel() {
		super();
	}
	/*
	 * Un constructeur sans le paramètre id pour instancier un objet hotel et l'ajouter à la base de données
	 */
	public Hotel(String prestation, boolean piscine, boolean plage, byte[] photo) {
		super();
		this.prestation = prestation;
		this.piscine = piscine;
		this.plage = plage;
		this.photo = photo;
	}
	
	/*
	 * Un constructeur complet pour instancier un objet hotel récupérer depuis la base de données
	 */
	public Hotel(int id_hotel, String prestation, boolean piscine, boolean plage, byte[] photo) {
		super();
		this.id_hotel = id_hotel;
		this.prestation = prestation;
		this.piscine = piscine;
		this.plage = plage;
		this.photo = photo;
	}
	
	//Getter/Setter
	public int getId_hotel() {
		return id_hotel;
	}
	

	public void setId_hotel(int id_hotel) {
		this.id_hotel = id_hotel;
	}
	
	public String getPrestation() {
		return prestation;
	}
	
	public void setPrestation(String prestation) {
		this.prestation = prestation;
	}
	
	public boolean isPiscine() {
		return piscine;
	}
	
	public void setPiscine(boolean piscine) {
		this.piscine = piscine;
	}
	
	public boolean isPlage() {
		return plage;
	}
	
	public void setPlage(boolean plage) {
		this.plage = plage;
	}
	
	public byte[] getPhoto() {
		return photo;
	}
	
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	public Adresse getAdresse() {
		return adresse;
	}
	
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	public List<Offre> getListeOffre() {
		return listeOffre;
	}
	
	public void setListeOffre(List<Offre> listeOffre) {
		this.listeOffre = listeOffre;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}
	
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	

}
