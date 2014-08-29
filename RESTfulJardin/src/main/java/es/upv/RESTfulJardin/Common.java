package es.upv.RESTfulJardin;

import org.jasypt.util.text.BasicTextEncryptor;

import es.upv.RESTfulJardin.DAO.UserDAO;
import es.upv.RESTfulJardin.modelo.User;

public class Common {
	
	UserDAO userDAO;
	
	public Common(){
		
		userDAO = new UserDAO();
	}
	
	 public String encrypt(String string){

	        BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
	        basicTextEncryptor.setPassword("52()^Z]I{pZ0e37<z_(kb.0H");
	        return basicTextEncryptor.encrypt(string);

	    }

	    public String decrypt(String string){

	        BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
	        basicTextEncryptor.setPassword("52()^Z]I{pZ0e37<z_(kb.0H");
	        return basicTextEncryptor.decrypt(string);

	    }
	    
	    public Boolean checkSeesion(String userName, String stringConnection){
			
			User user;
			user = userDAO.findUserByName(userName);
			
			if( user!=null && user.getStringConnection().equals(stringConnection))
				return true;
			else 	
				return false;
			
		}

}
