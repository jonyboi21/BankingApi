package com.atm.atmproject.controllers;

import com.atm.atmproject.models.Customer;
import com.atm.atmproject.repositories.CustomerRepository;
import com.atm.atmproject.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    //get all customers
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Customer>> getAllCustomers() {
        customerService.getAllCustomers();
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    //get customer by Id
    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomerById (@PathVariable Long customerId) {
        customerService.getCustomerById(customerId);
        return new ResponseEntity<>(customerRepository.findById(customerId), HttpStatus.OK);
    }

    //create a customer
    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public ResponseEntity<?> createCustomer (@RequestBody Customer customer) {
        customerService.createCustomer(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //update a customer
    @RequestMapping(value = "/customers/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCustomer (@RequestBody Customer customer, @PathVariable Long customerId) {
        customerService.updateCustomer(customer, customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //delete a customer
    @RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCustomer (@PathVariable Long customerId) {
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
