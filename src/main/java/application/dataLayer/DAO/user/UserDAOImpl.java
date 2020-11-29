package application.dataLayer.DAO.user;

import application.model.User.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

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
    public User getUserByLogin(String login) {
        TypedQuery<User> tq = em.createQuery("Select c from User c where c.login = :login", User.class);
        tq.setParameter("login",login);
        if (tq.getSingleResult() != null)
            return tq.getSingleResult();
        else return null;
    }

    @Override
    public List<User> getAllUser(){
        TypedQuery<User> tq = em.createQuery("Select c from User c where c.id > : minId", User.class);
        tq.setParameter("minId",0L);
        return tq.getResultList();
    }
}
