import dao.JPA;
import dao.UserDao;
import model.User;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class UserService {

    @Inject @JPA
    private UserDao dao;

    public UserService() { }

    public User create(User user) {
        return dao.create(user);
    }

}
