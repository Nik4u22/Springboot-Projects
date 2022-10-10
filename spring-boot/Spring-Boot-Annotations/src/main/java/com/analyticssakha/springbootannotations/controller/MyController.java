package com.analyticssakha.springbootannotations.controller;

import com.analyticssakha.springbootannotations.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyController {

    /*@RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homepage(){
        System.out.println("This is the homepage");
        return "Homepage";
    }*/
    @Autowired
    @Qualifier("worker_1")
    private Worker worker;

    /*@RequestMapping(value = "/home", method = RequestMethod.GET)
    @ResponseBody
    public Worker homepage(){
        System.out.println("This is the homepage");
        //this.worker.setName("Nikhil Jagnade");
        return this.worker;
    }*/

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    @ResponseBody
    public Worker homepage(@RequestBody Worker worker) {
        worker.work();
        System.out.println("This is the homepage");
        //this.worker.setName("Nikhil Jagnade");
        return this.worker;
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public String getUser(@PathVariable("userId") Integer user_Id){
        return String.valueOf(user_Id);
    }
}
