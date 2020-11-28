package application.model.question;
import application.model.test.Test;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "questions")
public class Question {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question")
    private String question;

    @Column(name = "type_question")
    @Enumerated(EnumType.STRING)
    private TypeQuestion typeQuestion;

    @Column(name = "author_question")
    private String authorQuestion;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "question", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Answer> answers;

    @ManyToOne
    @JoinColumn(name = "test_id")
    @JsonBackReference
    private Test test;

    public Question() {
    }

    public Long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public TypeQuestion getTypeQuestion() {
        return typeQuestion;
    }

    public void setTypeQuestion(TypeQuestion typeQuestion) {
        this.typeQuestion = typeQuestion;
    }

    public String getAuthorQuestion() {
        return authorQuestion;
    }

    public void setAuthorQuestion(String authorQuestion) {
        this.authorQuestion = authorQuestion;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answerList) {
        this.answers = answerList;
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
        answer.setQuestion(this);
    }

    public void removeAnswer(Answer answer) {
        answers.remove(answer);
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", typeQuestion=" + typeQuestion +
                ", authorQuestion='" + authorQuestion + '\'' +
                ", answers=" + answers +
                ", test=" + test +
                '}';
    }
}