package application.bisinessLayer.user;

import application.dataLayer.DAO.user.UserDAO;
import application.model.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void createUser(User user) {
        if(userDAO.getUserByLogin(user.getLogin()) == null)
            userDAO.createUser(user);
        else
            throw new RuntimeException("Пользователь с таким логином существует");
    }

    @Override
    public User getUser(String login, String password) {
        User user = userDAO.getUserByLogin(login);
        if (user == null)
            throw new RuntimeException("Пользователь не найден");
        else if(password.equals(user.getPassword()))
            return user;
        else
            throw new RuntimeException("Неверно введен пароль");
    }
}
