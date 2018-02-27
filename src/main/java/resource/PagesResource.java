package resource;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/helloworld")
@Stateless
public class PagesResource {
    @GET
    @Produces("text/plain")
    public String index() {
        return "Hello World!";
    }
}
