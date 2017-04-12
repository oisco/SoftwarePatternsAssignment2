package com.example.Builder;

import com.example.DAO.AddressDAO;
import com.example.DAO.ProductDAO;
import com.example.DAO.UserDAO;
import com.example.Entity.CustOrder;
import com.example.Entity.Customer;
import com.example.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

/**
 * Created by Oisín on 4/12/2017.
 */
@Service
public class CustomerOrderBuilder implements OrderBuilder {
    CustOrder order;

    @Autowired
    ProductDAO productDAO;
    @Autowired
    AddressDAO addressDAO;
    @Autowired
    UserDAO userDAO;

    public CustomerOrderBuilder()
    {
//        this.order=new CustOrder();
    }

    public void createOrder(){
            this.order=new CustOrder();
    }

    @Override
    public void buildPaymentType(Object paymentType) {
        this.order.setPaymentType(paymentType.toString());
    }

    @Override
    public void buildProductList(ArrayList<LinkedHashMap> products) {
        ArrayList<Product> productList=new ArrayList<>();
        double cost=0;

        for (int i = 0; i<products.size(); i++){
            //find product being added to the order
            int prodId= Integer.parseInt(products.get(i).get("id").toString());
            Product theProd=productDAO.findOne(prodId);
            //update the stock level
            int newStockLevel=theProd.getStockLevel()-1;
            theProd.setStockLevel(newStockLevel);
            productDAO.save(theProd);
            //add to order
            cost+=theProd.getPrice();
            productList.add(theProd);
        }
        this.order.setCost(cost);
        this.order.setProducts(productList);
    }

    @Override
    public void buildOrderAddress(Object deliveryAddress) {
        int addressId=Integer.parseInt(((LinkedHashMap) deliveryAddress).get("id").toString());
        this.order.setAddress(addressDAO.findOne(addressId));
    }

    @Override
    public void setOrderDate() {
        Date date=new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        this.order.setDate(date);
    }

    @Override
    public CustOrder getOrder() {
        return this.order;
    }

    @Override
    public void addToUser(Object userInfo) {
        int userId=Integer.parseInt(userInfo.toString());
        this.order.setCustomer((Customer)userDAO.findOne(userId));
    }

}
