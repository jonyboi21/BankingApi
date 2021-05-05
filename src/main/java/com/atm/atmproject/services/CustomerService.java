package com.atm.atmproject.services;

import com.atm.atmproject.models.Customer;
import com.atm.atmproject.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    //get all customers
    public void getAllCustomers() {
        Iterable<Customer> allCustomers = customerRepository.findAll();
    }

    //get a customer by Id
    public void getCustomerById(Long customerId) {
        Optional<Customer> c = customerRepository.findById(customerId);
    }

    //create a customer
    public void createCustomer(Customer customer) {
        customer = customerRepository.save(customer);
    }

    //update a customer
    public void updateCustomer(Customer customer, Long customerId) {
        customerRepository.save(customer);
    }



}
