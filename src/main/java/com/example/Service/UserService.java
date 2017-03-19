package com.example.Service;

import com.example.DAO.UserDAO;
import com.example.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Oisín on 3/14/2017.
 */
@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public UserService(UserDAO userDAO){
        this.userDAO=userDAO;
    }

    public void saveUser(User user) {
        this.userDAO.save(user);
    }
}
