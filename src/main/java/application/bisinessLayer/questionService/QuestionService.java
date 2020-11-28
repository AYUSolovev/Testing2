package application.bisinessLayer.questionService;

import application.model.question.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getAllQuestion();
    List<Question> getAllQuestionByTest(String id);
    List<Question> findAllByQuestion(String question);
    Question getQuestionById(String id);
    void updateQuestion(String id, String question);
    void deleteQuestion(String id);
    void createQuestion(String question, String typeQuestion, String authorQuestion,
                        String testId);
}
