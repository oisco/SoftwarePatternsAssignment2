package com.example.Service;

import com.example.DAO.CustomerDAO;
import com.example.DAO.UserDAO;
import com.example.Entity.Address;
import com.example.Entity.Administrator;
import com.example.Entity.Customer;
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
    @Autowired
    private CustomerDAO customerDAO;

    public UserService(UserDAO userDAO){
        this.userDAO=userDAO;
    }

    public void saveUser(User user) {
        this.userDAO.save(user);
    }

    //the below method checks if a user exists and if so if the current user loging in an admin or customer
    public User checkIfExists(User user) {
        if( this.userDAO.checkIfExists(user.getUsername(),user.getPassword()).size()>0)
        {
            //find if we are looking for a admin or customer
            String custType=String.valueOf(this.userDAO.checkIfExists(user.getUsername(),user.getPassword()).get(0)[1]);
            int custId=Integer.parseInt(String.valueOf(this.userDAO.checkIfExists(user.getUsername(),user.getPassword()).get(0)[0]));

            if(custType.equals("Administrator")){
                Administrator currentUser=(Administrator)userDAO.findOne(custId);
                currentUser.setUserType(custType);
                return currentUser;
                }
                else {
                Customer currentUser=(Customer) userDAO.findOne(custId);
                currentUser.setUserType(custType);
                return currentUser;
            }
        }
        else {
            return null;
        }
    }

    public Address getUsersAddress(int id) {
        return customerDAO.getOne(id).getAddress();
    }
}
