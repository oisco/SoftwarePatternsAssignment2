package com.example.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

/**
 * Created by Oisín on 3/14/2017.
 */
@Entity
public class Customer extends User {

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,targetEntity=Order.class,mappedBy = "customer")
    private List<Order> orders;

    //save a customers primary address
    @OneToOne
    private Address address;

    public Customer(){}

    public Customer(String username, String password, List<Order> orders, Address address) {
        super(username, password);
        this.orders = orders;
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order){
        this.orders.add(order);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
