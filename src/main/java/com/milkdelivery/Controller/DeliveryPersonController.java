package com.milkdelivery.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milkdelivery.entities.DeliveryPerson;
import com.milkdelivery.services.DeliveryPersonService;

@RestController
@RequestMapping("/api/delivery-persons")
public class DeliveryPersonController {
    
    @Autowired
    private DeliveryPersonService deliveryPersonService;
    
    @PostMapping("/signup")
    public String signup(@RequestBody DeliveryPerson deliveryPerson) {
        return deliveryPersonService.registerDeliveryPerson(deliveryPerson);
    }
    
    @PostMapping("/login")
    public String login(@RequestBody DeliveryPerson deliveryPerson) {
        return deliveryPersonService.authenticateDeliveryPerson(deliveryPerson);
    }
}
