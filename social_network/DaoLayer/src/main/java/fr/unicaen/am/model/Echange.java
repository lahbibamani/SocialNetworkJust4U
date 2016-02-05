package fr.unicaen.am.model;

import java.io.Serializable;

import domain.service.Service;

/**
 * Classe représentante un échange entre les utilisateurs
 * @author LAHBIB Amani, KHARAIM Nikita - Université de Caen Normandie, France
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
	 * Service de l'échange
	 */
	private Service service;
	
	/**
	 * Accepté ou pas
	 */
	private Boolean accepted;
	
	/**
	 * Cycle associé
	 */
	private Cycle cycle;
	
	/**
	 * Constructeur par defaut
	 */
	public Echange() {
	}
	
	/**
	 * Constructeur avec des paramètres
	 * @param offrant Utilisateur offrant
	 * @param demandeur Utilisateur demandant
	 * @param service Service de l'échange
	 * @param cycle Cycle associé
	 */
	public Echange(User offrant, User demandeur, Service service, Cycle cycle) {
		this.offrant = offrant;
		this.demandeur = demandeur;
		this.service = service;
		this.cycle = cycle;
	}

	/**
	 * Constructeur avec des paramètres
	 * @param offrant Utilisateur offrant
	 * @param demandeur Utilisateur demandant
	 * @param service Service de l'échange
	 */
	public Echange(User offrant, User demandeur, Service service) {
		this.offrant = offrant;
		this.demandeur = demandeur;
		this.service = service;
	}
	
	/**
	 * Récupérer un utilisateur offrant
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
	 * Getter de service de l'échange
	 * @return Service de l'échange
	 * @see Service
	 */
	public Service getService() {
		return service;
	}
	
	/**
	 * Setter de service de l'échange
	 * @param service Service de l'échange
	 * @see Service
	 */
	public void setService(Service service) {
		this.service = service;
	}

	/**
	 * Getter de cycle associé à l'échange
	 * @return Cycle associé à l'échange
	 */
	public Cycle getCycle() {
		return cycle;
	}

	/**
	 * Setter de cycle associé à l'échange
	 * @param cycle Cycle associé à l'échange
	 */
	public void setCycle(Cycle cycle) {
		this.cycle = cycle;
	}

	@Override
	public String toString() {
		return "Echange [offrant=" + offrant + ", demandeur=" + demandeur + ", service=" + service + "]";
	}

	/**
	 * Accepté l'échange ou pas
	 * @return Etat de l'échange
	 */
	public Boolean getAccepted() {
		return accepted;
	}

	/**
	 * Setter de l'état de l'échnage
	 * @param accepted Etat de l'échange
	 */
	public void setAccepted(Boolean accepted) {
		this.accepted = accepted;
	}

	/**
	 * Getter de id de l'échange
	 * @return Id de l'échange
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setter de id de l'échange
	 * @param id Id de l'échange
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	
	

}