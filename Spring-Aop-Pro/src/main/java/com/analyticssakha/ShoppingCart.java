package com.analyticssakha;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
    /* Business Logic - Logging, Authentication and Access Management, Sanitizing data */
    public void checkout(String status){
        System.out.println("Checkout from shopping cart");
    }
}
