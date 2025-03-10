package com.milkdelivery.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "admins", uniqueConstraints = { @UniqueConstraint(columnNames = "contactNumber") })
public class Admin extends BaseUser {
    
    protected Admin() {}

    public Admin(String name, String email, String contactNumber, String password) {
        super(name, email, contactNumber, password);
    }
}
