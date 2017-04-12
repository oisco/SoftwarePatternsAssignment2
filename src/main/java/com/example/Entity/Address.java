package com.example.Entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Oisín on 4/10/2017.
 */
@Entity
@JsonAutoDetect
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    public String addressLine1;
    public String addressLine2;
    public String addressLine3;
    public String city;
    public String country;

    //assuming there is no need to know employees address
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "address")
    private Customer customer;

    @JsonIgnore
    @OneToMany(mappedBy = "address")
    List<CustOrder> orders;

    public Address(){}

    public Address(String addressLine1, String addressLine2, String addressLine3, String city, String country, Customer customer, List<CustOrder> orders) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.city = city;
        this.country = country;
        this.customer = customer;
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
