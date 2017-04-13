package com.example.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by Oisín on 4/13/2017.
 */
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    int rating;
    String comment;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Product.class)
    Product product;

    @ManyToOne
    Customer customer;

    public Comment() {

    }

    public Comment(int rating, String comment, Product product, Customer customer) {
        this.rating = rating;
        this.comment = comment;
        this.product = product;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
