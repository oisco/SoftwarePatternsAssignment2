package com.example.Service;

import com.example.DAO.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Oisín on 3/14/2017.
 */
@Service
public class OrderService {
    @Autowired
    private OrderDAO orderDAO;

    public OrderService(OrderDAO orderDAO){
        this.orderDAO=orderDAO;

    }
}
