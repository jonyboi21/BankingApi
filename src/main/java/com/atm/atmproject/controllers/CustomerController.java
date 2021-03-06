package com.atm.atmproject.controllers;

import com.atm.atmproject.models.Customer;
import com.atm.atmproject.successfulresponse.SuccessfulResponseIterable;
import com.atm.atmproject.successfulresponse.SuccessfulResponseObject;
import com.atm.atmproject.successfulresponse.SuccessfulResponseOptional;
import com.atm.atmproject.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCustomers() {
        SuccessfulResponseIterable successfulResponseIterable = new SuccessfulResponseIterable(HttpStatus.OK.value(), "Success", customerService.getAllCustomers());
        return new ResponseEntity<>(successfulResponseIterable, HttpStatus.OK);
    }

    @RequestMapping(value = "/customers/{customerId}", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomerById(@PathVariable Long customerId) {
        customerService.verifyCustomer(customerId);
        Optional<Customer> getCustomerById = customerService.getCustomerById(customerId);
        SuccessfulResponseOptional successfulResponseOptional = new SuccessfulResponseOptional(HttpStatus.OK.value(), "Success", getCustomerById);
        return new ResponseEntity<>(successfulResponseOptional, HttpStatus.OK);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public ResponseEntity<?> createCustomer(@Validated @RequestBody Customer customer) {
        customerService.createCustomer(customer);
        SuccessfulResponseObject successfulResponseObject = new SuccessfulResponseObject(HttpStatus.OK.value(), "Customer account updated", customer);
        return new ResponseEntity<>(successfulResponseObject, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/customers/{customerId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer, @PathVariable Long customerId) {
        customerService.updateCustomer(customer, customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/customers/{customerId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCustomer(@PathVariable Long customerId) {
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
