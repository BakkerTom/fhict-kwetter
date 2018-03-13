package resource;

import model.User;
import service.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
@Stateless
public class UsersResource {

    @Inject
    private UserService userService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response show(@PathParam("id") Long id) {
       User user = userService.find(id);
       return Response.ok(user).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(User user) {
        userService.create(user);
        return Response.ok(user).build();
    }
}
