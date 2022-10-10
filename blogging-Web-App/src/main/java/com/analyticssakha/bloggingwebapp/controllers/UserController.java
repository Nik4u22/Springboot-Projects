package com.analyticssakha.bloggingwebapp.controllers;

import com.analyticssakha.bloggingwebapp.entities.User;
import com.analyticssakha.bloggingwebapp.payloads.UserDto;
import com.analyticssakha.bloggingwebapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    // Define simple loger - will help during application debugging
    //public final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        //logger.info("Saving employee");
        UserDto createuserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createuserDto, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @PathVariable("userId") Integer id, @RequestBody UserDto userDto){
        UserDto updatedUser = this.userService.updateUser(userDto, id);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer id){
        this.userService.deleteUser(id);
        return ResponseEntity.ok(Map.of("message", "User deleted successfully"));
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getUsersList() {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userId") Integer id) {
        return ResponseEntity.ok(this.userService.getUserById(id));
    }

    /*
    @GetMapping("/employees")
    public List<Employee> getEmployeesList() {
        logger.info("Fecthing employee List");
        return employeeService.getEmployeesList();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long employeeId) throws EmployeeException {
        return employeeService.getEmployeeById(employeeId);
    }

    @GetMapping("/employees/name/{name}")
    public Employee getEmployeeByName(@PathVariable("name") String employeeName){
        return employeeService.getEmployeeByName(employeeName);
    }
    */

}
