package com.example.Controllers;

import com.example.Entity.Comment;
import com.example.Entity.Product;
import com.example.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "add",method =  RequestMethod.POST)
    public void viewAllProducts(@RequestBody Product prod) {
         this.productService.add(prod);
    }

    @RequestMapping(value = "remove/{id}",method = RequestMethod.DELETE)
    public void removeProduct(@PathVariable int id) {
        this.productService.remove(id);
    }

    @RequestMapping(value = "update",method = RequestMethod.PUT)
    public void updateProduct(@RequestBody Product prod) {
        this.productService.update(prod);
    }

    @RequestMapping(value = "{prodId}/comment", method = RequestMethod.POST)
    public void addCommentToProduct(@PathVariable int prodId, @RequestBody Comment comment) {
        this.productService.addCommentToProduct(prodId, comment);
    }

}
