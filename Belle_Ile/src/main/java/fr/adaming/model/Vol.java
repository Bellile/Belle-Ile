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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	 * Le nom de l'entier correspondant � l'id du vol dans la base de donn�es
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_vol")
	private int id_vol;
	/*
	 * Nom de l'a�roport de d�part du vol
	 */
	private String depart;
	/*
	 * Nom de l'a�roport d'atterrissage du vol
	 */
	private String arrivee;
	/*
	 * Date du d�collage
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date dDepart;
	/*
	 * Date d'arrivee a destination
	 */
	@Temporal(TemporalType.TIMESTAMP)
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
	 * Un constructeur sans le param�tre id pour instancier un objet vol et l'ajouter � la base de donn�es
	 */
	public Vol(String depart, String arrivee, Date dDepart, Date dArrivee) {
		super();
		this.depart = depart;
		this.arrivee = arrivee;
		this.dDepart = dDepart;
		this.dArrivee = dArrivee;
	}
	
	/*
	 * Un constructeur complet pour instancier un objet vol r�cup�rer depuis la base de donn�es
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
