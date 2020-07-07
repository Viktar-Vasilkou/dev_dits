package by.devincubator.vasilkou.dits.model;

import by.devincubator.vasilkou.dits.model.api.Identifiable;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Table(name = "test")
@Proxy(lazy = false)
public class Test implements Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "topicId", nullable = false)
    private Topic topic;

    public Test() {
    }

    public Test(String name, String description, Topic topic) {
        this.name = name;
        this.description = description;
        this.topic = topic;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Test test = (Test) o;

        if (!id.equals(test.id)) return false;
        if (!name.equals(test.name)) return false;
        if (!description.equals(test.description)) return false;
        return topic.equals(test.topic);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + topic.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", topicId=" + topic.getId() +
                '}';
    }
}
