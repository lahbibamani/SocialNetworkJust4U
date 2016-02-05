package bussiness.service_layer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.person.IPersonDAO;
import fr.unicaen.am.model.UserRole;


/**
 * Classe de service pour la gestion de l'authentification et l'autorisation utilisé par Spring Security
 * @author LAHBIB Amani, KHARAIM Nikita - Université de Caen Normandie, France
 * @since January, 2016
 */

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private IPersonDAO personDAO;

	@Override
	public UserDetails loadUserByUsername(final String username) 
               throws UsernameNotFoundException {

		fr.unicaen.am.model.User user;
		try {
			user = (fr.unicaen.am.model.User) personDAO.retrieve(username);
			List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());

			return buildUserForAuthentication(user, authorities);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		

	}

	// Converts fr.unicaen.am.model.User user to org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(fr.unicaen.am.model.User user, 
		List<GrantedAuthority> authorities) {
		return new User(user.getEmail(), 
			user.getPassword(), user.isEnabled(), 
                        true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}

	public IPersonDAO getPersonDAO() {
		return personDAO;
	}

	public void setPersonDAO(IPersonDAO personDAO) {
		this.personDAO = personDAO;
	}
}
