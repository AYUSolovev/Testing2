package application.controller;

import application.bisinessLayer.answerService.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;

@Path("/answer")
@Consumes("application/json")
@Produces("application/json")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @POST
    @Path("/{questionId}/create")
    public void createAnswer(@PathParam("questionId") String questionId, @QueryParam("answer") String answer,
                             @QueryParam("isCorrect") boolean isCorrect){
        answerService.createAnswer(questionId, answer, isCorrect);
    }

    @POST
    @Path("/delete/{id}")
    public void deleteAnswer(@PathParam("id") String id){
        answerService.deleteAnswer(id);
    }
}
