package fr.unicaen.am.model;

import java.io.Serializable;

import domain.person.Person;

/**
 * Classe représentante le role d'un utilisateur
 * @author LAHBIB Amani, KHARAIM Nikita - Université de Caen Normandie, France
 * @since January, 2016
 */
public class UserRole implements Serializable{
	/**
	 * id de role
	 */
	private Integer userRoleId;
	/**
	 * Utilisateur
	 */
	private User user;
	/**
	 * Titre de role
	 */
	private String role;
	
	/**
	 * Constructeur de base
	 */
	public UserRole() {
	}
	
	/**
	 * Constructeur avec des paramètres
	 * @param user Utilisateur
	 * @param role Role de l'utlisateur
	 */
	public UserRole(User user, String role) {
		super();
		this.user = user;
		this.role = role;
	}

	/**
	 * Getter de role de l'utilisateur
	 * @return Id de role de l'utilisateur
	 */
	public Integer getUserRoleId() {
		return userRoleId;
	}
	
	/**
	 * Setter de role de l'utilisateur
	 * @param userRoleId Id de role de l'utilisateur
	 */
	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}
	
	/**
	 * Getter de l'utilisateur
	 * @return Utilisateur
	 */
	public Person getUser() {
		return user;
	}
	
	/**
	 * Setter de l'utilisateur
	 * @param user Utilisateur
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * Getter de titre de role de l'utilisateur
	 * @return Titre de role de l'utilisateur
	 */
	public String getRole() {
		return role;
	}
	
	/**
	 * Setter de titre de role de l'utilisateur
	 * @param role Titre de role de l'utilisateur
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
}