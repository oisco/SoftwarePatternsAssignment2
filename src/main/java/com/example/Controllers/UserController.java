package com.example.Controllers;

import com.example.Entity.Administrator;
import com.example.Entity.Customer;
import com.example.Entity.User;
import com.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Oisín on 3/14/2017.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @RequestMapping(value = "customer/add",method = RequestMethod.POST)
        public void addCust(@RequestBody Customer user) {
        this.userService.saveUser(user);
    }

    @RequestMapping(value = "admin/add",method = RequestMethod.POST)
    public void addAdmin(@RequestBody Administrator user) {
        this.userService.saveUser(user);
    }

}
