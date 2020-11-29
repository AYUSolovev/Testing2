package application.controller;

import application.bisinessLayer.question.QuestionService;
import application.model.question.Question;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

@Path("/question")
@Consumes("application/json")
@Produces("application/json")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @POST
    @Path("/adm/view")
    public List<Question> getAllQuestion(@QueryParam("question") String question){
        List<Question> questions = questionService.findAllByQuestion(question);
        return questions;
    }

    @GET
    @Path("/adm/{id}")
    public Question getQuestionById(@PathParam("id") String id){
        Question question = questionService.getQuestionById(id);
        return question;
    }

    @PUT
    @Path("/adm/{id}")
    public void updateQuestion(@PathParam("id") String id, @QueryParam("question") String question){
        questionService.updateQuestion(id,question);
    }

    @DELETE
    @Path("/adm/{id}")
    public void deleteQuestion(@PathParam("id") String id){
        questionService.deleteQuestion(id);
    }

    @POST
    @Path("/adm/create")
    public void createQuestion(Question question){
        questionService.createQuestion(question);
    }

    @GET
    @Path("/view/{testId}")
    public List<String> getQuestionByTest(@PathParam("testId") String testId){
        List<Question> questions = questionService.getAllQuestionByTest(testId);
        List<String> strings = new ArrayList<String>();
        for (int i = 0; i < questions.size(); i++){
            String str ;
            str = "Вопрос № " + (i+1) + " " + questions.get(i).getQuestion() + " Верианты ответов: ";
            for(int j = 0; j < questions.get(i).getAnswers().size(); j++)
                str += (j+1) + ". " + questions.get(i).getAnswers().get(j).getAnswer() + " ";
            strings.add(str);
        }
        return strings;
    }
}
