package com.example.Controllers;

import com.example.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Oisín on 3/14/2017.
 */
@RestController
@RequestMapping("orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "add",method =  RequestMethod.POST)
    public void saveOrder(@RequestBody Object[] orderDetails) {
        //in request body of the above request includes and object array where index: 0-product list 1-address 2-paymentType
        orderService.BuildOrder(orderDetails);
    }
}
