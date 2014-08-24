package es.upv.RESTfulJardin;

import org.jasypt.util.text.BasicTextEncryptor;

public class Common {
	
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

}
