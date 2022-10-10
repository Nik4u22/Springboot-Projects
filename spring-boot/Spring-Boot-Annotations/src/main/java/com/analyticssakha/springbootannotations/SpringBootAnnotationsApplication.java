package com.analyticssakha.springbootannotations;

import mypack.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringBootAnnotationsApplication implements CommandLineRunner {

    @Autowired
    private Employee employee;
    @Autowired
    private Date date;
    @Autowired
    private Company company;
    @Autowired
    private Student student;
    @Autowired
    @Qualifier("worker_1")
    private Worker worker;

    public static void main(String[] args) {

        SpringApplication.run(SpringBootAnnotationsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        company.start();
        employee.work();
        student.studying();
        worker.work();
    }
}
