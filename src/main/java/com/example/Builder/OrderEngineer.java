package com.example.Builder;

import com.example.Entity.CustOrder;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by Oisín on 4/12/2017.
 */
//director class--users customerorderbuilder to create an order
public class OrderEngineer {

    OrderBuilder orderBuilder;
    public OrderEngineer(OrderBuilder o){
        this.orderBuilder=o;
    }

    public CustOrder getOrder(){
        return this.orderBuilder.getOrder();
    }

    public void makeOrder(Object[] orderDetals){
        //object array where index: 0-product list 1-address 2-paymentType 3-currentuser
        this.orderBuilder.buildOrderAddress(orderDetals[1]);
        this.orderBuilder.buildPaymentType(orderDetals[2]);
        this.orderBuilder.buildProductList((ArrayList<LinkedHashMap>) orderDetals[0]);
        this.orderBuilder.addToUser(orderDetals[3]);
        this.orderBuilder.setOrderDate();
    }

}
