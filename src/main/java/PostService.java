package resource;

import dao.JPA;
import dao.PostDao;
import javafx.geometry.Pos;
import model.Post;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class PostService {

    @Inject @JPA
    private PostDao postDao;


    public PostService() {

    }

    public Post find(Long id) {
        return postDao.find(id);
    }

    public void create(Post post) {
        postDao.create(post);
    }

    public List<Post> findAll() {
        return postDao.findAll();
    }
}
