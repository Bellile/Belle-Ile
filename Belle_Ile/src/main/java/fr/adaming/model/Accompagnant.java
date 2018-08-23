package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="accompagnants")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Accompagnant implements Serializable{

	/*
	 * Association uml en java
	 */

	@Embedded
	private Adresse adresse;

	@ManyToOne
	@JoinColumn(name="resa_id", referencedColumnName="id_resa")
	private Reservation reservation;

	/*
	 * Déclaration des attribus
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	@Temporal(TemporalType.DATE)
	private Date dn;
	private String tel;

	/*
	 * Déclaration des constructeurs
	 */

	public Accompagnant(int id, String nom, String prenom, Date dn, String tel) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dn = dn;
		this.tel = tel;
	}

	public Accompagnant(String nom, String prenom, Date dn, String tel) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dn = dn;
		this.tel = tel;
	}

	public Accompagnant() {
		super();
	}

	/*
	 * Déclaration des getter et setter
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDn() {
		return dn;
	}

	public void setDn(Date dn) {
		this.dn = dn;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	
	

}
