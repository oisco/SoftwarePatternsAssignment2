package com.example.Controllers;

import com.example.Entity.Administrator;
import com.example.Entity.Customer;
import com.example.Entity.User;
import com.example.Service.AddressService;
import com.example.Service.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by Oisín on 3/14/2017.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    AddressService addressService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @RequestMapping(value = "customer/add",method = RequestMethod.POST)
            public void addCust(@RequestBody String json) {

        //using gson for ease of mapping nested json objects
        Gson gson = new GsonBuilder().create();
        Customer customer=gson.fromJson(json,Customer.class);

        this.addressService.save(customer.getAddress());
        this.userService.saveUser(customer);
    }

    @RequestMapping(value = "admin/add",method = RequestMethod.POST)
    public void addAdmin(@RequestBody Administrator user) {
        this.userService.saveUser(user);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public User login(@RequestBody Customer user){
        ArrayList<String> userInfo=new ArrayList<>();
        return userService.checkIfExists(user);
    }

}
