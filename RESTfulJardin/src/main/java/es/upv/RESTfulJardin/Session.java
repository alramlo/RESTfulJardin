
package es.upv.RESTfulJardin;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.upv.RESTfulJardin.DAO.UserDAO;
import es.upv.RESTfulJardin.modelo.User;

/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/session/")
public class Session {
    
	private UserDAO userDao;
	
	public Session(){
		
		userDao = new UserDAO();
		
	}
	
    /** Method processing HTTP GET requests, producing "text/plain" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
    @GET 
    @Path("prueba")
    @Produces("text/plain")
    public String getIt() {
        return "Hi there!";
    }
    
    @GET
    @Path("login")
    @Produces(MediaType.TEXT_PLAIN)
    public Response login(
    		@QueryParam("name") String name,
    		@QueryParam("pass") String password){
    	
    	try{
    		
    		User user = userDao.findUserByNameAndPass(name, password);
    		
    		if(user!=null)
    			return Response.status(Response.Status.OK).entity("true").build();
    		else
    			return Response.status(Response.Status.OK).entity("false").build();
    		
    		
    	}catch(Exception e){
    		
    		e.printStackTrace();
    		System.out.println("Se ha producido un error: "+e);
    		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error interno de servidor").build();
    	}
    	
    	
    }
}
