package application.bisinessLayer.adnUserService;

import application.model.User.User;

public interface AdmUserService {
    void removeUser(User user);
    User getUser(String login, String password);
}
