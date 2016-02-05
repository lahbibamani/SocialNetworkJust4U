package fr.unicaen.am.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.unicaen.am.model.Cycle;
import fr.unicaen.am.model.User;
import fr.unicaen.am.model.UserService;


/**
 * Classe responsable de persistance pour les cycles (bean spring pour la persistance: Repository) 
 * @author LAHBIB Amani, KHARAIM Nikita - Université de Caen Normandie, France
 * @since January, 2016
 * @see ICycleDAO
 * @see Cycle
 * @see UserService
 * @see User
 */

@Repository
public class CycleDAO implements ICycleDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Initialisation d'une session hibernate
	 * @return Instance de session hibernate
	 */
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Long createCycle(Cycle cycle) throws Exception {
		return (Long) getCurrentSession().save(cycle);		
	}

	@Override
	public void updateCycle(Cycle cycle) throws Exception {
		getCurrentSession().update(cycle);		
	}

	@Override
	public Cycle retrieveCycle(long id) throws Exception {
		return (Cycle) getCurrentSession().createQuery("from Cycle where id="+id).uniqueResult();
	}

	@Override
	public List<Cycle> retrieveAll() throws Exception {
		List<Cycle> list = getCurrentSession().createQuery("from Cycle").list();
		return list;
	}

	@Override
	public void deleteCycle(long id) throws Exception {
		Cycle cycle = retrieveCycle(id);
		if (cycle != null)
			getCurrentSession().delete(cycle);
				
	}

	@Override
	public List<Cycle> retrieveByUserServices(UserService userService) throws Exception {
		Query q = getCurrentSession().createQuery("select c from Cycle c where c.userService=:userService");
		q.setParameter("userService", userService);
		List<Cycle> l = q.list();
		for (Cycle c : l) {
		    Hibernate.initialize(c.getUserService());
		}
		return l;
	}

	@Override
	public List<Cycle> getByOffrant(User user) {
		Query q = getCurrentSession().createQuery("select c from Cycle c,Echange e where e.cycle=c.id and e.offrant=:offrant");
		q.setParameter("offrant", user);
		List<Cycle> l = q.list();
		for (Cycle c : l) {
		    Hibernate.initialize(c.getUserService());
		    Hibernate.initialize(c.getEchanges());
		}
		return l;
	}

	@Override
	public List<Cycle> getByDemandeur(User user) {
		Query q = getCurrentSession().createQuery("select c from Cycle c,Echange e where e.cycle=c.id and e.demandeur=:demandeur");
		q.setParameter("demandeur", user);
		List<Cycle> l = q.list();
		for (Cycle c : l) {
		    Hibernate.initialize(c.getUserService());
		    Hibernate.initialize(c.getEchanges());
		}
		return l;
	}

	
}
