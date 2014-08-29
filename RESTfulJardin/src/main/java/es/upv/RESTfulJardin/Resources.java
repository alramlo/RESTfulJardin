package es.upv.RESTfulJardin;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jasypt.exceptions.EncryptionOperationNotPossibleException;

import com.google.gson.Gson;

import es.upv.RESTfulJardin.DAO.AreaDAO;
import es.upv.RESTfulJardin.DAO.UserDAO;
import es.upv.RESTfulJardin.modelo.Area;

@Path("/resources/")
public class Resources {
	
	private Common common;
	private UserDAO userDAO;
	private AreaDAO areaDAO;
	
	public Resources(){
		
		common = new Common();
		userDAO = new UserDAO();
		areaDAO = new AreaDAO();
		
	}
	
	@GET 
    @Path("prueba")
    @Produces("text/plain")
    public String getIt() {
        return "Hi there!";
    }
	
	@GET
	@Path("getAreas")
	@Produces("aplication/json")
	public Response getAreas(
			@QueryParam("name") String nameUser,
			@QueryParam("string") String string){
		
		try{
			if( nameUser!=null && string!=null){
				
				String name = common.decrypt(nameUser);
				String stringConnection = common.decrypt(string);
				
				if( common.checkSeesion(name, stringConnection)){
					
					List<Area> listaAreas = new ArrayList<Area>();
					Gson gson = new Gson();
					listaAreas = areaDAO.getAreas();
					return Response.status(Status.OK).entity(gson.toJson(listaAreas)).build();
					
				}
				else{
					
					//la sesión no es correcta
					return Response.status(Status.FORBIDDEN).build();
					
				}
			}
			else{	
			
				//faltan parámetros
				return Response.status(Status.BAD_REQUEST).build();
				
			}
		}catch(EncryptionOperationNotPossibleException e){
			
			//Se han pasado los parámetros sin encriptar
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).build();

			
		}		
		
	}
	
	

}
