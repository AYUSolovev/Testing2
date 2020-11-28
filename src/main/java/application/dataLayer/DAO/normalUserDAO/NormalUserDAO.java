package application.dataLayer.DAO.normalUserDAO;

import application.model.User.*;

import java.util.List;

public interface NormalUserDAO {
    User getUser(Long id);
    Long getUserById(String login);
    void removeUser(User user);
    void createUser(User user);
    List<NormalUser> getAllUser();
}
