package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;


@Embeddable
public class Adresse implements Serializable{

	/*
	 * Attribus
	 */

	private String rue;
	private String cp;
	private String ville;
	private String pays;
	
	/*
	 * Constructeur
	 */

	public Adresse(String rue, String cp, String ville, String pays) {
		super();
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;
		this.pays = pays;
	}

	public Adresse() {
		super();
	}
	
	/*
	 * Getter et setter
	 */

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

}
