package com.example.Controllers;

import com.example.Entity.CustOrder;
import com.example.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Oisín on 3/14/2017.
 */
@RestController
@RequestMapping("orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "{userId}",method = RequestMethod.GET)
    public List<CustOrder> getUsersOrders(@PathVariable int userId) {
        return this.orderService.getUsersOrders(userId);
    }


    @RequestMapping(value = "add",method =  RequestMethod.POST)
    public void saveOrder(@RequestBody Object[] orderDetails) {
        //in request body of the above request includes and object array where index: 0-product list 1-address 2-paymentType
       this.orderService.BuildOrder(orderDetails);
    }
}
