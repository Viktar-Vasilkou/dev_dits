package by.devincubator.vasilkou.dits.model;

import by.devincubator.vasilkou.dits.model.api.Identifiable;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Table(name = "link")
@Proxy(lazy = false)
public class Link implements Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String link;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "literatureId")
    private Literature literature;

    public Link() {
    }

    public Link(String link, Literature literature) {
        this.link = link;
        this.literature = literature;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Literature getLiterature() {
        return literature;
    }

    public void setLiterature(Literature literature) {
        this.literature = literature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link1 = (Link) o;

        if (!id.equals(link1.id)) return false;
        if (!link.equals(link1.link)) return false;
        return literature.equals(link1.literature);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + link.hashCode();
        result = 31 * result + literature.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Link{" +
                "id=" + id +
                ", link='" + link + '\'' +
                ", literatureId=" + literature.getId() +
                '}';
    }
}
