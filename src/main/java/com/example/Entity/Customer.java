package com.example.Entity;

import javax.persistence.Entity;
/**
 * Created by Oisín on 3/14/2017.
 */
@Entity
public class Customer extends User {

    public Customer(String username, String password, boolean isAdmin) {
        super(username, password, isAdmin);
    }
    public Customer(){

    }


}
