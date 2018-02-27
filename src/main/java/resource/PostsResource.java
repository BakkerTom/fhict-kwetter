package resource;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/posts")
@Stateless
public class PostsResource {

    @GET
    public String index() {
        return "Posts Index";
    }

    @GET
    @Path("/{id}")
    public String show(@PathParam("id") int id) {
        return "Post " + id + " show";
    }
}
