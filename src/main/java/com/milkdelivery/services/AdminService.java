package com.milkdelivery.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.milkdelivery.entities.Admin;
import com.milkdelivery.repositories.AdminRepository;

import jakarta.transaction.Transactional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public String registerAdmin(Admin admin) {
        // Check if email already exists
        if (adminRepository.existsByEmail(admin.getEmail())) {
            return "Email already in use";
        }

        // Encrypt the password before saving
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        adminRepository.save(admin);
        return "Registration successful";
    }

    public Optional<Admin> getAdminByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    public String authenticateAdmin(Admin admin) {
        Optional<Admin> existingAdmin = getAdminByEmail(admin.getEmail());
        if (existingAdmin.isPresent()) {
            if (passwordEncoder.matches(admin.getPassword(), existingAdmin.get().getPassword())) {
                return "Login successful";
            } else {
                return "Invalid password";
            }
        } else {
            return "User not found";
        }
    }

}
