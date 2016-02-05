package fr.unicaen.am.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import domain.chat.Message;
import domain.person.Person;
import fr.unicaen.am.model.Comment;
import fr.unicaen.am.model.UserService;
/**
 * Classe de manimulation sur des commentaires de services
 * @author KHARAIM Nikita, LAHBIB Amani - Université de Caen Normandie, France
 * @since January, 2016
 * @see IMesssageDAO
 * @see Person
 * @see UserService
 */
@Repository
public class MessageDAO implements IMesssageDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void createMessage(Message m) {
		getCurrentSession().save((Comment)m);
	}

	@Override
	public void updateMessage(Message m) throws Exception {
		getCurrentSession().update((Comment)m);
		
	}

	@Override
	public void deleteMessage(Message m) throws Exception {
		getCurrentSession().delete((Comment)m);
		
	}

	@Override
	public Message retrieveMessage(long id) throws Exception {
		return (Comment) getCurrentSession().createQuery("from Comment where id="+id).uniqueResult();
	}

	@Override
	public List<Message> retrieveAllMessages() throws Exception {
		List<Message> lc = getCurrentSession().createQuery("from Comment").list();
		for (Message c : lc) {
			Hibernate.initialize(((Comment)c).getUserService());
			Hibernate.initialize(((Comment)c).getReceiver());
			Hibernate.initialize(((Comment)c).getSender());
		}
		return lc;
	}

	@Override
	public List<Comment> retrieveByReceiver(Object receiver) throws Exception {
		Query q = getCurrentSession().createQuery("from Comment where receiver=:receiver");
		q.setParameter("receiver", (Person) receiver);
		return q.list();
	}
	
	@Override
	public List<Comment> retrieveBySender(Object sender) throws Exception {
		Query q = getCurrentSession().createQuery("from Comment where sender=:sender ");
		q.setParameter("sender", (Person) sender);
		return q.list();
	}
	
	@Override
	public List<Message> retrieveBySenderAndReceiver(Object sender, Object receiver) throws Exception {
		Query q = getCurrentSession().createQuery("from Comment where sender=:sender and receiver=:receiver");
		q.setParameter("receiver", (Person) receiver);
		q.setParameter("sender", (Person) sender);
		return q.list();
	}

	@Override
	public List<Comment> retrieveByUserService(UserService userService) throws Exception {
		Query q = getCurrentSession().createQuery("from Comment where userService=:userService");
		q.setParameter("userService", userService);
		return (List<Comment>) q.list();
	}

}
