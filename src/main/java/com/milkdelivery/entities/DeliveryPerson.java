package com.milkdelivery.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "delivery_persons", uniqueConstraints = { @UniqueConstraint(columnNames = "contactNumber") })
public class DeliveryPerson extends BaseUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vehicleNumber;
    private String licenseNumber;

    protected DeliveryPerson() {}

    public DeliveryPerson(String name, String email, String contactNumber, String password, String vehicleNumber, String licenseNumber) {
        super(name, email, contactNumber, password);
        this.vehicleNumber = vehicleNumber;
        this.licenseNumber = licenseNumber;
    }

    public Long getId() { return id; }

    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }

    public String getLicenseNumber() { return licenseNumber; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }
}
