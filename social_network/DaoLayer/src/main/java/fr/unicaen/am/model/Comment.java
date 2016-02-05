package fr.unicaen.am.model;

import domain.chat.Message;
import domain.person.Person;

/**
 * Classe de commentaire sur un service
 * @author LAHBIB Amani, KHARAIM Nikita - Université de Caen Normandie, France
 * @since January, 2016
 * @see UserService
 */
public class Comment extends Message{

	private static final long serialVersionUID = 3430894879093773912L;
	
	/**
	 * Instance de l'association utilisateur-service
	 */
	protected UserService userService;
	
	/**
	 * Getter de l'expéditeur d'un commentaire
	 * @return L'expéditeur d'un commentaire - instance de l'utilisateur
	 */
	public Person getSender() {
		return (Person)sender;
	}
	
	/**
	 * Setter de l'expéditeur d'un commentaire
	 * @param sender L'expéditeur d'un commentaire - instance de l'utilisateur
	 */
	public void setSender(Person sender) {
		this.sender = sender;
	}
	
	/**
	 * Getter du destinataire d'un commentaire
	 * @return Destinataire d'un commentaire - instance de l'utilisateur
	 */
	public Person getReceiver() {
		return (Person)receiver;
	}
	
	/**
	 * Setter du destinataire d'un commentaire
	 * @param receiver Destinataire d'un commentaire - instance de l'utilisateur
	 */
	public void setReceiver(Person receiver) {
		this.receiver = receiver;
	}
	
	/**
	 * Getter de l'association utilisateur-service avec laquelle le commentaire est associé
	 * @return Instance de l'association utilisateur-service
	 */
	public UserService getUserService() {
		return userService;
	}
	
	/**
	 * Setter de l'association utilisateur-service avec laquelle le commentaire est associé
	 * @param userService Instance de l'association utilisateur-service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
}