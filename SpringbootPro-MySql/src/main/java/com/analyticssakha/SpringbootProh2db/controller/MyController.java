package com.analyticssakha.SpringbootProh2db.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Value("${welcome.message}")
    private String welcomeMessage;
    //@RequestMapping(value = "/home", method = RequestMethod.GET)
    @GetMapping("/home")
    public String helloWorld(){

        //return "hello world";
        return welcomeMessage;
    }
}
