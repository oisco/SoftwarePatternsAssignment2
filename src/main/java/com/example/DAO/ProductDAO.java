package com.example.DAO;

import com.example.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Oisín on 3/14/2017.
 */
@Repository
public interface ProductDAO extends JpaRepository<Product, Integer> {

}
