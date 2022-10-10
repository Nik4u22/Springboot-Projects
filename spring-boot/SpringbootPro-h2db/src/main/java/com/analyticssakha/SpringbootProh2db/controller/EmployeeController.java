package com.analyticssakha.SpringbootProh2db.controller;

import com.analyticssakha.SpringbootProh2db.entity.Employee;
import com.analyticssakha.SpringbootProh2db.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployeesList() {
        return employeeService.getEmployeesList();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long employeeId){
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
