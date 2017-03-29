package com.example.Controllers;

import com.example.Entity.Product;
import com.example.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Oisín on 3/14/2017.
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @RequestMapping(value = "all",method = RequestMethod.GET)
    public List<Product> viewAllProducts() {
        return this.productService.findAll();
    }
}
