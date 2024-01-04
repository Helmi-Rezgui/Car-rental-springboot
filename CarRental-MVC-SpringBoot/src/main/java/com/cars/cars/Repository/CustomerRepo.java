package com.cars.cars.Repository;

import com.cars.cars.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    Customer findByCustomerId(int customerId);
}
