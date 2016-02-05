package fr.unicaen.am.dao;

import java.util.List;

import fr.unicaen.am.model.Cycle;
import fr.unicaen.am.model.User;
import fr.unicaen.am.model.UserService;

/**
 * Interface de manipulation des cycles
 * @author LAHBIB Amani, KARAIM Nikita - Université de Caen Normandie, France
 *
 */
public interface ICycleDAO {

	/**
	 * Création d'un cycle
	 * @param cycle Object à sauvgarder
	 * @return id de cycle créé
	 * @throws Exception S'il y a des problèmes de création
	 * @see Cycle
	 */
	Long createCycle(Cycle cycle) throws Exception;
	/**
	 * Mise à jour d'un cycle
	 * @param cycle Object à mettre à jour
	 * @throws Exception S'il y a des problèmes de mise à jour
	 * @see Cycle
	 */
	void updateCycle(Cycle cycle) throws Exception;
	/**
	 * Récupérer un cycle avec un id précis
	 * @param id Identificateur d'un cycle
	 * @return Cycle trouvé
	 * @throws Exception Problèmes de récupération
	 * @see Cycle
	 */
	Cycle retrieveCycle(long id) throws Exception;
	/**
	 * Récupérer tout les cycle existants dans la base de données
	 * @return Liste de cycles
	 * @throws Exception Problèmes de récupération
	 * @see Cycle
	 */
	List<Cycle> retrieveAll() throws Exception;
	/**
	 * Suppression d'un cycle avec un id précis
	 * @param id Identificateur d'un cycle
	 * @throws Exception Problèmes de suppression
	 * @see Cycle
	 */
	void deleteCycle(long id) throws Exception;
	/**
	 * Récupération de la liste de cycles par un service d'utilisateur
	 * @param userService Instance contenante un service d'un utilisateur
	 * @return Liste de cycles
	 * @throws Exception Problèmes de récupération
	 * @see UserService
	 */
	List<Cycle> retrieveByUserServices(UserService userService) throws Exception;
	/**
	 * Récupération de la liste de cycles par un utilisateur qui est offrant d'un service
	 * @param user Instance représantante un utilisateur
	 * @return Liste de cycles
	 * @see User
	 */
	List<Cycle> getByOffrant(User user);
	/**
	 * Récupération de la liste de cycles par un utilisateur qui est demandeur d'un service
	 * @param user Instance représantante un utilisateur
	 * @return Liste de cycles
	 * @see User
	 */
	List<Cycle> getByDemandeur(User user);

}
