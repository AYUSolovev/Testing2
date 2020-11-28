package application.dataLayer.DAO.admUserDAO;

import application.model.User.*;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Component
public class AdmUserDAOImpl implements AdmUserDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User getUser(Long id) {
        User user = em.find(AdmUser.class, id);
        return user;
    }

    @Override
    public Long getUserById(String login) {
        try {
            TypedQuery<AdmUser> tq = em.createQuery("Select c from AdmUser c where c.login = :login", AdmUser.class);
            tq.setParameter("login", login);
            return tq.getSingleResult().getId();
        } catch (Exception e){
            throw new RuntimeException("Пользователь не найден");
        }
    }

    @Override
    public void removeUser(User user) {

    }

    @Override
    public void createUser(User user) {

    }
}
