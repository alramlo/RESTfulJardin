package es.upv.RESTfulJardin.DAO;

import java.util.List;

import javax.persistence.Query;

import es.upv.RESTfulJardin.modelo.Area;

public class AreaDAO extends GenericDAO{
	
	public List<Area> getAreas(){
		
		try{
			
		Query q = entityManager.createQuery("SELECT a FROM Area a");
		return  q.getResultList();
		
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
