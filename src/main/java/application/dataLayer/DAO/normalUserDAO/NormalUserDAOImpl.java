package application.dataLayer.DAO.normalUserDAO;


import application.model.User.NormalUser;
import application.model.User.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class NormalUserDAOImpl implements NormalUserDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User getUser(Long id) {
        User user = em.find(NormalUser.class, id);
        return user;
    }

    @Override
    public Long getUserById(String login) {
        try {
            TypedQuery<NormalUser> tq = em.createQuery("Select c from NormalUser c where c.login = :login", NormalUser.class);
            tq.setParameter("login",login);
            return tq.getSingleResult().getId();
        }catch (Exception e){
            throw new RuntimeException("Пользователь не найден");
        }
    }

    @Override
    public List<NormalUser> getAllUser(){
        TypedQuery<NormalUser> tq = em.createQuery("Select c from NormalUser c where c.id > : minId", NormalUser.class);
        tq.setParameter("minId",0L);
        List<NormalUser> userList = tq.getResultList();
        return userList;
    }

    @Transactional
    public void removeUser(User user) {
        em.remove(em.find(NormalUser.class, user.getId()));
    }


    @Transactional
    public void createUser(User user) {
        em.persist(user);
    }
}

