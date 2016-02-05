package fr.unicaen.am.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe représentante un cycle
 * @author LAHBIB Amani, KHARAIM Nikita - Université de Caen Normandie, France
 * @since January, 2016
 * @see Echange
 * @see UserService
 */
public class Cycle implements Serializable{
	
	private static final long serialVersionUID = -2649639552038732420L;
	/*
	 * Id d'un cycle
	 */
	private Long id;
	/**
	 * Instance d'association d'un utilisateur avec un service
	 */
	private UserService userService;
	
	/**
	 * date de creation
	 */
	private Date dateCreation;
	/**
	 * Liste de echanges possibles
	 */
	private List<Echange> echanges = new ArrayList<Echange>();
	
	/**
	 * Constructeur de base
	 */
	public Cycle() {
	}

	/**
	 * Constructeur prenant en parametre une instance d'association utilisateur-service
	 * @param userService Association utilisateur-service
	 */
	public Cycle(UserService userService,Date date) {
		this.userService = userService;
		this.dateCreation=date;
	}

	/**
	 * Getter d'un id de cycle
	 * @return Id de cycle
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setter d'un id de cycle
	 * @param id Id de cycle
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Getter d'une instance d'association utilisateur-service
	 * @return Association utilisateur-service
	 */
	public UserService getUserService() {
		return userService;
	}
	
	/**
	 * Setter d'une instance d'association utilisateur-service
	 * @param userService Instance d'une association utilisateur-service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Getter de la liste d'echanges possibles
	 * @return Liste d'echanges
	 */
	public List<Echange> getEchanges() {
		return echanges;
	}

	/**
	 * Setter de la liste d'echanges possibles
	 * @param echange Liste d'echanges possibles
	 */
	public void setEchanges(List<Echange> echange) {
		this.echanges = echange;
	}
	
	

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	@Override
	public String toString() {
		return "Cycle [id=" + id + ", userService=" + userService + ", echanges=" + echanges + "]";
	}

	
}