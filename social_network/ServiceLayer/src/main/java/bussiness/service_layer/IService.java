package bussiness.service_layer;

import java.util.Collection;
import java.util.List;

import domain.service.Service;

public interface IService {

	boolean addService (Service service);
	boolean updateService (Service service);
	Service getService (long id);
	Collection<Service> getAllServices();
	Collection<Service> getCategoryServices (String category);
	Collection<String> getAllCategories();
	boolean removeService(long id);
	List<String> getServicesLabel();
}
