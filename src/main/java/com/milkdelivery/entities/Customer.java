package com.milkdelivery.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "customers", uniqueConstraints = { @UniqueConstraint(columnNames = "contactNumber") })
public class Customer extends BaseUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deliveryAddress;

    protected Customer() {}

    public Customer(String name, String email, String contactNumber, String password, String deliveryAddress) {
        super(name, email, contactNumber, password);
        this.deliveryAddress = deliveryAddress;
    }

    public Long getId() { return id; }

    public String getDeliveryAddress() { return deliveryAddress; }
    public void setDeliveryAddress(String deliveryAddress) { this.deliveryAddress = deliveryAddress; }
}
