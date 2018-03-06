package model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@Entity
@XmlRootElement
public class Post implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User author;

    private String content;

    @PersistenceContext
    private static EntityManager em;

    public Post() {
    }

    public Post(String content, User user) {
        this.content = content;
        this.author = user;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return this.content;
    }

    public User getAuthor() {
        return author;
    }
}
