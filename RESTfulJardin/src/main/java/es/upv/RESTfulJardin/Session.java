
package es.upv.RESTfulJardin;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/session/")
public class Session {
    
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
}
