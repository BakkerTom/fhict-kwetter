package resource;

import model.Post;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/posts")
@Stateless
public class PostsResource {

    @Inject
    private resource.PostService postService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response index() {
        List<Post> posts = postService.findAll();
        return Response.ok(posts).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response show(@PathParam("id") Long id) {
        Post post = postService.find(id);
        return Response.ok(post).build();
    }
}
