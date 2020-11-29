package application.servlet;

import application.model.User.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/question/view/*", "/test/view"})
public class SecurityNormalServletFilter implements Filter {
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest req =
                (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        if(user != null)
            filterChain.doFilter(servletRequest, servletResponse);
        else
            throw new ServletException("You shall not pass!");
    }
}
