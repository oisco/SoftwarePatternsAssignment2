package com.example.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Oisín on 3/14/2017.
 */
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    public String title;
    public String manufacturer;
    public double price;
    public String description;
    public int stockLevel;
    private String image;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "products",targetEntity = CustOrder.class)
    List<CustOrder> orders;

    public Product(){}

    public Product(String title, String manufacturer, double price, String description, int stockLevel,String image) {
        this.title = title;
        this.manufacturer = manufacturer;
        this.price = price;
        this.description = description;
        this.stockLevel = stockLevel;
        this.image = image;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }
}
