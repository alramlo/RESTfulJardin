package es.upv.RESTfulJardin.DAO;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import es.upv.RESTfulJardin.modelo.User;



public class UserDAO extends GenericDAO{
	
	
	
	public User findUserById(Integer id){
		
		return entityManager.find(User.class, id);
		
	}

	public User findUserByNameAndPass(String name, String pass){
		
		Query q;
	
		try{
			
			q = entityManager.createQuery(" SELECT u"
					+ " FROM User u"
					+ " WHERE u.name=:name AND u.password=:pass");
			q.setParameter("name", name);
			q.setParameter("pass", pass);
			return (User) q.getSingleResult();
			
		}catch(NoResultException e){
			
			return null;
		}
		 
	}
	
}
