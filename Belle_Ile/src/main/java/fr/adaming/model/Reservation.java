package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "reservations")
public class Reservation implements Serializable {

	/*
	 * Déclaration de l'association uml en java
	 */

	@ManyToOne
	@JoinColumn(name = "client_id", referencedColumnName = "id")
	private Client client;
	
	@OneToMany(mappedBy="reservation")
	private List<Accompagnant> listeAccompagnant;
	

	// attribut
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_resa")
	private int id_resa;

	// constructeur
	public Reservation() {
		super();
	}

	public Reservation(int id_resa) {
		super();
		this.id_resa = id_resa;
	}

	// getter et setter
	public int getId_resa() {
		return id_resa;
	}

	public void setId_resa(int id_resa) {
		this.id_resa = id_resa;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Accompagnant> getListeAccompagnant() {
		return listeAccompagnant;
	}

	public void setListeAccompagnant(List<Accompagnant> listeAccompagnant) {
		this.listeAccompagnant = listeAccompagnant;
	}
	
	
	

}
