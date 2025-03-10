package com.milkdelivery.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.milkdelivery.entities.DeliveryPerson;

@Repository
public interface DeliveryPersonRepository extends JpaRepository<DeliveryPerson, Long> {
    
    Optional<DeliveryPerson> findByEmail(String email);
    Optional<DeliveryPerson> findByContactNumber(String contactNumber);

    // ✅ Add this method to prevent duplicate emails
    boolean existsByEmail(String email);

    // ✅ Add this method to prevent duplicate mobile numbers
    boolean existsByContactNumber(String contactNumber);
}
