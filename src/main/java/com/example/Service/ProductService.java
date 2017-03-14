package com.example.Service;

import com.example.DAO.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
