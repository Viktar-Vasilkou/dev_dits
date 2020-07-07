package by.devincubator.vasilkou.dits.model;

import by.devincubator.vasilkou.dits.model.api.Identifiable;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "topic")
@Proxy(lazy = false)
public class Topic implements Identifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "topic")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Test> tests;

    public Topic() {
    }

    public Topic(String description, String name) {
        this.description = description;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Test> getTests() {
        return tests;
    }

    public void setTests(Set<Test> tests) {
        this.tests = tests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Topic topic = (Topic) o;

        if (!id.equals(topic.id)) return false;
        if (!description.equals(topic.description)) return false;
        if (!name.equals(topic.name)) return false;
        return tests.equals(topic.tests);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + tests.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
