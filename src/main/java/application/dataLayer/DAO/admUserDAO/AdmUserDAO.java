package application.dataLayer.DAO.admUserDAO;

import application.model.User.*;

public interface AdmUserDAO {
    User getUser(Long id);
    Long getUserById(String login);
    void removeUser(User user);
    void createUser(User user);
}
