package application.dataLayer.DAO.user;

import application.model.User.User;

import java.util.List;

public interface UserDAO {
    void createUser(User user);
    User getUserByLogin(String login);
}
