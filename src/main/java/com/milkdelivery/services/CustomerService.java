package com.milkdelivery.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.milkdelivery.entities.Customer;
import com.milkdelivery.repositories.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Transactional
    public String registerCustomer(Customer customer) {
        if (customerRepository.existsByEmail(customer.getEmail())) {
            return "Email is already registered!";
        }
        if (customerRepository.findByContactNumber(customer.getContactNumber()).isPresent()) {
            return "Mobile number is already registered!";
        }
        
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customerRepository.save(customer);
        return "Customer registered successfully!";
    }
    
    public Optional<Customer> getCustomerByContactNumber(String contactNumber) {
        return customerRepository.findByContactNumber(contactNumber);
    }

    public String authenticateCustomer(String contactNumber, String password) {
        Optional<Customer> existingCustomer = customerRepository.findByContactNumber(contactNumber);
        if (existingCustomer.isPresent()) {
            if (passwordEncoder.matches(password, existingCustomer.get().getPassword())) {
                return "Login successful";
            } else {
                return "Invalid password";
            }
        } else {
            return "User not found";
        }
    }


}
