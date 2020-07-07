package by.devincubator.vasilkou.dits.model;

import by.devincubator.vasilkou.dits.model.api.Identifiable;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "question")
public class Question implements Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "testId", nullable = false)
    private Test test;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Answer> answers;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Statistic> statistics;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Literature> literature;

    public Question() {
    }

    public Question(String description, Test test) {
        this.description = description;
        this.test = test;
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

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

    public Set<Statistic> getStatistics() {
        return statistics;
    }

    public void setStatistics(Set<Statistic> statistics) {
        this.statistics = statistics;
    }

    public Set<Literature> getLiterature() {
        return literature;
    }

    public void setLiterature(Set<Literature> literature) {
        this.literature = literature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (!id.equals(question.id)) return false;
        if (!description.equals(question.description)) return false;
        if (!test.equals(question.test)) return false;
        if (answers != null ? !answers.equals(question.answers) : question.answers != null) return false;
        if (statistics != null ? !statistics.equals(question.statistics) : question.statistics != null) return false;
        return literature != null ? literature.equals(question.literature) : question.literature == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + test.hashCode();
        result = 31 * result + (answers != null ? answers.hashCode() : 0);
        result = 31 * result + (statistics != null ? statistics.hashCode() : 0);
        result = 31 * result + (literature != null ? literature.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", testId=" + test.getId() +
                '}';
    }
}
