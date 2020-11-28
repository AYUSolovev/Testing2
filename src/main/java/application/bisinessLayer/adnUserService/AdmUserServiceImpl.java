package application.bisinessLayer.adnUserService;


import application.dataLayer.DAO.admUserDAO.AdmUserDAO;
import application.model.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdmUserServiceImpl implements AdmUserService {

    @Autowired
    private AdmUserDAO userDAO;

    @Override
    public void removeUser(User user) {
        userDAO.removeUser(user);
    }

    @Override
    public User getUser(String login, String password) {
        User user = userDAO.getUser(userDAO.getUserById(login));
        if(user != null && password.equals(user.getPassword()))
            return user;
        throw new RuntimeException("Неверно введены данные");
    }
}

