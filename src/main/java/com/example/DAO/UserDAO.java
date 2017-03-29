package com.example.DAO;

import com.example.Entity.Customer;
import com.example.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Oisín on 3/14/2017.
 */
@Repository
public interface UserDAO extends JpaRepository<User, Integer> {


    List<Object[]> checkIfExists(String username, String password);
}
