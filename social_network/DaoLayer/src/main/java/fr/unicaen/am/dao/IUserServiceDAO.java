package fr.unicaen.am.dao;

import java.util.Collection;
import java.util.List;

import domain.service.Service;
import fr.unicaen.am.model.User;
import fr.unicaen.am.model.UserService;

/**
 * Interface de manipulation sur une association utilisateur-service
 * @author KHARAIM Nikita, LAHBIB Amani - Universit� de Caen Normandie, France
 * @since January, 2016
 * @see UserService
 * @see User
 * @see Service
 */
public interface IUserServiceDAO {
	/**
	 * Cr�ation d'une association utilisateur-service
	 * @param service Instance de l'association utilisateur-service
	 * @throws Exception Probl�mes de cr�ation
	 */
	void createUserService(UserService service) throws Exception;
	/**
	 * Mise � jour d'une association utilisateur-service
	 * @param service Instance de l'association utilisateur-service
	 * @throws Exception Probl�mes de mise � jour
	 */
	void updateUserService(UserService service) throws Exception;
	/**
	 * R�cup�ration d'une association utilisateur-service par un id
	 * @param id Id d'une association utilisateur-service
	 * @return Instance de l'association utilisateur-service
	 * @throws Exception Probl�mes de r�cup�ration
	 */
	UserService retrieveUserService(long id) throws Exception;

	/**
	 * R�cup�ration de la liste de toutes les associations utilisateur-service
	 * @return Liste des associations utilisateur-service
	 * @throws Exception Probl�mes de r�cup�ration
	 */
	Collection<UserService> retrieveAll() throws Exception;
	/**
	 * Suppression d'une association utilisateur-service
	 * @param id Id pr�cis d'une association utilisateur-service
	 * @throws Exception Probl�mes de suppression
	 */
	void deleteUserService(long id) throws Exception;
	/**
	 * R�cup�ration des services qui sont associ�s � un utilisateur pr�cis
	 * @param user Instance d'un utilisateur
	 * @return Liste des associations utilisateur-service sur un utilisateur pr�cis
	 * @throws Exception Probl�mes de r�cup�ration
	 */
	Collection<UserService> retrieveUserServices(User user) throws Exception;
	/**
	 * R�cup�ration des associations utilisateur-service qui ont le type d'offert
	 * @param email Email de l'utilisateur
	 * @return Liste des associations utilisateur-service de type d'offert
	 * @throws Exception Probl�mes de r�cup�ration
	 */
	Collection<UserService> retrieveUserServicesOffert(String email) throws Exception;
	/**
	 * R�cup�ration des associations utilisateur-service qui ont le type de demande
	 * @param email Email de l'utilisateur
	 * @return Liste des associations utilisateur-service de type de demande
	 * @throws Exception Probl�mes de r�cup�ration
	 */
	Collection<UserService> retrieveUserServicesDemande(String email) throws Exception;
	/**
	 * R�cup�ration des associations utilisateur-service qui ont le type de demande
	 * @param email Email de l'utilisateur
	 * @return Liste des associations utilisateur-service de type de demande
	 */
	List<domain.service.Service> getServicesDemande(String email);
	/**
	 * R�cup�rer la liste des utilisateurs qui rendent un service pr�cis
	 * @param s Service
	 * @return La liste des utilisateurs qui rendent un service pr�cis
	 */
	List<User> getPersonsOfferingService(domain.service.Service s);
	
	List<UserService> retrieveOldServices() throws Exception;

}
