package com.example.DAO;

import com.example.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Oisín on 3/14/2017.
 */
@Repository
public interface AddressDAO extends JpaRepository<Address, Integer> {

}
