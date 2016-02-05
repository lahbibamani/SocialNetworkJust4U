package utils;

import java.io.File;
import java.util.Date;
import java.util.Properties;

/**
 * Classe utilitaire
 * @author LAHBIB Amani, KHARAIM Nikita - Université de Caen Normandie, France
 * @since January, 2016
 */
public class Utils {

	/**
	 * calcule l'age de l'utilisateur connecté
	 * 
	 * @param birth
	 *            date de naissance de l'utilisateur
	 *
	 */
	public static int getUserAge(Date birth) {
		return (int) Math.floor((new Date().getTime() - birth.getTime()) / (1000 * 60 * 60 * 24 * 365.25));
	}
	
}
