package fr.unicaen.am.dao;

import java.util.Collection;
import java.util.List;

import domain.service.Service;
import fr.unicaen.am.model.User;
import fr.unicaen.am.model.UserService;

/**
 * Interface de manipulation sur une association utilisateur-service
 * @author KHARAIM Nikita, LAHBIB Amani - Université de Caen Normandie, France
 * @since January, 2016
 * @see UserService
 * @see User
 * @see Service
 */
public interface IUserServiceDAO {
	/**
	 * Création d'une association utilisateur-service
	 * @param service Instance de l'association utilisateur-service
	 * @throws Exception Problèmes de création
	 */
	void createUserService(UserService service) throws Exception;
	/**
	 * Mise à jour d'une association utilisateur-service
	 * @param service Instance de l'association utilisateur-service
	 * @throws Exception Problèmes de mise à jour
	 */
	void updateUserService(UserService service) throws Exception;
	/**
	 * Récupération d'une association utilisateur-service par un id
	 * @param id Id d'une association utilisateur-service
	 * @return Instance de l'association utilisateur-service
	 * @throws Exception Problèmes de récupération
	 */
	UserService retrieveUserService(long id) throws Exception;

	/**
	 * Récupération de la liste de toutes les associations utilisateur-service
	 * @return Liste des associations utilisateur-service
	 * @throws Exception Problèmes de récupération
	 */
	Collection<UserService> retrieveAll() throws Exception;
	/**
	 * Suppression d'une association utilisateur-service
	 * @param id Id précis d'une association utilisateur-service
	 * @throws Exception Problèmes de suppression
	 */
	void deleteUserService(long id) throws Exception;
	/**
	 * Récupération des services qui sont associés à un utilisateur précis
	 * @param user Instance d'un utilisateur
	 * @return Liste des associations utilisateur-service sur un utilisateur précis
	 * @throws Exception Problèmes de récupération
	 */
	Collection<UserService> retrieveUserServices(User user) throws Exception;
	/**
	 * Récupération des associations utilisateur-service qui ont le type d'offert
	 * @param email Email de l'utilisateur
	 * @return Liste des associations utilisateur-service de type d'offert
	 * @throws Exception Problèmes de récupération
	 */
	Collection<UserService> retrieveUserServicesOffert(String email) throws Exception;
	/**
	 * Récupération des associations utilisateur-service qui ont le type de demande
	 * @param email Email de l'utilisateur
	 * @return Liste des associations utilisateur-service de type de demande
	 * @throws Exception Problèmes de récupération
	 */
	Collection<UserService> retrieveUserServicesDemande(String email) throws Exception;
	/**
	 * Récupération des associations utilisateur-service qui ont le type de demande
	 * @param email Email de l'utilisateur
	 * @return Liste des associations utilisateur-service de type de demande
	 */
	List<domain.service.Service> getServicesDemande(String email);
	/**
	 * Récupérer la liste des utilisateurs qui rendent un service précis
	 * @param s Service
	 * @return La liste des utilisateurs qui rendent un service précis
	 */
	List<User> getPersonsOfferingService(domain.service.Service s);
	
	List<UserService> retrieveOldServices() throws Exception;

}
