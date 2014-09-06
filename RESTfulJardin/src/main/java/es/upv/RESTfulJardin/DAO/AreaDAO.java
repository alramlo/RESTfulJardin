package es.upv.RESTfulJardin.DAO;

import java.util.List;

import javax.persistence.Query;

import es.upv.RESTfulJardin.modelo.Area;
import es.upv.RESTfulJardin.modelo.ControlCode;
import es.upv.RESTfulJardin.modelo.ControlElement;

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
	
	public List<ControlElement> findControlElementsByIdArea(Integer idArea){
		
		try{
			
			Query q = entityManager.createQuery("SELECT ce "
					+ "FROM Area a, ControlElement ce, AreasControlNode acn, ControlNode cn "
					+ "JOIN acn.controlNode p1 "
					+ "JOIN acn.area p2 "
					+ "JOIN ce.controlNodeBean p3 "
					+ "WHERE a.id=:idArea AND p2.id=a.id AND cn.id=p1.id AND p3.id=cn.id");
			q.setParameter("idArea", idArea);
			return q.getResultList();
			
			
		}catch(Exception e){
			
			e.printStackTrace();
			return null;
		}
		
	}
	
	public List<ControlCode> findControlCodesByIdArea(Integer idArea){
		
		try{
			
			Query q = entityManager.createQuery("SELECT cc "
					+ "FROM Area a, ControlCode cc, AreasControlNode acn, ControlNode cn "
					+ "JOIN acn.controlNode p1 "
					+ "JOIN acn.area p2 "
					+ "JOIN cc.controlNode p3 "
					+ "WHERE a.id=:idArea AND p2.id=a.id AND cn.id=p1.id AND p3.id=cn.id");
			q.setParameter("idArea", idArea);
			return q.getResultList();
			
			
		}catch(Exception e){
			
			e.printStackTrace();
			return null;
		}
		
	}

}
