package com.milkdelivery.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milkdelivery.entities.Customer;
import com.milkdelivery.services.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;
    
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody Customer customer) {
        try {
            String response = customerService.registerCustomer(customer);
            return new ResponseEntity<>(response, HttpStatus.CREATED);  // Return 201 Created
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);  // Return 400 Bad Request
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Customer customer) {
        try {
            String response = customerService.authenticateCustomer(customer.getContactNumber(), customer.getPassword());
            return new ResponseEntity<>(response, HttpStatus.OK);  // Return 200 OK
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);  // Return 401 Unauthorized
        }
    }
}
