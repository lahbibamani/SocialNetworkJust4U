package fr.unicaen.am.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import domain.person.Person;

/**
 * Classe représentante un utilisateur de l'application
 * @author LAHBIB Amani, KHARAIM Nikita - Université de Caen Normandie, France
 * @since January, 2016
 * @see Person
 */
public class User extends Person implements Serializable{

	/**
	 * Mot de passe de l'utilisateur 
	 */
	private String password;
	
	/**
	 * Adresse
	 */
	private String adress;
	
	/**
	 * Numéro de téléphone de l'utilisateur 
	 */
	private String phone;
	
	/**
	 * Type de téléphone de l'utilisateur 
	 */
	private String phoneType;
	
	/**
	 * Sexe de l'utilisateur 
	 */
	private String gender;
	
	/** 
	 * Date de naissance de l'utilisateur 
	 */
	private Date birth;
	
	/**
	 * Ville de l'utilisateur 
	 */
	private String ville;
	
	/**
	 * Pays de l'utilisateur 
	 */
	private String pays;
	
	/**
	 * image de l'utilisateur 
	 */
	private String img;
	
	/**
	 * XS
	 */
	private Boolean enabled;
	
	/**
	 * Role de l'utilisateur
	 */
	private Set<UserRole> userRole = new HashSet<UserRole>(0);
	
	/**
	 * Constructeur de base
	 */
	public User() {
		super("", "", "");
	}
	
	/**
	 * Constructeur avec des parametres
	 * @param name Nom de l'utilisateur
	 * @param firstName Prénome de l'utilisateur
	 * @param email Email de l'utilisateur
	 */
	public User(String name, String firstName, String email) {
		super(name, firstName, email);
	}

	/**
	 * Getter de mot de passe
	 * @return Mot de passe
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter de mot de passe
	 * @param password Mot de passe
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter de l'adresse de l'utilisateur
	 * @return Adresse de l'utilisateur
	 */
	public String getAdress() {
		return adress;
	}

	/**
	 * Setter de l'adresse de l'utilisateur
	 * @param adress Adresse de l'utilisateur
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}

	/**
	 * Getter de numéro de téléphone de l'utilisateur
	 * @return Numéro de téléphone de l'utilisateur
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Setter de numéro de téléphone de l'utilisateur 
	 * @param phone Numéro de téléphone de l'utilisateur
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Getter de sexe de l'utilisateur 
	 * @return Sexe de l'utilisateur 
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Setter de sexe de l'utilisateur 
	 * @param gender Sexe de l'utilisateur 
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Getter de la date de naissance de l'utilisateur 
	 * @return La date de naissance de l'utilisateur 
	 */
	public Date getBirth() {
		return birth;
	}
	
	/**
	 * Setter de la date de naissance de l'utilisateur 
	 * @param birth La date de naissance de l'utilisateur 
	 */
	public void setBirth(Date birth) {
		this.birth = birth;
	}

	/**
	 * Getter de la ville de l'utilisateur 
	 * @return La ville de l'utilisateur 
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * Setter de la ville de l'utilisateur 
	 * @param ville La ville de l'utilisateur 
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * Getter du pays de l'utilisateur 
	 * @return Pays de l'utilisateur 
	 */
	public String getPays() {
		return pays;
	}

	/**
	 * Setter du pays de l'utilisateur 
	 * @param pays Pays de l'utilisateur 
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}

	/**
	 * Status de l'utilisateur 
	 * @return Actif ou pas
	 */
	public Boolean isEnabled() {
		return enabled;
	}

	/**
	 * Setter du status de l'utilisateur 
	 * @param enabled Status de l'utilisateur
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Getter du role de l'utilisateur 
	 * @return Role de l'utilisateur 
	 */
	public Set<UserRole> getUserRole() {
		return userRole;
	}

	/**
	 * Setter du role de l'utilisateur 
	 * @param userRole Role de l'utilisateur 
	 */
	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

	/**
	 * Getter du numéro de téléphone de l'utilisateur 
	 * @return Numéro de téléphone de l'utilisateur 
	 */
	public String getPhoneType() {
		return phoneType;
	}

	/**
	 * Setter du numéro de téléphone de l'utilisateur 
	 * @param phoneType Numéro de téléphone de l'utilisateur 
	 */
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	@Override
	public String toString() {
		return "adress=" + adress + ", phone=" + phone + ", phoneType=" + phoneType + ", gender=" + gender
				+ ", birth=" + birth + ", ville=" + ville + ", pays=" + pays + ", name=" + name + ", firstName="
				+ firstName + ", email=" + email+ ", img=" + img;
	}

	
	
	
	
}