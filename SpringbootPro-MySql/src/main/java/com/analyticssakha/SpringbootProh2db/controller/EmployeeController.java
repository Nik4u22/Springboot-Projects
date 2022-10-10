package com.analyticssakha.SpringbootProh2db.controller;

import com.analyticssakha.SpringbootProh2db.entity.Employee;
import com.analyticssakha.SpringbootProh2db.exceptions.EmployeeException;
import com.analyticssakha.SpringbootProh2db.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Define simple loger - will help during application debugging
    public final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @PostMapping("/employees")
    public Employee saveEmployee(@Valid @RequestBody Employee employee) {
        logger.info("Saving employee");
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployeesList() {
        logger.info("Fecthing employee List");
        return employeeService.getEmployeesList();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long employeeId) throws EmployeeException {
        return employeeService.getEmployeeById(employeeId);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployeeById(employeeId);
        return "success";
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployeeById(@PathVariable("id") Long employeeId, @RequestBody Employee employee){
        return employeeService.updateEmployeeById(employeeId, employee);
    }

    @GetMapping("/employees/name/{name}")
    public Employee getEmployeeByName(@PathVariable("name") String employeeName){
        return employeeService.getEmployeeByName(employeeName);
    }
}
