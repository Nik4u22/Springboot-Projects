package com.analyticssakha.SpringbootProh2db.repository;

import com.analyticssakha.SpringbootProh2db.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Long>{

    public Employee findByEmployeeName(String employeeName);
    //https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html
    public Employee findByEmployeeNameIgnoreCase(String employeeName);
}
