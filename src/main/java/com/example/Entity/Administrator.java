package com.example.Entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Oisín on 3/14/2017.
 */
@Entity
//@DiscriminatorValue("ADMIN")
public class Administrator extends User {
    
    public Administrator(String username, String password) {
        super(username, password);
    }
    public Administrator(){
    }

}
