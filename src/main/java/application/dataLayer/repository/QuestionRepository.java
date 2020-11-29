package application.dataLayer.repository;

import application.model.question.Question;
import application.model.test.Test;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Long> {
    List<Question> getAllByTests(Test test);
    List<Question> findAllByQuestion(String question);
    Question getById(Long id);
}
