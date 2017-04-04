package com.example.Service;

import com.example.DAO.ProductDAO;
import com.example.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Oisín on 3/14/2017.
 */
@Service
public class ProductService {
    @Autowired
    private ProductDAO productDAO;
    public ProductService(ProductDAO productDAO){

        this.productDAO=productDAO;
    }

    public List<Product> findAll() {
       return this.productDAO.findAll();
    }

    public void add(Product prod) {
        this.productDAO.save(prod);
    }

    public void remove(int id) {
        this.productDAO.delete(id);
    }
}
