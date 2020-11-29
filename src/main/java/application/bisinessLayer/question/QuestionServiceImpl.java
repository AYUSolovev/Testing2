package application.bisinessLayer.question;

import application.bisinessLayer.test.TestService;
import application.dataLayer.repository.AnswerRepository;
import application.dataLayer.repository.QuestionRepository;
import application.model.question.Question;
import application.model.test.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRep;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private TestService testService;

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
            questions.get(i).setAnswers(answerRepository.getAllByQuestion(questions.get(i)));
        }
        return questions;
    }

    @Override
    public Question getQuestionById(String id){
        try {
            Long idL = new Long(id);
            Question question = questionRep.getById(idL);
            question.setAnswers(answerRepository.getAllByQuestion(question));
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
    public void createQuestion(Question question){
        questionRep.save(question);
    }
}
