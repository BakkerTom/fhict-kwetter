import model.Post;
import model.User;
import resource.PostService;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
public class Seeds {

    @Inject
    private PostService postService;

    @Inject
    private UserService userService;

    public Seeds() {
    }

    @PostConstruct
    public void createPosts() {
        User user = userService.create(new User("tom", "tom@email.com", "password"));
        postService.create(new Post("Dit is een post", user));
        postService.create(new Post("Dit is een tweede post", user));
        postService.create(new Post("Dit is een derde post", user));
    }
}
