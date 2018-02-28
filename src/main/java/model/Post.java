package model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class Post implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // private User author;
    private String content;

    public Post() {
    }

    public Post(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }
}
