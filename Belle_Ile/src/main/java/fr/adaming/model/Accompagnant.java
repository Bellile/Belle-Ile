package fr.adaming.model;



import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "accompagnants")

public class Accompagnant extends Personne {

	/*
	 * Association uml en java
	 */

	@ManyToOne
	@JoinColumn(name = "resa_id", referencedColumnName = "id_resa")
	protected Reservation reservation;

	/*
	 * constructeur vide
	 */

	public Accompagnant() {
		super();
	}

	/*
	 * getter et setter
	 */

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

}
