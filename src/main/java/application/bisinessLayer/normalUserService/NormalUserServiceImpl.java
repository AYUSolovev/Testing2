package application.bisinessLayer.normalUserService;

import application.dataLayer.DAO.normalUserDAO.NormalUserDAO;
import application.model.User.NormalUser;
import application.model.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NormalUserServiceImpl implements NormalUserService {

    @Autowired
    private NormalUserDAO userDAO;

    @Override
    public void createUser(User user) {
        List<NormalUser> userList = userDAO.getAllUser();
        for (User u:userList
             ) {
            if (u.getLogin().equals(user.getLogin()))
                throw new RuntimeException("Пользователь с таким логином существует");
        }
        userDAO.createUser(user);
        System.out.println("Пользователь создан");
    }

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
