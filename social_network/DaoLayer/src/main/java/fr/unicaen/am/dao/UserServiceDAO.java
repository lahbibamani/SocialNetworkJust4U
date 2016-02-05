package fr.unicaen.am.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import domain.service.Service;
import fr.unicaen.am.model.TypeService;
import fr.unicaen.am.model.User;
import fr.unicaen.am.model.UserService;
/**
 * Classe de manipulation sur les associations utilisateur-service
 * @author LAHBIB Amani, KHARAIM Nikita - Université de Caen Normandie, France
 * @since January, 2016
 * @see UserService
 */
@Repository
public class UserServiceDAO implements IUserServiceDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void createUserService(UserService service) throws Exception {
		getCurrentSession().save(service);

	}

	@Override
	public void updateUserService(UserService service) throws Exception {
		getCurrentSession().update(service);

	}

	@Override
	public UserService retrieveUserService(long id) throws Exception {
		UserService userService = (UserService) getCurrentSession().createQuery("from UserService where id=" + id)
				.uniqueResult();
		if (userService != null) {
			Hibernate.initialize(userService.getService());
			Hibernate.initialize(userService.getPerson());
		}
		return userService;
	}

	@Override
	public List<UserService> retrieveOldServices() throws Exception {
		Query q = getCurrentSession().createQuery("select us from UserService us where endDate<:today");
		q.setParameter("today", new Date());
		return q.list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<UserService> retrieveAll() throws Exception {
		return getCurrentSession().createQuery("from UserService").list();
	}

	@Override
	public void deleteUserService(long id) throws Exception {
		UserService service = retrieveUserService(id);
		if (service != null)
			getCurrentSession().delete(service);

	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<UserService> retrieveUserServicesDemande(String email) throws Exception {
		Query q = getCurrentSession()
				.createQuery("select us from UserService us where us.person.email=:email and us.typeService=:type");
		q.setParameter("email", email);
		q.setParameter("type", TypeService.DEMANDE);
		Collection<UserService> us = q.list();
		for (UserService s : us) {
			Hibernate.initialize(s.getService());
			Hibernate.initialize(s.getPerson());
		}
		return us;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<UserService> retrieveUserServicesOffert(String email) throws Exception {
		Query q = getCurrentSession()
				.createQuery("select us from UserService us where us.person.email=:email and us.typeService=:type");
		q.setParameter("email", email);
		q.setParameter("type", TypeService.OFFRE);
		Collection<UserService> us = q.list();
		for (UserService s : us) {
			Hibernate.initialize(s.getService());
			Hibernate.initialize(s.getPerson());
		}
		return us;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<UserService> retrieveUserServices(User user) throws Exception {
		Collection<UserService> us = getCurrentSession()
				.createQuery("select us from UserService us where us.person.email!='" + user.getEmail()
						+ "' order by creationDate DESC")
				.list();
		for (UserService s : us) {
			Hibernate.initialize(s.getService());
			Hibernate.initialize(s.getPerson());
		}
		return us;
	}

	@Override
	public List<Service> getServicesDemande(String email) {
		Query q = getCurrentSession().createQuery(
				"select us.service from UserService us where us.person.email=:email and us.typeService=:type");
		q.setParameter("email", email);
		q.setParameter("type", TypeService.DEMANDE);
		List<Service> us = q.list();
		return us;
	}

	@Override
	public List<User> getPersonsOfferingService(Service s) {
		Query q = getCurrentSession()
				.createQuery("select us.person from UserService us where us.typeService=0 and us.service=:service");
		q.setParameter("service", s);
		return q.list();
	}

}
