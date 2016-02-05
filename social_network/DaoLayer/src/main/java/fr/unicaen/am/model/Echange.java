package fr.unicaen.am.model;

import java.io.Serializable;

import domain.service.Service;

/**
 * Classe repr�sentante un �change entre les utilisateurs
 * @author LAHBIB Amani, KHARAIM Nikita - Universit� de Caen Normandie, France
 * @since January, 2016
 * @see User
 * @see Service
 */
public class Echange implements Serializable{
	
	private Long id;
	
	/**
	 * Utilisateur offrant
	 */
	private User offrant;
	
	/**
	 * Utilisateur demandant
	 */
	private User demandeur;
	
	/**
	 * Service de l'�change
	 */
	private Service service;
	
	/**
	 * Accept� ou pas
	 */
	private Boolean accepted;
	
	/**
	 * Cycle associ�
	 */
	private Cycle cycle;
	
	/**
	 * Constructeur par defaut
	 */
	public Echange() {
	}
	
	/**
	 * Constructeur avec des param�tres
	 * @param offrant Utilisateur offrant
	 * @param demandeur Utilisateur demandant
	 * @param service Service de l'�change
	 * @param cycle Cycle associ�
	 */
	public Echange(User offrant, User demandeur, Service service, Cycle cycle) {
		this.offrant = offrant;
		this.demandeur = demandeur;
		this.service = service;
		this.cycle = cycle;
	}

	/**
	 * Constructeur avec des param�tres
	 * @param offrant Utilisateur offrant
	 * @param demandeur Utilisateur demandant
	 * @param service Service de l'�change
	 */
	public Echange(User offrant, User demandeur, Service service) {
		this.offrant = offrant;
		this.demandeur = demandeur;
		this.service = service;
	}
	
	/**
	 * R�cup�rer un utilisateur offrant
	 * @return Utilisateur offrant
	 */
	public User getOffrant() {
		return offrant;
	}
	
	/**
	 * Setter de l'utilisateur offrant
	 * @param offrant Utilisateur offrant
	 */
	public void setOffrant(User offrant) {
		this.offrant = offrant;
	}
	
	/**
	 * Getter de l'utilisateur demandant
	 * @return L'utilisateur demandant
	 * @see User
	 */
	public User getDemandeur() {
		return demandeur;
	}
	
	/**
	 * Setter de l'utilisateur damandant
	 * @param demandeur L'utilisateur damandant
	 * @see User
	 */
	public void setDemandeur(User demandeur) {
		this.demandeur = demandeur;
	}
	
	/**
	 * Getter de service de l'�change
	 * @return Service de l'�change
	 * @see Service
	 */
	public Service getService() {
		return service;
	}
	
	/**
	 * Setter de service de l'�change
	 * @param service Service de l'�change
	 * @see Service
	 */
	public void setService(Service service) {
		this.service = service;
	}

	/**
	 * Getter de cycle associ� � l'�change
	 * @return Cycle associ� � l'�change
	 */
	public Cycle getCycle() {
		return cycle;
	}

	/**
	 * Setter de cycle associ� � l'�change
	 * @param cycle Cycle associ� � l'�change
	 */
	public void setCycle(Cycle cycle) {
		this.cycle = cycle;
	}

	@Override
	public String toString() {
		return "Echange [offrant=" + offrant + ", demandeur=" + demandeur + ", service=" + service + "]";
	}

	/**
	 * Accept� l'�change ou pas
	 * @return Etat de l'�change
	 */
	public Boolean getAccepted() {
		return accepted;
	}

	/**
	 * Setter de l'�tat de l'�chnage
	 * @param accepted Etat de l'�change
	 */
	public void setAccepted(Boolean accepted) {
		this.accepted = accepted;
	}

	/**
	 * Getter de id de l'�change
	 * @return Id de l'�change
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setter de id de l'�change
	 * @param id Id de l'�change
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	
	

}