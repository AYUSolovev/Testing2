package application.servlet;

import application.bisinessLayer.adnUserService.AdmUserService;
import application.bisinessLayer.normalUserService.NormalUserService;
import application.model.User.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "servletAuthorizationNormalUser", urlPatterns = "/user/authorization")
public class ServletAuthorizationNormalUser extends HttpServlet {

    @Autowired
    private NormalUserService userService;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        User user = userService.getUser(login, password);
        if (user.getName() != null){
            session.setAttribute("user",user);
            System.out.print("Авторизация прошла успешно");
        }
        else{
            System.out.print("Неудачно");
        }

    }
}
