package application.servlet;

import application.model.User.*;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/question/adm/*", "/test/*", "/test/create"})
public class SecurityAdmServletFilter implements Filter {
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest req =
                (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        if(user.getRole() == UserRoleEnum.ADMIN)
            filterChain.doFilter(servletRequest, servletResponse);
        else
            throw new ServletException("You shall not pass!");
    }
}