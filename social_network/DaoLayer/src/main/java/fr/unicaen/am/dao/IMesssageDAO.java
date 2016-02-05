package fr.unicaen.am.dao;

import java.util.List;

import fr.unicaen.am.model.Comment;
import fr.unicaen.am.model.UserService;

/**
 * Interface de manipulation sur des commentaires de services demandés ou proposés
 * @author KHARAIM Nikita, LAHBIB Amani - Université de Caen Normandie, France
 * @since January, 2016
 * @see Comment
 * @see MessageDAO
 * @see UserService
 */
public interface IMesssageDAO extends domain.chat.IMesssageDAO {
	/**
	 * Récupérer la liste de commentaires par une instance d'association utilisateur-service
	 * @param userService Instance d'association utilisateur-service
	 * @return Liste de commentaires
	 * @throws Exception Problèmes de récupération
	 * @see UserService
	 */
	List<Comment> retrieveByUserService(UserService userService) throws Exception;
	
	/**
	 * Récupérer la liste de commentaires par une instance d'un utilisateur associé comme expéditeur
	 * @param sender Une instance d'un utilisateur associé comme expéditeur
	 * @return Liste de commentaires
	 * @throws Exception Problèmes de récupération
	 */
	List<Comment> retrieveBySender(Object sender) throws Exception;
	
	/**
	 * Récupérer la liste de commentaires par une instance d'un utilisateur associé comme destinataire
	 * @param receiver Une instance d'un utilisateur associé comme destinataire
	 * @return Liste de commentaires
	 * @throws Exception Problèmes de récupération
	 */
	List<Comment> retrieveByReceiver(Object receiver) throws Exception;
	
}