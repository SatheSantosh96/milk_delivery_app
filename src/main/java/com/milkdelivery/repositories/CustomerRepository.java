package com.milkdelivery.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.milkdelivery.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
    Optional<Customer> findByEmail(String email);
    Optional<Customer> findByContactNumber(String contactNumber);

    // ✅ Add this method to prevent duplicate emails
    boolean existsByEmail(String email);

    // ✅ Add this method to prevent duplicate mobile numbers
    boolean existsByContactNumber(String contactNumber);
}
