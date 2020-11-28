package application.bisinessLayer.normalUserService;

import application.model.User.*;

public interface NormalUserService {
    void createUser(User user);
    void removeUser(User user);
    User getUser(String login, String password);
}
