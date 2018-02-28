package dao;

import model.Post;

import java.util.ArrayList;

public interface PostDao {
    ArrayList<Post> all();
    Post find(Long id);
    void create(Post post);
    void destroy(Post post);
}
