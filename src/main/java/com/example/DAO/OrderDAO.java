package com.example.DAO;

import com.example.Entity.CustOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Oisín on 3/14/2017.
 */
@Repository
public interface OrderDAO extends JpaRepository<CustOrder, Integer> {

    List<CustOrder> findByCustomerId(int userId);

    List<Object[]> findAllOrders();
}
