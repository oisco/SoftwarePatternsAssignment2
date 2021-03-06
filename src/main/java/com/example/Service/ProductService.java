package com.example.Service;

import com.example.DAO.CommentDAO;
import com.example.DAO.ProductDAO;
import com.example.DAO.UserDAO;
import com.example.Entity.Comment;
import com.example.Entity.Customer;
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
    @Autowired
    private CommentDAO commentDAO;
    @Autowired
    private UserDAO userDAO;

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

    public void update(Product prod) {
        this.productDAO.save(prod);
    }

    public void addCommentToProduct(int prodId, Comment comment) {
        Product product = this.productDAO.findOne(prodId);
        product.getComments().add(comment);
        comment.setCustomer((Customer) this.userDAO.findOne(comment.getUserId()));
        this.commentDAO.save(comment);
        this.productDAO.save(product);
    }
}
