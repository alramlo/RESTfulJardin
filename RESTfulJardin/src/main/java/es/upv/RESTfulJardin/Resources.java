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
import es.upv.RESTfulJardin.modelo.ControlCode;
import es.upv.RESTfulJardin.modelo.ControlElement;

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
			@QueryParam("name") String name,
			@QueryParam("string") String string){
		
		try{
			if( name!=null && string!=null){
				
				String nameUser = common.decrypt(name);
				String stringConnection = common.decrypt(string);
				
				if( common.checkSeesion(nameUser, stringConnection)){
					
					List<Area> listaAreas = new ArrayList<Area>();
					Gson gson = new Gson();
					listaAreas = areaDAO.getAreas();
					Response response = Response.status(Status.OK).entity(gson.toJson(listaAreas)).build();
					return response;
					
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
	
	@GET
	@Path("controlElementsByArea")
	@Produces("aplication/json")
	public Response controlElementsByArea(
			@QueryParam("idArea") Integer idArea,
			@QueryParam("name") String name,
			@QueryParam("string") String string){
		
		
		try{
			
			
			if( idArea!=null && name!=null && string !=null){
				
				//Integer id = Integer.getInteger(idArea);
				String nameUser = common.decrypt(name);
				String stringConnection = common.decrypt(string);
			
				if(common.checkSeesion(nameUser, stringConnection)){
					
					List<ControlElement> listaControlElements = new ArrayList<ControlElement>();
					Gson gson = new Gson();
					listaControlElements = areaDAO.findControlElementsByIdArea(idArea);
					Response response = Response.status(Status.OK).entity(gson.toJson(listaControlElements)).build();
					return response;
						
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
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.toString()).build();
		}
		
	}
	
	
	@GET
	@Path("controlCodesByArea")
	@Produces("aplication/json")
	public Response controlCodesByArea(
			@QueryParam("idArea") Integer idArea,
			@QueryParam("name") String name,
			@QueryParam("string") String string){
		
		
		try{
			
			
			if( idArea!=null && name!=null && string !=null){
				
				//Integer id = Integer.getInteger(idArea);
				String nameUser = common.decrypt(name);
				String stringConnection = common.decrypt(string);
			
				if(common.checkSeesion(nameUser, stringConnection)){
					
					List<ControlCode> listaControlElements = new ArrayList<ControlCode>();
					Gson gson = new Gson();
					listaControlElements = areaDAO.findControlCodesByIdArea(idArea);
					Response response = Response.status(Status.OK).entity(gson.toJson(listaControlElements)).build();
					return response;
						
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
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.toString()).build();
		}
		
	}

}
