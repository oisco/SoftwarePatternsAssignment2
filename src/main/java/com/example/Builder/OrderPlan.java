package com.example.Builder;

import com.example.Entity.Address;
import com.example.Entity.Product;

import java.util.Date;
import java.util.List;

/**
 * Created by Oisín on 4/11/2017.
 */
public interface OrderPlan {

     void setPaymentType(String paymentType);
    void setProducts(List<Product> products);
    void setAddress(Address deliveryAddress);
    void setDate(Date date);

}
