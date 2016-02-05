package bussiness.service_layer;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.person.IPersonDAO;
import domain.person.Person;
import fr.unicaen.am.model.Comment;
import fr.unicaen.am.model.Cycle;
import fr.unicaen.am.model.User;
import fr.unicaen.am.model.UserService;
/**
 * Classe de service encapsulant les traitements métiers liée à la gestion des users au sein d'une transaction (Bean spring : Service)
 * @author LAHBIB Amani, KHARAIM Nikita - Université de Caen Normandie, France
 * @since January, 2016
 */
@Service
@Transactional
public class UserImpl implements IUser{
	
	@Autowired
	private IPersonDAO personDAO;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private ICycleService cycleService;

	@Autowired
	ICommentService commentService;
	
	@Override
	public boolean addUser(Person person, String password) {
		try {
			personDAO.create(person,password);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Collection<Person> getAllUsers() {
		try {
			return personDAO.retrieveAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Collection<String> getAllEmails(){
		try {
			return personDAO.retrieveAllEmails();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Person getPerson(String email){
		try {
			return personDAO.retrieve(email);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean isValidUser(String email, String password) {
		try {
			return personDAO.isValid(email, password);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean userExists(String email){
		try {
			return personDAO.exists(email);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateUser(String email, Person person) {
		try {
			personDAO.update(email,person);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean updateUserPassword(String email, String password) {
		try {
			personDAO.updatePassword(email, password);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean deleteUser(String email) {
		try {
			User user = (User)getPerson(email);
			for (Cycle c : cycleService.getByDemandeur(user))
				cycleService.removeCycle(c.getId());
			for (Cycle c : cycleService.getByOffrant(user))
				cycleService.removeCycle(c.getId());
			for(Comment comment: commentService.getMessagesBySender(user))
				commentService.removeMessage(comment.getId());
			for(UserService us : userService.getUserServicesDemande(user.getEmail()))
				userService.deleteUserService(us.getId());
			for(UserService us : userService.getUserServicesOffert(user.getEmail()))
				userService.deleteUserService(us.getId());
			
			personDAO.delete(email);
			return true;
		} catch (Exception e) {
			try {
				personDAO.delete(email);
				return true;
			} catch (Exception e1) {
				
				e1.printStackTrace();
				return false;
			}
			
		}
		
	}
	
	
	
	

}
