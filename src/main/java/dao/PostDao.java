package dao;

import javafx.geometry.Pos;
import model.Post;

import javax.ejb.Stateless;
import javax.persistence.*;
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

    public List<Post> findForUser(Long userID) {
        Query query = em.createNamedQuery("Post.findForUser", Post.class);
        query.setParameter("author", userID);
        return new ArrayList<Post>(query.getResultList());
    }
}
