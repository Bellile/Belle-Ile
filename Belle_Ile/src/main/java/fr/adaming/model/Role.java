package fr.adaming.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

	/*
	 * attribus
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_role;
	private String roleName;

	/*
	 * Association uml en java
	 */
	@OneToMany(mappedBy="role")
	private List<Client> listeClient;

	@OneToMany(mappedBy = "role")
	private List<Admin> listeAdmin;

	/*
	 * Constructeur
	 */

	public Role(int id_role, String roleName) {
		super();
		this.id_role = id_role;
		this.roleName = roleName;
	}

	public Role() {
		super();
	}

	/*
	 * getter et setter
	 */

	public int getId_role() {
		return id_role;
	}

	public void setId_role(int id_role) {
		this.id_role = id_role;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<Admin> getListeAdmin() {
		return listeAdmin;
	}

	public void setListeAdmin(List<Admin> listeAdmin) {
		this.listeAdmin = listeAdmin;
	}

}
