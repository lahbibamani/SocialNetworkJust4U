package fr.unicaen.am.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import domain.person.Person;
import domain.person.SQLPersonDAO;
import fr.unicaen.am.model.User;
import fr.unicaen.am.model.UserRole;
import utils.PropertyLoader;
/**
 * Classe de manipulation sur des utilisateur de l'application
 * @author LAHBIB Amani, KHARAIM Nikita - Université de Caen Normandie, France
 * @since January, 2016
 * @see User
 */
@Repository
public class PersonDAO extends SQLPersonDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public static final Map <String,String> properties = new HashMap<>();;
	private static Connection link;
	static {
		try {
				String[] data = new PropertyLoader().getFile("jdbc.properties").split("\n");
				for (String d : data)
					PersonDAO.properties.put(d.split("=")[0], d.split("=")[1]);
			System.out.println(properties);
        	MysqlDataSource ds=new MysqlDataSource();
            ds.setServerName(properties.get("jdbc.domain"));
            ds.setDatabaseName(properties.get("jdbc.db"));
            link=ds.getConnection(properties.get("jdbc.username"),properties.get("jdbc.password"));
            if (!link.isValid(0)) {
                throw new SQLException("Failed to initialize a valid connection to database.");
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	public PersonDAO() throws SQLException {
		
		super(link,"user");
		//createTables();
	}
	
	@Override
	public User retrieve(String email){
		User user = (User)sessionFactory.getCurrentSession().createQuery("from User where email ='"+email+"'").uniqueResult();
		Hibernate.initialize(user.getUserRole());
		return user;
	}
	
	@Override
	public void delete(String email){
		Query q = sessionFactory.getCurrentSession().createQuery(
				"delete from UserRole ur where ur.user.email=:email");
		q.setParameter("email", email);
		q.executeUpdate();
		q = sessionFactory.getCurrentSession().createQuery(
				"delete from User u where u.email=:email");
		q.setParameter("email", email);
		q.executeUpdate();
	}
	
	@Override
	public void create(Person p, String password) throws Exception{
		sessionFactory.getCurrentSession().save((User)p);
		sessionFactory.getCurrentSession().save(new UserRole((User)p,"ROLE_USER"));
	}
	
	@Override
	public List<Person> retrieveAll() throws SQLException {
		return sessionFactory.getCurrentSession().createQuery(
				"select u from User u").list();
		
	}

}
