package application.bisinessLayer.answerService;

import application.bisinessLayer.questionService.QuestionService;
import application.dataLayer.repository.answerRepository.AnswerRepository;
import application.model.question.Answer;
import application.model.question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionService questionService;
    @Override
    public List<Answer> getAllAnswerByQuestion(Question question) {
        List<Answer> answers = answerRepository.findAllByQuestion(question);
        return answers;
    }

    @Override
    public void createAnswer(String questionId, String answer, boolean isCorrect){
        Answer ans = new Answer();
        ans.setAnswer(answer);
        ans.setCorrect(isCorrect);
        ans.setQuestion(questionService.getQuestionById(questionId));
        answerRepository.save(ans);
    }

    @Override
    public void deleteAnswer(String id){
        Long idL = new Long(id);
        answerRepository.deleteById(idL);
    }
}
