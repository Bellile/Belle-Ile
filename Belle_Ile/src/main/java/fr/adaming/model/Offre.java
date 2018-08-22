package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "offres")
public class Offre implements Serializable {

	// Attribut
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_offre")
	private int id_offre;

	private int nbNuit;

	private double prix;

	private int nbDispo;

	private double promo;

	// Constructeur
	public Offre() {
		super();
	}

	public Offre(int nbNuit, double prix, int nbDispo) {
		super();
		this.nbNuit = nbNuit;
		this.prix = prix;
		this.nbDispo = nbDispo;
	}

	public Offre(int id_offre) {
		super();
		this.id_offre = id_offre;
	}

	// Getter et setter
	public int getId_offre() {
		return id_offre;
	}

	public void setId_offre(int id_offre) {
		this.id_offre = id_offre;
	}

	public int getNbNuit() {
		return nbNuit;
	}

	public void setNbNuit(int nbNuit) {
		this.nbNuit = nbNuit;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getNbDispo() {
		return nbDispo;
	}

	public void setNbDispo(int nbDispo) {
		this.nbDispo = nbDispo;
	}

	public double getPromo() {
		return promo;
	}

	public void setPromo(double promo) {
		this.promo = promo;
	}

}
