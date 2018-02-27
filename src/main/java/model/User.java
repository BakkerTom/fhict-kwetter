package model;

import java.io.Serializable;

public class User implements Serializable {

    private Long id;
    private String username;
    private String email;
    private String passwordHash;

    public User() {
    }

}
