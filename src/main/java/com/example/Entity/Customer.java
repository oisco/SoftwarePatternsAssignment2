package com.example.Entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
/**
 * Created by Oisín on 3/14/2017.
 */
@Entity
@DiscriminatorValue("CUST")
public class Customer extends User {

    public Customer(String username, String password) {
        super(username, password);
    }
    public Customer(){


    }


}
