package com.example.Entity;

import com.example.Builder.OrderPlan;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

//**
// * Created by Oisín on 3142017.
// *
@Entity
@NamedNativeQuery(name = "CustOrder.findAllOrders", query = "select u.id,u.username,o.cost,o.order_date," +
        "a.address_line1,a.address_line2,a.address_line3,a.city,a.country,o.id as orderId " +
        " from cust_order o, address a, user u " +
        "where a.id=o.address_id" +
        " and o.customer_id=u.id;")

public class CustOrder implements OrderPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    Address address;
    @ManyToMany(fetch = FetchType.LAZY,targetEntity=Product.class)
    List<Product> products;
    Date order_date;
    double cost;
    String paymentType;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    public CustOrder(){

    }

    public CustOrder(Customer customer, Address address, List<Product> products, Date order_date, double cost, String paymentType) {
        this.customer = customer;
        this.address = address;
        this.products = products;
        this.order_date = order_date;
        this.cost = cost;
        this.paymentType = paymentType;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Address getAddress() {
        return address;
    }

    //    @Override
    public void setAddress(Address deliveryAddress) {
        this.address = deliveryAddress;
    }

    public List<Product> getProducts() {
        return products;
    }

    //    @Override
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getPaymentType() {
        return paymentType;
    }

    //    @Override
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return order_date;
    }

//    @Override
    public void setDate(Date d) {
        this.order_date=d;
    }
}
