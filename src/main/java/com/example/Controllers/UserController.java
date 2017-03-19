package com.example.Controllers;

import com.example.Entity.Customer;
import com.example.Entity.User;
import com.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void add(@RequestBody Customer user) {
        this.userService.saveUser(user);
    }

}
