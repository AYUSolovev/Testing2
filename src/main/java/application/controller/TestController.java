package application.controller;

import application.bisinessLayer.test.TestService;
import application.model.test.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
    public List<Test> getTests(){
        List<Test> tests = testService.getAllTest();
        return tests;
    }

    @DELETE
    @Path("/delete/{id}")
    public void deleteTest(@PathParam("id") String id){
        testService.deleteTest(id);
    }

}
