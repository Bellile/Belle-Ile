package fr.adaming.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "clients")
public class Client extends Personne {

	/** Attribut */

	private String mail;
	private String mdp;
	private boolean active;

	/** Association uml en java */
	@OneToMany(mappedBy = "client")
	private List<Reservation> listeResaClient;

	@ManyToOne
	@JoinColumn(name = "role_id", referencedColumnName = "id_role")
	private Role role;

	/** Constructeur */

	public Client() {
		super();
	}
	

	public Client(String nom, String prenom, Date dn, String tel, Adresse adresse, String mail, String mdp,
			boolean active, List<Reservation> listeResaClient, Role role) {
		super(nom, prenom, dn, tel, adresse);
		this.mail = mail;
		this.mdp = mdp;
		this.active = active;
		this.listeResaClient = listeResaClient;
		this.role = role;
	}

	public Client(int id, String nom, String prenom, Date dn, String tel, Adresse adresse, String mail, String mdp,
			boolean active, List<Reservation> listeResaClient, Role role) {
		super(id, nom, prenom, dn, tel, adresse);
		this.mail = mail;
		this.mdp = mdp;
		this.active = active;
		this.listeResaClient = listeResaClient;
		this.role = role;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
