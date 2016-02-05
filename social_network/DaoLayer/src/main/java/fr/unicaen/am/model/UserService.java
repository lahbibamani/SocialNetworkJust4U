package fr.unicaen.am.model;

import java.io.Serializable;
import java.util.Date;

import domain.service.Service;

/**
 * Classe d'association d'un utilisateur avec un service
 * @author KHARAIM Nikita, LAHBIB Amani - Université de Caen Normandie, France
 * @since january, 2016
 * @see User
 * @see Service
 * @see TypeService
 */
public class UserService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Id d'association
	 */
	private Long id;
	
	/**
	 * Instance d'un utilisateur
	 * @see User
	 */
	private User person;
	
	/**
	 * Instance d'un service
	 * @see Service
	 */
	private Service service;
	
	/**
	 * La date de debut de la fourniture/demande d'un service
	 */
	private Date startDate;
	
	/**
	 * La date de fin de la fourniture/demande d'un service
	 */
	private Date endDate;
	
	/**
	 * Type d'un service associé (fourniture/demande)
	 * @see TypeService
	 */
	private TypeService typeService;
	
	/**
	 * Date de création de l'association
	 */
	private Date creationDate;
	
	/**
	 * Constructeur de base
	 */
	public UserService() {
	}

	/**
	 * Constructeur avec des parametres
	 * @param person Utilisateur qui fournis/demande un service
	 * @param service Service attaché
	 * @param startDate La date de debut de la fourniture/demande d'un service
	 * @param endDate La date de fin de la fourniture/demande d'un service
	 * @param typeService Type d'un service associé (fourniture/demande)
	 * @see User
	 * @see Service
	 * @see TypeService
	 */
	public UserService(User person, Service service, Date startDate, Date endDate, TypeService typeService) {
		super();
		this.person = person;
		this.service = service;
		this.startDate = startDate;
		this.endDate = endDate;
		this.typeService = typeService;
	}

	/**
	 * Constucteur avec parametre - Initialisation d'une association par un service
	 * @param s Service associé
	 * @see Service
	 */
	public UserService(Service s) {
		service = s;
	}

	/**
	 * Getter d'un utilisateur associé
	 * @return Utilisateur associé
	 * @see User
	 */
	public User getPerson() {
		return person;
	}

	/**
	 * Setter d'un utilisateur associé
	 * @param person Utilisateur associé
	 */
	public void setPerson(User person) {
		this.person = person;
	}

	/**
	 * Getter d'un service associé
	 * @return Service associé
	 * @see Service
	 */
	public Service getService() {
		return service;
	}

	/**
	 * Setter d'un service associé
	 * @param serivce Serivce associé
	 * @see Service
	 */
	public void setService(Service serivce) {
		this.service = serivce;
	}

	/**
	 * Getter d'un id de l'association
	 * @return Id de l'association
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setter d'un id de l'association
	 * @param id Id de l'association
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Getter de la date de debut de la fourniture/demande d'un service
	 * @return Date de debut
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Setter de la date de debut de la fourniture/demande d'un service
	 * @param startDate Date de debut
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	
	/**
	 * Getter de la date de fin de la fourniture/demande d'un service
	 * @return Date de fin
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Setter de la date de fin de la fourniture/demande d'un service
	 * @param endDate Date de fin
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Getter de type d'un service associé (fourniture/demande)
	 * @return Type de service associé
	 * @see TypeService
	 */
	public TypeService getTypeService() {
		return typeService;
	}

	/**
	 * Setter de type d'un service associé (fourniture/demande)
	 * @param typeService Type de service associé
	 * @see TypeService
	 */
	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}

	/**
	 * Getter de la date de création de l'association
	 * @return Date de création de l'association
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * Setter de la date de création de l'association
	 * @param creationDate Date de création de l'association
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	
	@Override
	public String toString() {
		return "UserService [id=" + id + ", person=" + person.toString() + ", service=" + service + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}

}