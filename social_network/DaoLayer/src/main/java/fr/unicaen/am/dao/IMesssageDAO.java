package fr.unicaen.am.dao;

import java.util.List;

import fr.unicaen.am.model.Comment;
import fr.unicaen.am.model.UserService;

/**
 * Interface de manipulation sur des commentaires de services demand�s ou propos�s
 * @author KHARAIM Nikita, LAHBIB Amani - Universit� de Caen Normandie, France
 * @since January, 2016
 * @see Comment
 * @see MessageDAO
 * @see UserService
 */
public interface IMesssageDAO extends domain.chat.IMesssageDAO {
	/**
	 * R�cup�rer la liste de commentaires par une instance d'association utilisateur-service
	 * @param userService Instance d'association utilisateur-service
	 * @return Liste de commentaires
	 * @throws Exception Probl�mes de r�cup�ration
	 * @see UserService
	 */
	List<Comment> retrieveByUserService(UserService userService) throws Exception;
	
	/**
	 * R�cup�rer la liste de commentaires par une instance d'un utilisateur associ� comme exp�diteur
	 * @param sender Une instance d'un utilisateur associ� comme exp�diteur
	 * @return Liste de commentaires
	 * @throws Exception Probl�mes de r�cup�ration
	 */
	List<Comment> retrieveBySender(Object sender) throws Exception;
	
	/**
	 * R�cup�rer la liste de commentaires par une instance d'un utilisateur associ� comme destinataire
	 * @param receiver Une instance d'un utilisateur associ� comme destinataire
	 * @return Liste de commentaires
	 * @throws Exception Probl�mes de r�cup�ration
	 */
	List<Comment> retrieveByReceiver(Object receiver) throws Exception;
	
}