package by.devincubator.vasilkou.dits.model;

import by.devincubator.vasilkou.dits.model.api.Identifiable;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "literature")
@Proxy(lazy = false)
public class Literature implements Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "questionId", nullable = false)
    private Question question;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "literature")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Link> links;

    public Literature() {

    }

    public Literature(String description, Question question, Set<Link> links) {
        this.description = description;
        this.question = question;
        this.links = links;
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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Set<Link> getLinks() {
        return links;
    }

    public void setLinks(Set<Link> links) {
        this.links = links;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Literature that = (Literature) o;

        if (!id.equals(that.id)) return false;
        if (!description.equals(that.description)) return false;
        if (!question.equals(that.question)) return false;
        return links.equals(that.links);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + question.hashCode();
        result = 31 * result + links.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Literature{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", questionId=" + question.getId() +
                '}';
    }
}
