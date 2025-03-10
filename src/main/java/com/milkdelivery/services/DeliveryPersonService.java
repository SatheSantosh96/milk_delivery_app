package com.milkdelivery.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.milkdelivery.entities.DeliveryPerson;
import com.milkdelivery.repositories.DeliveryPersonRepository;

import jakarta.transaction.Transactional;

@Service
public class DeliveryPersonService {
    
    @Autowired
    private DeliveryPersonRepository deliveryPersonRepository;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Transactional
    public String registerDeliveryPerson(DeliveryPerson deliveryPerson) {
        if (deliveryPersonRepository.existsByEmail(deliveryPerson.getEmail())) {
            return "Email already in use";
        }

        deliveryPerson.setPassword(passwordEncoder.encode(deliveryPerson.getPassword()));
        deliveryPersonRepository.save(deliveryPerson);
        return "Registration successful";
    }
    
    public Optional<DeliveryPerson> getDeliveryPersonByEmail(String email) {
        return deliveryPersonRepository.findByEmail(email);
    }
    
    public String authenticateDeliveryPerson(DeliveryPerson deliveryPerson) {
        Optional<DeliveryPerson> existingDeliveryPerson = 
            deliveryPersonRepository.findByEmail(deliveryPerson.getEmail());

        if (existingDeliveryPerson.isPresent()) {
            if (passwordEncoder.matches(deliveryPerson.getPassword(), existingDeliveryPerson.get().getPassword())) {
                return "Login successful";
            } else {
                return "Invalid password";
            }
        } else {
            return "User not found";
        }
    }
}
