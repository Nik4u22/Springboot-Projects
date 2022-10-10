package com.analyticssakha.SpringbootProh2db.controller;

import com.analyticssakha.SpringbootProh2db.entity.Employee;
import com.analyticssakha.SpringbootProh2db.exceptions.EmployeeException;
import com.analyticssakha.SpringbootProh2db.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.apache.logging.log4j.ThreadContext.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    private Employee employee;
    @BeforeEach
    void setUp() {
        employee = Employee.builder().employeeName("Vinay Jagnade").employeeId(1L).build();
    }
/*
    @Test
    void saveEmployee() throws Exception {
        Employee inputEmployee = Employee.builder().employeeName("Vinay Jagnade").build();
        Mockito.when(employeeService.saveEmployee(inputEmployee)).thenReturn(employee);
        mockMvc.perform(MockMvcRequestBuilders.post("/employees")).contentType(MediaType.APPLICATION_JSON).content("{\n" +
                "    \"employeeName\": \"Vinay Jagnade\"\n" +
                "}").andExpect(status().isOk());
    }

    @Test
    void getEmployeeById() throws EmployeeException {
        Mockito.when(employeeService.getEmployeeById(1L)).thenReturn(employee);
        mockMvc.perform(get("/employees/1").content-type(MediaType.APPLICATION_JSON).andExpect(status().isOk()).andExpect(jsonPath("$.employeeName").value(employee.getEmployeeName())));
    }
*/
}
