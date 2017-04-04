package com.example.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Oisín on 3/14/2017.
 */
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    public String title;
    public String description;

    public Product(){}

    public Product(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
