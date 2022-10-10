package com.analyticssakha.SpringbootProh2db.repository;

import com.analyticssakha.SpringbootProh2db.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Employee employee = Employee.builder().employeeName("Harshal Jagnade").employeeId(1L).build();
        entityManager.persist(employee);
    }

    @Test
    public void whenGetEmployeeById_ReturnEmployee(){
        Employee employee = employeeRepository.findById(1L).get();
        assertEquals(employee.getEmployeeName(), "Harshal Jagnade");

    }
}