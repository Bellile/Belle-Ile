package fr.adaming.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class Personne {
	
	
	
	/*
	 * Déclaration des attribus
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name="id")
	protected int id;
	protected String nom;
	protected String prenom;

	@Temporal(TemporalType.DATE)
	protected Date dn;
	protected String tel;
	
	
	/*
	 * uml en java
	 */
	@Embedded
	protected Adresse adresse;

	
	/*
	 * constructeurs
	 */
	
	public Personne() {
		super();
	}	
	

	public Personne(int id, String nom, String prenom, Date dn, String tel, Adresse adresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dn = dn;
		this.tel = tel;
		this.adresse = adresse;
	}


	public Personne(String nom, String prenom, Date dn, String tel, Adresse adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dn = dn;
		this.tel = tel;
		this.adresse = adresse;
	}


	/*
	 * getter et setter
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


	
	

	
	
	
	
	
	

}
