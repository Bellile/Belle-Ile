package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	@Lob
	private byte[] photo;

	@OneToOne
	@JoinColumn(name = "vol_id", referencedColumnName = "id_vol")
	private Vol vol;

	@ManyToOne
	@JoinColumn(name = "hotel_id", referencedColumnName = "id_hotel")
	private Hotel hotel;

	@OneToOne
	@JoinColumn(name = "location_id", referencedColumnName = "id_location")
	private LocationVoiture location;

	// Constructeur
	public Offre() {
		super();
	}

	public Offre(int nbNuit, double prix, int nbDispo, double promo, byte[] photo) {
		super();
		this.nbNuit = nbNuit;
		this.prix = prix;
		this.nbDispo = nbDispo;
		this.promo = promo;
		this.photo = photo;
	}

	public Offre(int id_offre, int nbNuit, double prix, int nbDispo, double promo, byte[] photo) {
		super();
		this.id_offre = id_offre;
		this.nbNuit = nbNuit;
		this.prix = prix;
		this.nbDispo = nbDispo;
		this.promo = promo;
		this.photo = photo;
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

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public LocationVoiture getLocation() {
		return location;
	}

	public void setLocation(LocationVoiture location) {
		this.location = location;
	}

}
