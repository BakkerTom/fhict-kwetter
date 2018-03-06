package dao;

import model.Post;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless @JPA
public class PostDao {

    @PersistenceContext
    private EntityManager em;

    public Post find(Long id) {
        return em.find(Post.class, id);
    }

    public void create(Post post) {
        em.persist(post);
    }
    public List<Post> findAll() {
        Query query = em.createQuery("SELECT s FROM Post s");
        return new ArrayList<Post>(query.getResultList());
    }
}
