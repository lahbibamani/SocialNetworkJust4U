package bussiness.service_layer;

import java.util.List;

import fr.unicaen.am.model.Cycle;
import fr.unicaen.am.model.Echange;
import fr.unicaen.am.model.User;
import fr.unicaen.am.model.UserService;

public interface ICycleService {

	boolean addCycle(Cycle cycle, List<Echange> echange);

	Cycle getCycleById(long id);

	List<Cycle> getAllCycles();

	boolean removeCycle(long id);
	
	//boolean deleteCycleByUserService(long id);

	List<Cycle> getByUserServices(UserService userService);
	
	List<Cycle> getByOffrant(User user);
	List<Cycle> getByDemandeur(User user);

	boolean updateCycle(Cycle cycle, Echange echange);

}
