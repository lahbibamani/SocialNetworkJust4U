package fr.unicaen.am.dao;

import java.util.List;

import fr.unicaen.am.model.Cycle;
import fr.unicaen.am.model.Echange;
import fr.unicaen.am.model.UserService;

/**
 * Interface de manipulation sur un �change
 * @author LAHBIB Amani, KHARAIM Nikita - Universit� de Caen Normandie, France
 * @since January, 2016
 */
public interface IEchangeDAO {
	/**
	 * Cr�ation d'un �change entre les utilisateurs
	 * @param echange Instance d'un �change
	 * @throws Exception Probl�mes de cr�ation
	 */
	void createEchange(Echange echange) throws Exception;

	/**
	 * Mise � jour d'un �change existant
	 * @param echange Instance d'un �change
	 * @throws Exception Probl�mes de mise � jour
	 */
	void updateEchange(Echange echange) throws Exception;

	/**
	 * R�cup�rer un �change par un id pr�cis
	 * @param id Id d'un �change
	 * @return Instance d'un �change
	 * @throws Exception Probl�mes de r�cup�ration
	 */
	Echange retrieveEchange(long id) throws Exception;

	/**
	 * R�cup�rer une liste de tout les �changes 
	 * @return Liste d'�change 
	 * @throws Exception Probl�mes de r�cup�ration
	 */
	List<Echange> retrieveAll() throws Exception;

	/**
	 * Suppression d'un �change par un id pr�cis
	 * @param id Id d'un �change
	 * @throws Exception Probl�mes de suppression
	 */
	void deleteEchange(long id) throws Exception;
	
	/**
	 * Supprimer un �change par un id d'un cycle
	 * @param id Id d'un cycle
	 * @throws Exception Probl�mes de suppression
	 */
	void deleteEchangeByCycleId(long id) throws Exception;

	/**
	 * R�cup�rer une liste d'�changes par un cycle pr�cis
	 * @param cycle Instance d'un cycle
	 * @return Liste d'�changes
	 * @throws Exception Probl�mes de r�cup�ration
	 * @see Cycle
	 */
	List<Echange> retrieveByCycle(Cycle cycle) throws Exception;

}