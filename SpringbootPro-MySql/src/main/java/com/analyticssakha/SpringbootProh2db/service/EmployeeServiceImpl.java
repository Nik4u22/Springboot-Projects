package com.analyticssakha.SpringbootProh2db.service;

import com.analyticssakha.SpringbootProh2db.entity.Employee;
import com.analyticssakha.SpringbootProh2db.exceptions.EmployeeException;
import com.analyticssakha.SpringbootProh2db.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployeesList() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long employeeId) throws EmployeeException {

        //return employeeRepository.findById(employeeId).get();
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (!employee.isPresent()) {
            throw new EmployeeException("Employee record not found");
        }
        return employee.get();
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public Employee updateEmployeeById(Long employeeId, Employee employee) {
        Employee employeeDB = employeeRepository.findById(employeeId).get();

        // Write same condition for all the remaining columns
        if(Objects.nonNull(employee.getEmployeeName()) && !"".equals(employee.getEmployeeName())){
            employeeDB.setEmployeeName(employee.getEmployeeName());
        }

        return employeeRepository.save(employeeDB);
    }

    @Override
    public Employee getEmployeeByName(String employeeName) {
        return employeeRepository.findByEmployeeName(employeeName);
    }

}
