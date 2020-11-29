package application.controller;

import application.bisinessLayer.normalUser.NormalUserService;
import application.model.User.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;

@Path("/user")
@Consumes("application/json")
@Produces("application/json")
public class UserController {

    @Autowired
    private NormalUserService nus;

    @POST
    @Path("/registration")
    public void registrationUser(@QueryParam("login") String login, @QueryParam("password") String password, @QueryParam("name") String name){
        User user = new NormalUser();
        user.setLogin(login);
        user.setPassword(password);
        user.setName(name);
        nus.createUser(user);
    }

    @POST
    @Path("/delete")
    public void deleteUser(@QueryParam("login") String login, @QueryParam("password") String password){
        User user = nus.getUser(login, password);
        nus.removeUser(user);
    }

}
