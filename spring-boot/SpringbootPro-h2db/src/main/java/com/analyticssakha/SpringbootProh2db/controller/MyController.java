package com.analyticssakha.SpringbootProh2db.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    //@RequestMapping(value = "/home", method = RequestMethod.GET)
    @GetMapping("/home")
    public String helloWorld(){
        return "hello world";
    }
}
