package application.dataLayer.repository;

import application.model.question.Answer;
import application.model.question.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AnswerRepository extends CrudRepository<Answer, Long> {
    List<Answer> getAllByQuestion(Question question);
}
