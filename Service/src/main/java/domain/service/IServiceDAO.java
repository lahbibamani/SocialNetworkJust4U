package domain.service;

import java.util.Collection;
import java.util.List;

public interface IServiceDAO {
		void createService (Service service)throws Exception;
		void updateService (Service service)throws Exception;
		Service retrieveService (long id)throws Exception;
		Collection<Service> retrieveAll()throws Exception;
		Collection<Service> retrieveByCategory (String category) throws Exception;
		Collection<String> retrieveAllCategories () throws Exception;
		void deleteService(long id) throws Exception;
		List<String> retrieveServicesLabel();
		
}
