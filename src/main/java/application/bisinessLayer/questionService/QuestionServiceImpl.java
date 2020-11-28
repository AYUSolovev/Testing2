package application.bisinessLayer.questionService;

import application.bisinessLayer.answerService.AnswerService;
import application.bisinessLayer.testService.TestService;
import application.dataLayer.repository.questionRepository.QuestionRepository;
import application.model.question.Question;
import application.model.question.TypeQuestion;
import application.model.test.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRep;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private TestService testService;

    @Override
    public List<Question> getAllQuestion() {
        List<Question> questions = (List<Question>)questionRep.findAll();
        return questions;
    }

    @Override
    public List<Question> findAllByQuestion(String question){
        List<Question> questions = questionRep.findAllByQuestion(question);
        for (int i = 0; i < questions.size(); i++){
            questions.get(i).setAnswers(null);
        }
        return questions;
    }

    @Override
    public List<Question> getAllQuestionByTest(String id){
        Test test = testService.getTestById(id);
        List<Question> questions = questionRep.getAllByTest(test);
        for(int i = 0; i < questions.size(); i++){
            questions.get(i).setAnswers(answerService.getAllAnswerByQuestion(questions.get(i)));
        }
        return questions;
    }

    @Override
    public Question getQuestionById(String id){
        try {
            Long idL = new Long(id);
            Question question = questionRep.getById(idL);
            question.setAnswers(answerService.getAllAnswerByQuestion(question));
            return question;
        } catch (Exception e){
            throw  new RuntimeException("Неверно введены данные");
        }

    }

    @Override
    public void updateQuestion(String id, String question){
        Question quest = getQuestionById(id);
        quest.setQuestion(question);
        questionRep.save(quest);
    }

    @Override
    public void deleteQuestion(String id){
        Question question = getQuestionById(id);
        questionRep.delete(question);
    }

    @Override
    public void createQuestion(String question, String typeQuestion, String authorQuestion,
                               String testId){
        Question quest = new Question();
        quest.setQuestion(question);
        quest.setTest(testService.getTestById(testId));
        quest.setTypeQuestion(TypeQuestion.valueOf(typeQuestion));
        quest.setAuthorQuestion(authorQuestion);
        questionRep.save(quest);
    }
}
