package com.analyticssakha.SpringbootProh2db.service;

import com.analyticssakha.SpringbootProh2db.entity.Employee;
import com.analyticssakha.SpringbootProh2db.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @BeforeEach //@BeforeAll
    void setUp() {
        Employee employee = Employee.builder().employeeName("Harshal Jagnade").employeeId(1L).build();
        Mockito.when(employeeRepository.findByEmployeeNameIgnoreCase("Harshal Jagnade")).thenReturn(employee);
    }

    @Test
    void saveEmployee() {
    }

    @Test
    void getEmployeesList() {
    }

    @Test
    void getEmployeeById() {
    }

    @Test
    void deleteEmployeeById() {
    }

    @Test
    void updateEmployeeById() {
    }

    @Test
    @DisplayName("Get Data Based on valid employee name")
    //@Disbale  //Disbale the specific test case
    public void getEmployeeByName() {
        String employeeName = "Harshal Jagnade";
        Employee employee = employeeService.getEmployeeByName(employeeName);
        assertEquals(employeeName, employee.getEmployeeName());

    }
}