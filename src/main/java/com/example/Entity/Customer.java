package com.example.Entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Oisín on 3/14/2017.
 */
@Entity
@DiscriminatorValue("CUST")
public class Customer extends User {

    @OneToMany(fetch = FetchType.EAGER,targetEntity=Order.class)
    private List<Order> orders;

    public Customer(String username, String password) {
        super(username, password);
    }
    public Customer(){
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
}
