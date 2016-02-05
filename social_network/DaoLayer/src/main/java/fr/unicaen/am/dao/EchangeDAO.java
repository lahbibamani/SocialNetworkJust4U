package fr.unicaen.am.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.unicaen.am.model.Cycle;
import fr.unicaen.am.model.Echange;
/**
 * Classe de manipulation sur des échange
 * @author LAHBIB Amani, KHARAIM Nikita - Université de Caen Normandie, France
 * @since January, 2016
 */
@Repository
public class EchangeDAO implements IEchangeDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Récupération d'une session hibernate
	 * @return
	 */
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void createEchange(Echange echange) throws Exception {
		getCurrentSession().save(echange);		
	}

	@Override
	public void updateEchange(Echange echange) throws Exception {
		getCurrentSession().update(echange);		
	}

	@Override
	public Echange retrieveEchange(long id) throws Exception {
		return (Echange) getCurrentSession().createQuery("from Echange where id="+id).uniqueResult();
	}

	@Override
	public List<Echange> retrieveAll() throws Exception {
		List<Echange> list = getCurrentSession().createQuery("from Echange").list();
		return list;
	}

	@Override
	public void deleteEchange(long id) throws Exception {
		Echange echange = retrieveEchange(id);
		if (echange != null)
			getCurrentSession().delete(echange);
				
	}

	@Override
	public List<Echange> retrieveByCycle(Cycle cycle) throws Exception {
		Query q = getCurrentSession().createQuery("select e from Echange e where e.cycle=:cycle");
		q.setParameter("cycle", cycle);
		List<Echange> l = q.list();
		for (Echange c : l) {
		    Hibernate.initialize(c.getCycle());
		    Hibernate.initialize(c.getDemandeur());
		    Hibernate.initialize(c.getOffrant());
		    Hibernate.initialize(c.getService());
		}
		return l;
	}

	@Override
	public void deleteEchangeByCycleId(long id) throws Exception {
		Query q = getCurrentSession().createQuery("delete from Echange e where e.cycle.id=:cycle");
		q.setParameter("cycle", id);
		q.executeUpdate();
		
	}
	
}
