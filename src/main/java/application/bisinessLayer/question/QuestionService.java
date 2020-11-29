package application.bisinessLayer.question;

import application.model.question.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getAllQuestionByTest(String id);
    List<Question> findAllByQuestion(String question);
    Question getQuestionById(String id);
    void updateQuestion(String id, String question);
    void deleteQuestion(String id);
    void createQuestion(Question question);
}
