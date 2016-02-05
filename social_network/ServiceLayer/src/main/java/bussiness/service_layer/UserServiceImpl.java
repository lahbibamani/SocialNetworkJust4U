package bussiness.service_layer;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.unicaen.am.dao.IUserServiceDAO;
import fr.unicaen.am.model.Comment;
import fr.unicaen.am.model.Cycle;
import fr.unicaen.am.model.User;
import fr.unicaen.am.model.UserService;
/**
 * Classe de service encapsulant les traitements métiers liée à la gestion des services associés à un utilisateur au sein d'une transaction (Bean spring : Service)
 * @author LAHBIB Amani, KHARAIM Nikita - Université de Caen Normandie, France
 * @since January, 2016
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserServiceDAO dao;
	
	@Autowired
	private ICommentService commentService;
	
	@Autowired
	private ICycleService cycleService;
	

	@Override
	public void addUserService(UserService service){
		try {
			dao.createUserService(service);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateUserService(UserService service){
		try {
			dao.updateUserService(service);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public UserService retrieveUserService(long id){
		try {
			return dao.retrieveUserService(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Collection<UserService> retrieveAll(){
		try {
			return dao.retrieveAll();
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public void deleteUserService(long id){
		try {
			
			UserService us = dao.retrieveUserService(id);
			for (Cycle cycle : cycleService.getByUserServices(us))
				cycleService.removeCycle(cycle.getId());
			for(Comment comment: commentService.getMessagesByUserService(us))
				commentService.removeMessage(comment.getId());
			dao.deleteUserService(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void removeOldServices(){
		try {
			List<UserService> us = dao.retrieveOldServices();
			for(UserService u : us)
				deleteUserService(u.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	@Override
	public Collection<UserService> getUserServices(User user){
		try {
			return dao.retrieveUserServices(user);
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
		
	}
	
	@Override
	public Collection<UserService> getUserServicesDemande(String email){
		try {
			return dao.retrieveUserServicesDemande(email);
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
		
	}
	
	@Override
	public Collection<UserService> getUserServicesOffert(String email){
		try {
			return dao.retrieveUserServicesOffert(email);
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<domain.service.Service> getServicesDemande(String email) {
		try {
			List<domain.service.Service> ls = dao.getServicesDemande(email);
			System.out.println(ls.toString());
			return ls;
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<User> getPersonsOfferingService(domain.service.Service s) {
		try {
			//System.out.println(s.toString());
			List<User> lu = dao.getPersonsOfferingService(s);
			System.out.println(lu.toString());
			return lu;
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	

}
