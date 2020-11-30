package application.controller;

import application.bisinessLayer.user.UserService;
import application.model.User.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;

@Path("/user")
@Consumes("application/json")
@Produces("application/json")
public class UserController {

    @Autowired
    private UserService userService;

    @POST
    @Path("")
    public void registrationUser(@RequestBody User user){
        userService.createUser(user);
    }

}
