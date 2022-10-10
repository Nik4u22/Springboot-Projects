package com.analyticssakha.SpringbootProh2db.service;

import com.analyticssakha.SpringbootProh2db.entity.Employee;
import com.analyticssakha.SpringbootProh2db.exceptions.EmployeeException;

import java.util.List;

public interface EmployeeService {
    public Employee saveEmployee(Employee employee);

    public List<Employee> getEmployeesList();

    public Employee getEmployeeById(Long employeeId) throws EmployeeException;

    public void deleteEmployeeById(Long employeeId);

    public Employee updateEmployeeById(Long employeeId, Employee employee);

    public Employee getEmployeeByName(String employeeName);
}
