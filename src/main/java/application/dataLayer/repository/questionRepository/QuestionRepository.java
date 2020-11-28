package application.dataLayer.repository.questionRepository;

import application.model.question.Question;
import application.model.test.Test;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Long> {
    List<Question> getAllByTest(Test test);
    List<Question> findAllByQuestion(String question);
    Question getById(Long id);
}
