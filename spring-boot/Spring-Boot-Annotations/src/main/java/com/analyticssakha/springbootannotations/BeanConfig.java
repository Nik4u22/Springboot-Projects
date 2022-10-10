package com.analyticssakha.springbootannotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.Date;

@Configuration
@ComponentScan(basePackages = "mypack")
public class BeanConfig {

    @Bean()
    public Employee getEmployee(){
        System.out.println("Employee object created");
        return new Employee();
    }

    @Bean
    public Date getDate(){
        System.out.println("Date object created");
        return new Date();
    }

    @Bean("worker_1")
    public Worker getWorker(){
        System.out.println("Worker1 object created");
        return new Worker("worker_1");
    }

    @Bean("worker_2")
    @Lazy
    public Worker createWorker(){
        System.out.println("Worker2 object created");
        return new Worker("worker_2");
    }
}
