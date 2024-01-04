package com.cars.cars.Service;


import com.cars.cars.Model.Customer;

import com.cars.cars.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerService implements CustomerServices{

    @Autowired
    private CustomerRepo customerRepo;



    @Override
    public List<Customer> GetAllCustomer() {
        return customerRepo.findAll();
    }

    @Override
    public Customer FindCustomerById(int customerId) {
        Optional<Customer> optional = customerRepo.findById(customerId);
        Customer customer;
        if (optional.isPresent()) {
            customer = optional.get();
        }
        else {
            throw new RuntimeException(
                    "Customer not found for id : " + customerId);
        }
        return customer;

    }

    @Override
    public void SaveCustomer(Customer customer) {
         customerRepo.save(customer);
    }

    @Override
    public void DeleteCustomer(Customer customer) {
        customerRepo.delete(customer);
    }


}
