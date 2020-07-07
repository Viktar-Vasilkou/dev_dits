package by.devincubator.vasilkou.dits.model;

import by.devincubator.vasilkou.dits.model.api.Identifiable;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Table(name = "answer")
@Proxy(lazy = false)
public class Answer implements Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Boolean correct;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "questionId", nullable = false)
    private Question question;

    public Answer() {
    }

    public Answer(Long id, String description, Boolean correct, Question question) {
        this.id = id;
        this.description = description;
        this.correct = correct;
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer = (Answer) o;

        if (!id.equals(answer.id)) return false;
        if (!description.equals(answer.description)) return false;
        if (!correct.equals(answer.correct)) return false;
        return question.equals(answer.question);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + correct.hashCode();
        result = 31 * result + question.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", correct=" + correct +
                ", questionID=" + question.getId() +
                '}';
    }
}
