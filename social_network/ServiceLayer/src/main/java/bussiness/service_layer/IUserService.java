package bussiness.service_layer;

import java.util.Collection;
import java.util.List;

import domain.service.Service;
import fr.unicaen.am.model.User;
import fr.unicaen.am.model.UserService;

public interface IUserService {
	void addUserService(UserService service);

	void updateUserService(UserService service);

	UserService retrieveUserService(long id);

	Collection<UserService> retrieveAll();

	void deleteUserService(long id);

	Collection<UserService> getUserServices(User user);

	Collection<UserService> getUserServicesOffert(String email);

	Collection<UserService> getUserServicesDemande(String email);

	void removeOldServices();

	List<Service> getServicesDemande(String email);

	List<User> getPersonsOfferingService(Service s);


}
