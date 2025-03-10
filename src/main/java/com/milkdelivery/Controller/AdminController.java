package com.milkdelivery.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milkdelivery.entities.Admin;
import com.milkdelivery.services.AdminService;

@RestController
@RequestMapping("/api/admins")
public class AdminController {
    
    @Autowired
    private AdminService adminService;
    
    @PostMapping("/register")
    public String registerAdmin(@RequestBody Admin admin) {
        return adminService.registerAdmin(admin);
    }

    
    @PostMapping("/login")
    public String login(@RequestBody Admin admin) {
        return adminService.authenticateAdmin(admin);
    }
}

