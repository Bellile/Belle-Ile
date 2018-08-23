package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin implements Serializable {

	/*
	 * association uml en java
	 */
	@ManyToOne
	@JoinColumn(name = "role_id", referencedColumnName = "id_role")
	private Role role;

	/*
	 * Attribus
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_admin;
	private String mail;
	private String mdp;

	/** Constructeur */

	public Admin(int id_admin, String mail, String mdp) {
		super();
		this.id_admin = id_admin;
		this.mail = mail;
		this.mdp = mdp;
	}

	public Admin(String mail, String mdp) {
		super();
		this.mail = mail;
		this.mdp = mdp;
	}

	public Admin() {
		super();
	}

	/** getter et setter */

	public int getId_admin() {
		return id_admin;
	}

	public void setId_admin(int id_admin) {
		this.id_admin = id_admin;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

}
