package fr.adaming.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client extends Accompagnant {

	/** Association uml en java */
	@OneToMany(mappedBy = "client")
	private List<Reservation> listeResaClient;

	@ManyToOne
	@JoinColumn(name = "role_id", referencedColumnName = "id_role")
	private Role role;

	/** Attribu */

	private String mail;
	private String mdp;
	private Boolean active;

	/** Constructeur */

	public Client(int id, String nom, String prenom, Date dn, String tel, String mail, String mdp) {
		super(id, nom, prenom, dn, tel);
		this.mail = mail;
		this.mdp = mdp;
	}

	public Client(int id, String nom, String prenom, Date dn, String tel, String mail, String mdp, Boolean active) {
		super(id, nom, prenom, dn, tel);
		this.mail = mail;
		this.mdp = mdp;
		this.active = active;
	}

	public Client(String nom, String prenom, Date dn, String tel, String mail, String mdp, Boolean active) {
		super(nom, prenom, dn, tel);
		this.mail = mail;
		this.mdp = mdp;
		this.active = active;
	}

	public Client() {
		super();
	}

	public Client(String nom, String prenom, Date dn, String tel, String mail, String mdp) {
		super(nom, prenom, dn, tel);
		this.mail = mail;
		this.mdp = mdp;
	}

	/** Getter setter */
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

	public List<Reservation> getListeResaClient() {
		return listeResaClient;
	}

	public void setListeResaClient(List<Reservation> listeResaClient) {
		this.listeResaClient = listeResaClient;
	}

}
