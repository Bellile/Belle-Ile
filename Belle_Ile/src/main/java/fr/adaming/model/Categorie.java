/**
 * 
 */
package fr.adaming.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe du model Categorie
 * @author Thibault
 *
 */

@Entity
@Table(name="categories")
public class Categorie {

	//Attributs
	/*
	 * Le nom de l'entier correspondant � l'id de la cat�gorie dans la base de donn�es
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_cat;
	
	/*
	 * L'ocean qui permet de diff�rencier les cat�gories
	 */
	private String ocean;

	//Constructeur
	/*
	 * Un constructeur permettant d'instancier des objets "categorie" vides
	 */
	public Categorie() {
		super();
	}

	/*
	 * Un constructeur sans le param�tre id pour instancier un objet categorie et l'ajouter � la base de donn�es
	 */
	public Categorie(String ocean) {
		super();
		this.ocean = ocean;
	}

	/*
	 * Un constructeur complet pour instancier un objet categorie r�cup�rer depuis la base de donn�es
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
	
	
}
