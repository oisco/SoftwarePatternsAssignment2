package com.example.Service;

import com.example.Builder.CustomerOrderBuilder;
import com.example.Builder.OrderEngineer;
import com.example.DAO.OrderDAO;
import com.example.Entity.CustOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Oisín on 3/14/2017.
 */
@Service
public class OrderService {
    @Autowired
    private OrderDAO orderDAO;
@Autowired
CustomerOrderBuilder customerOrderBuilder;

    public OrderService(OrderDAO orderDAO){
        this.orderDAO=orderDAO;
    }
     public void BuildOrder(Object[] orderDetails){

         customerOrderBuilder.createOrder();
         OrderEngineer orderEngineer=new OrderEngineer(customerOrderBuilder);

         orderEngineer.makeOrder(orderDetails);
         orderDAO.save(orderEngineer.getOrder());

     }

    public List<CustOrder> getUsersOrders(int userId) {
        return this.orderDAO.findByCustomerId(userId);
    }
}
