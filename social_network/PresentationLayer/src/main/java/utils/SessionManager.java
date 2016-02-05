package utils;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import bussiness.service_layer.IUser;
import fr.unicaen.am.model.User;

/**
 * A class for representing persons, with a name, a first name, and an email
 * address.
 * 
 * @author Amani LAHBIB and mykyta KHARAIM, Caen Basse-Normandie University,
 *         France
 */

public class SessionManager {
	

	/**
	 * Loads the informations of logged user into the HTTP session under key
	 * "user". Does nothing if user infos are already loaded.
	 * 
	 * @param session
	 *            The HTTP session into which logged user must be loaded
	 * @param userService
	 *            A service object for user manager
	 */
	public static void initializeSession(HttpSession session,IUser userService) {
		if (session.getAttribute("user") == null) {
			// check if user is logged in
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (!(auth instanceof AnonymousAuthenticationToken)) {
				UserDetails userDetail = (UserDetails) auth.getPrincipal();
				User user = (User) userService.getPerson(userDetail.getUsername());
				session.setAttribute("user", user);
				if (user.getBirth() != null) {
					session.setAttribute("age", Utils.getUserAge(user.getBirth()));
				}

			}

		}
	}

}
