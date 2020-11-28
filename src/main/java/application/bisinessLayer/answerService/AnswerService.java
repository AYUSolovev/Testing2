package application.bisinessLayer.answerService;

import application.model.question.*;

import java.util.List;

public interface AnswerService {
    List<Answer> getAllAnswerByQuestion(Question question);
    void createAnswer(String questionId, String answer, boolean isCorrect);
    void deleteAnswer(String id);
}
