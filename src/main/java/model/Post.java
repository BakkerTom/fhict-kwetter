package model;

import java.io.Serializable;

public class Post implements Serializable {

    private Long id;
    private User author;
    private String content;

    public Post() {
    }
}
