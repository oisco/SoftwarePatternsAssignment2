package com.example.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Oisín on 3/14/2017.
 */
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    Date date;



    public Order(){
    }
}
