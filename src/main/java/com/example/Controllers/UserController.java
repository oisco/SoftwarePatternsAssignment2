package com.example.Controllers;

import com.example.Entity.Address;
import com.example.Entity.Administrator;
import com.example.Entity.Customer;
import com.example.Entity.User;
import com.example.Service.AddressService;
import com.example.Service.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Oisín on 3/14/2017.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    AddressService addressService;
    @Autowired
    private UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    //
    @RequestMapping(value = "customer/add",method = RequestMethod.POST)
    public void customerFactory(@RequestBody String json) {
        //using gson for ease of mapping nested json objects
        Gson gson = new GsonBuilder().create();
        Customer customer=gson.fromJson(json,Customer.class);

        this.addressService.save(customer.getAddress());
        this.userService.saveUser(customer);
    }

    @RequestMapping(value = "admin/add",method = RequestMethod.POST)
    public void adminFactory(@RequestBody Administrator user) {
        this.userService.saveUser(user);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public User login(@RequestBody Customer user){
        return userService.checkIfExists(user);
    }

    @RequestMapping(value = "{id}/address",method = RequestMethod.GET)
    public Address getUsersAddress(@PathVariable int id) {
        return this.userService.getUsersAddress(id);
    }
}
