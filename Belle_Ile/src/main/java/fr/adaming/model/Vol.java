/**
 * 
 */
package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Classe du model Vol
 * @author Thibault
 *
 */

@Entity
@Table(name="vols")
public class Vol implements Serializable{

	//Attributs
	/*
	 * Le nom de l'entier correspondant à l'id du vol dans la base de données
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_vol")
	private int id_vol;
	/*
	 * Nom de l'aéroport de départ du vol
	 */
	private String depart;
	/*
	 * Nom de l'aéroport d'atterrissage du vol
	 */
	private String arrivee;
	/*
	 * Date du décollage
	 */
	private Date dDepart;
	/*
	 * Date d'arrivee a destination
	 */
	private Date dArrivee;
	
	//Association UML en JAVA
	/*
	 * Association avec la classe offre
	 */
	@OneToOne
	private Offre offre;
	
	//Constructeur
	/*
	 * Un constructeur permettant d'instancier des objets "vol" vides
	 */
	public Vol() {
		super();
	}
	
	/*
	 * Un constructeur sans le paramètre id pour instancier un objet vol et l'ajouter à la base de données
	 */
	public Vol(String depart, String arrivee, Date dDepart, Date dArrivee) {
		super();
		this.depart = depart;
		this.arrivee = arrivee;
		this.dDepart = dDepart;
		this.dArrivee = dArrivee;
	}
	
	/*
	 * Un constructeur complet pour instancier un objet vol récupérer depuis la base de données
	 */
	public Vol(int id_vol, String depart, String arrivee, Date dDepart, Date dArrivee) {
		super();
		this.id_vol = id_vol;
		this.depart = depart;
		this.arrivee = arrivee;
		this.dDepart = dDepart;
		this.dArrivee = dArrivee;
	}
	
	//Getter/Setter
	public int getId_vol() {
		return id_vol;
	}
	
	public void setId_vol(int id_vol) {
		this.id_vol = id_vol;
	}
	
	public String getDepart() {
		return depart;
	}
	
	public void setDepart(String depart) {
		this.depart = depart;
	}
	
	public String getArrivee() {
		return arrivee;
	}
	
	public void setArrivee(String arrivee) {
		this.arrivee = arrivee;
	}
	
	public Date getdDepart() {
		return dDepart;
	}
	
	public void setdDepart(Date dDepart) {
		this.dDepart = dDepart;
	}
	
	public Date getdArrivee() {
		return dArrivee;
	}
	
	public void setdArrivee(Date dArrivee) {
		this.dArrivee = dArrivee;
	}

	public Offre getOffre() {
		return offre;
	}

	public void setOffre(Offre offre) {
		this.offre = offre;
	}	
	
}
