package fr.unicaen.am.dao;

import java.util.List;

import fr.unicaen.am.model.Cycle;
import fr.unicaen.am.model.Echange;
import fr.unicaen.am.model.UserService;

/**
 * Interface de manipulation sur un échange
 * @author LAHBIB Amani, KHARAIM Nikita - Université de Caen Normandie, France
 * @since January, 2016
 */
public interface IEchangeDAO {
	/**
	 * Création d'un échange entre les utilisateurs
	 * @param echange Instance d'un échange
	 * @throws Exception Problèmes de création
	 */
	void createEchange(Echange echange) throws Exception;

	/**
	 * Mise à jour d'un échange existant
	 * @param echange Instance d'un échange
	 * @throws Exception Problèmes de mise à jour
	 */
	void updateEchange(Echange echange) throws Exception;

	/**
	 * Récupérer un échange par un id précis
	 * @param id Id d'un échange
	 * @return Instance d'un échange
	 * @throws Exception Problèmes de récupération
	 */
	Echange retrieveEchange(long id) throws Exception;

	/**
	 * Récupérer une liste de tout les échanges 
	 * @return Liste d'échange 
	 * @throws Exception Problèmes de récupération
	 */
	List<Echange> retrieveAll() throws Exception;

	/**
	 * Suppression d'un échange par un id précis
	 * @param id Id d'un échange
	 * @throws Exception Problèmes de suppression
	 */
	void deleteEchange(long id) throws Exception;
	
	/**
	 * Supprimer un échange par un id d'un cycle
	 * @param id Id d'un cycle
	 * @throws Exception Problèmes de suppression
	 */
	void deleteEchangeByCycleId(long id) throws Exception;

	/**
	 * Récupérer une liste d'échanges par un cycle précis
	 * @param cycle Instance d'un cycle
	 * @return Liste d'échanges
	 * @throws Exception Problèmes de récupération
	 * @see Cycle
	 */
	List<Echange> retrieveByCycle(Cycle cycle) throws Exception;

}