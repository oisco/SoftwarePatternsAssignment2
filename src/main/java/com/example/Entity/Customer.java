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
    @OneToMany
    List<Comment> comments;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,targetEntity=CustOrder.class,mappedBy = "customer")
    private List<CustOrder> orders;
    //save a customers primary address
    @OneToOne
    private Address address;


    public Customer(){}

    public Customer(String username, String password, List<CustOrder> orders, Address address, List<Comment> comments) {
        super(username, password);
        this.orders = orders;
        this.address = address;
        this.comments = comments;
    }

    public List<CustOrder> getCustOrders() {
        return orders;
    }

    public void setCustOrders(List<CustOrder> orders) {
        this.orders = orders;
    }

    public void addCustOrder(CustOrder order){
        this.orders.add(order);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
