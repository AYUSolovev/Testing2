package application.controller;

import application.bisinessLayer.test.TestService;
import application.model.test.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import java.util.List;

@Path("/test")
@Consumes("application/json")
@Produces("application/json")
public class TestController {

    @Autowired
    private TestService testService;

    @GET
    @Path("/view")
    @Transactional
    public List<Test> getTests(){
        List<Test> tests = testService.getAllTest();
        return tests;
    }

    @DELETE
    @Path("/{id}")
    public void deleteTest(@PathParam("id") String id){
        testService.deleteTest(id);
    }

    @POST
    @Path("/create")
    @Transactional
    public void createTest(@RequestBody Test test){
        System.out.println(test.getQuestions().get(1).getQuestion());
        testService.createTest(test);
    }

}
