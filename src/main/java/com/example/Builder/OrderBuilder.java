package com.example.Builder;

import com.example.Entity.CustOrder;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by Oisín on 4/11/2017.
 */
public interface OrderBuilder {
    void buildPaymentType(Object paymentType);
    void buildProductList(ArrayList<LinkedHashMap> products);
    void buildOrderAddress(Object deliveryAddress);
    void setOrderDate();

    CustOrder getOrder();

    void addToUser(Object orderDetal);
}
