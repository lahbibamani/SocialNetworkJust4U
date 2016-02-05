package fr.unicaen.am.dao;

import java.util.List;

import fr.unicaen.am.model.Cycle;
import fr.unicaen.am.model.User;
import fr.unicaen.am.model.UserService;

/**
 * Interface de manipulation des cycles
 * @author LAHBIB Amani, KARAIM Nikita - Universit� de Caen Normandie, France
 *
 */
public interface ICycleDAO {

	/**
	 * Cr�ation d'un cycle
	 * @param cycle Object � sauvgarder
	 * @return id de cycle cr��
	 * @throws Exception S'il y a des probl�mes de cr�ation
	 * @see Cycle
	 */
	Long createCycle(Cycle cycle) throws Exception;
	/**
	 * Mise � jour d'un cycle
	 * @param cycle Object � mettre � jour
	 * @throws Exception S'il y a des probl�mes de mise � jour
	 * @see Cycle
	 */
	void updateCycle(Cycle cycle) throws Exception;
	/**
	 * R�cup�rer un cycle avec un id pr�cis
	 * @param id Identificateur d'un cycle
	 * @return Cycle trouv�
	 * @throws Exception Probl�mes de r�cup�ration
	 * @see Cycle
	 */
	Cycle retrieveCycle(long id) throws Exception;
	/**
	 * R�cup�rer tout les cycle existants dans la base de donn�es
	 * @return Liste de cycles
	 * @throws Exception Probl�mes de r�cup�ration
	 * @see Cycle
	 */
	List<Cycle> retrieveAll() throws Exception;
	/**
	 * Suppression d'un cycle avec un id pr�cis
	 * @param id Identificateur d'un cycle
	 * @throws Exception Probl�mes de suppression
	 * @see Cycle
	 */
	void deleteCycle(long id) throws Exception;
	/**
	 * R�cup�ration de la liste de cycles par un service d'utilisateur
	 * @param userService Instance contenante un service d'un utilisateur
	 * @return Liste de cycles
	 * @throws Exception Probl�mes de r�cup�ration
	 * @see UserService
	 */
	List<Cycle> retrieveByUserServices(UserService userService) throws Exception;
	/**
	 * R�cup�ration de la liste de cycles par un utilisateur qui est offrant d'un service
	 * @param user Instance repr�santante un utilisateur
	 * @return Liste de cycles
	 * @see User
	 */
	List<Cycle> getByOffrant(User user);
	/**
	 * R�cup�ration de la liste de cycles par un utilisateur qui est demandeur d'un service
	 * @param user Instance repr�santante un utilisateur
	 * @return Liste de cycles
	 * @see User
	 */
	List<Cycle> getByDemandeur(User user);

}
