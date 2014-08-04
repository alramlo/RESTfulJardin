package es.upv.RESTfulJardin.DAO;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class GenericDAO {
	
	
	EntityManager entityManager;
	
	
	public GenericDAO(){
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("RESTfulJardin");
		entityManager = entityManagerFactory.createEntityManager();
		
	}
	
	

}
