package com.example.Entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Oisín on 3/14/2017.
 */
@Entity
//@Inheritance
//@DiscriminatorColumn(name = "USER_TYPE")
@NamedNativeQuery(name = "User.checkIfExists", query="select id,dtype from user  where username= ?1 and password= ?2 ;")
//@NamedNativeQuery(name = "User.checkIfExists", query="select * from user  where username= ?1 and password= ?2 ;")
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Transient
    String userType;

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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
