package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "locationVoitures")
public class LocationVoiture implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_location")
	private int id_location;
	private double prixJournee;
	private String typeVoiture;
	private int duree;

	//Constructeur
	public LocationVoiture() {
		super();
	}

	public LocationVoiture(double prixJournee, String typeVoiture, int duree) {
		super();
		this.prixJournee = prixJournee;
		this.typeVoiture = typeVoiture;
		this.duree = duree;
	}

	public LocationVoiture(int id_location) {
		super();
		this.id_location = id_location;
	}

	//getter et setter
	public int getId_location() {
		return id_location;
	}

	public void setId_location(int id_location) {
		this.id_location = id_location;
	}

	public double getPrixJournee() {
		return prixJournee;
	}

	public void setPrixJournee(double prixJournee) {
		this.prixJournee = prixJournee;
	}

	public String getTypeVoiture() {
		return typeVoiture;
	}

	public void setTypeVoiture(String typeVoiture) {
		this.typeVoiture = typeVoiture;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

}
