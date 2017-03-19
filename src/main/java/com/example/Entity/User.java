package com.example.Entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Oisín on 3/14/2017.
 */
@Entity
@Inheritance
@DiscriminatorColumn(name = "USER_TYPE")
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;


     String username;
     String password;

public User(){}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
