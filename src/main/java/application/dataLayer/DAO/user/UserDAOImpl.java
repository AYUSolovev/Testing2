package application.dataLayer.DAO.user;

import application.model.User.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Component
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void createUser(User user) {
        em.persist(user);
    }

    @Override
    @Transactional
    public User getUserByLogin(String login) {
        try {
            TypedQuery<User> tq = em.createQuery("Select c from User c where c.login = :login", User.class);
            tq.setParameter("login", login);
            return tq.getSingleResult();
        }catch (Exception e){
        }
        return null;
    }

}
