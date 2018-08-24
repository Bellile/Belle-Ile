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
	/**
	 * Le nom de l'entier correspondant � l'id de l'hotel dans la base de donn�es
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_hotel")
	private int id_hotel;
	
	/**
	 * Le type de prestation que propose un hotel
	 */
	private String prestation;
	
	/**
	 * Le type de prestation que propose un hotel
	 */
	private String nom;
	
	/**
	 * Un indicateur qui permet de savoir si l'hotel poss�de un hotel ou non
	 */
	private boolean piscine;
	/**
	 * Un indicateur qui permet de savoir si l'hotel a acc�s � une plage ou non
	 */
	private boolean plage;
	
	/**
	 * 
	 * @Lob permet de confirmer que la photo est une blob dans la base SQL
	 */
	@Lob
	private byte[] photo;
		
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
	 * Un constructeur sans le param�tre id pour instancier un objet hotel et l'ajouter � la base de donn�es
	 */
	public Hotel(String prestation, String nom, boolean piscine, boolean plage, byte[] photo, Adresse adresse) {
		super();
		this.prestation = prestation;
		this.nom = nom;
		this.piscine = piscine;
		this.plage = plage;
		this.photo = photo;
		this.adresse = adresse;
	}
	

	/*
	 * Un constructeur complet pour instancier un objet hotel r�cup�rer depuis la base de donn�es
	 */
	public Hotel(int id_hotel, String prestation, String nom, boolean piscine, boolean plage, byte[] photo,
			Adresse adresse) {
		super();
		this.id_hotel = id_hotel;
		this.prestation = prestation;
		this.nom = nom;
		this.piscine = piscine;
		this.plage = plage;
		this.photo = photo;
		this.adresse = adresse;
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
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
}
