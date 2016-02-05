package utils;

import domain.service.Service;
import fr.unicaen.am.model.User;

/**
 * Classe représentante d'une relation d'échange d'un service entre 2 personnes
 * @author LAHBIB Amani, KHARAIM Nikita - Université de Caen Normandie, France
 * @since January, 2016
 */
public class Relation {
	private Service service;
	private User user;
	private int niveau;
	
	public Relation() {
		// TODO Auto-generated constructor stub
	}
	
	public Relation(Service service, User user, int niveau) {
		super();
		this.service = service;
		this.user = user;
		this.niveau = niveau;
	}



	public Relation(int i) {
		niveau = i;
	}

	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	@Override
	public String toString() {
		return "Relation [service=" + service + ", user=" + user + ", niveau=" + niveau + "]";
	}
	
	

}
