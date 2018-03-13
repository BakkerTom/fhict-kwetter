package dao;

import model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless @JPA
public class UserDao {

    @PersistenceContext
    private EntityManager em;

    public User create(User user) {
        em.persist(user);
        return user;
    }

    public User find(Long id) {
        return em.find(User.class, id);
    }
}
