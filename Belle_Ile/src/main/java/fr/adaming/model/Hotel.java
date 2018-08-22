/**
 * 
 */
package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	public Hotel(String prestation, boolean piscine, boolean plage) {
		super();
		this.prestation = prestation;
		this.piscine = piscine;
		this.plage = plage;
	}
	/*
	 * Un constructeur complet pour instancier un objet hotel récupérer depuis la base de données
	 */
	public Hotel(int id_hotel, String prestation, boolean piscine, boolean plage) {
		super();
		this.id_hotel = id_hotel;
		this.prestation = prestation;
		this.piscine = piscine;
		this.plage = plage;
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
	
}
