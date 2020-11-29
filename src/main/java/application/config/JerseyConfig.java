package application.config;

import application.controller.QuestionController;
import application.controller.TestController;
import application.controller.UserController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        register(UserController.class);
        register(QuestionController.class);
        register(TestController.class);
    }
}
