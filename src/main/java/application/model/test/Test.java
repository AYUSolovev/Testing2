package application.model.test;

import application.model.question.Question;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "test")
public class Test {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "test_to_question",
            joinColumns = {
                    @JoinColumn(name = "test_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "question_id")})
    private List<Question> questions;

    public Test() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void addQuestion(Question question) {
        question.addTest(this);
        questions.add(question);
    }

    public void removeQuestion(Question question) {
        questions.remove(question);
    }

}
