/**
 * 
 */
package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe du model Categorie
 * @author Thibault
 *
 */

@Entity
@Table(name="categories")
public class Categorie implements Serializable {

	//Attributs
	/*
	 * Le nom de l'entier correspondant à l'id de la catégorie dans la base de données
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cat")
	private int id_cat;
	
	/*
	 * L'ocean qui permet de différencier les catégories
	 */
	private String ocean;

	//Association UML en JAVA
	/*
	 * Association avec la classe Hotel
	 */
	@OneToMany(mappedBy="categorie")
	private List<Hotel> listeHotel;
	
	//Constructeur
	/*
	 * Un constructeur permettant d'instancier des objets "categorie" vides
	 */
	public Categorie() {
		super();
	}

	/*
	 * Un constructeur sans le paramètre id pour instancier un objet categorie et l'ajouter à la base de données
	 */
	public Categorie(String ocean) {
		super();
		this.ocean = ocean;
	}

	/*
	 * Un constructeur complet pour instancier un objet categorie récupérer depuis la base de données
	 */
	public Categorie(int id_cat, String ocean) {
		super();
		this.id_cat = id_cat;
		this.ocean = ocean;
	}

	//Getter/Setter
	public int getId_cat() {
		return id_cat;
	}

	public void setId_cat(int id_cat) {
		this.id_cat = id_cat;
	}

	public String getOcean() {
		return ocean;
	}

	public void setOcean(String ocean) {
		this.ocean = ocean;
	}

	public List<Hotel> getListeHotel() {
		return listeHotel;
	}

	public void setListeHotel(List<Hotel> listeHotel) {
		this.listeHotel = listeHotel;
	}
	
	
}
