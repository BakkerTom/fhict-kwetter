package model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Post.findForUser", query = "SELECT p FROM Post p WHERE p.author.id = :author")
})
public class Post implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User author;
    private String content;

    @ManyToMany
    private List<User> user;

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

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
