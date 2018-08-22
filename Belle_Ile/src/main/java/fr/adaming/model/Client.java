package fr.adaming.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client extends Accompagnant {

	/** Association uml en java */
	@OneToMany(mappedBy = "id_resa")
	private List<Reservation> listeResaClient;

	/** Attribu */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id_client;
	private String mail;
	private String mdp;

	/** Constructeur */
	public Client(String mail, String mdp) {
		super();
		this.mail = mail;
		this.mdp = mdp;
	}

	public Client(int id_client, String mail, String mdp) {
		super();
		this.id_client = id_client;
		this.mail = mail;
		this.mdp = mdp;
	}

	public Client() {
		super();
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

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

}
