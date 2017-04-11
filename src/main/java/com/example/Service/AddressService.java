package com.example.Service;

import com.example.DAO.AddressDAO;
import com.example.Entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Oisín on 4/10/2017.
 */
@Service
public class AddressService {
    @Autowired
    AddressDAO addressDAO;
    public void save(Address address){
        addressDAO.save(address);
    }
}
