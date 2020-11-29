package application.bisinessLayer.user;

import application.model.User.User;

public interface UserService {
    void createUser(User user);
    User getUser(String login, String password);
}
