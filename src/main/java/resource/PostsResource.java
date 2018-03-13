package resource;

import model.Post;
import model.User;
import service.PostService;
import service.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/posts")
@Stateless
public class PostsResource {

    @Inject
    private PostService postService;

    @Inject
    private UserService userService;

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

    @GET
    @Path("/user/{user_id}")
    public Response showUserPosts(@PathParam("user_id") Long userID) {
        List<Post> posts = postService.findForUser(userID);
        return  Response.ok(posts).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@HeaderParam("apikey") Long userId, Post post) {
        User user = userService.find(userId);
        post.setAuthor(user);
        postService.create(post);
        return Response.ok(post).build();
    }
}
