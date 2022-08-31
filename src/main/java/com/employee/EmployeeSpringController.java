package com.employee;

import java.net.URI;

import com.employee.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans
        .factory.annotation.Autowired;
import org.springframework.http
        .ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet
        .support.ServletUriComponentsBuilder;


@RestController
@RequestMapping(path = "/")
public class EmployeeSpringController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeSpringController.class);
    @Autowired
    private EmployeeDAO employeeDao;

    //Status of service
    @GetMapping(
            path = "/status",
            produces = "application/json")
    public Object status() {
        logger.info("Status check");
        return "Service is alive";
    }

    // Implementing a GET method
    // to get the list of all
    // the employees
    @GetMapping(
            path = "/employees/get",
            produces = "application/json")

    public Employees getEmployees() {
        logger.info("GET Response: " + employeeDao.getAllEmployees().toString());
        return employeeDao
                .getAllEmployees();

    }


    // Create a POST method
    // to add an employee
    // to the list
    @PostMapping(
            path = "/employees/add",
            consumes = "application/json",
            produces = "application/json")

    public ResponseEntity<Object> addEmployee(
            @RequestBody Employee employee) {

        // Creating an ID of an employee
        // from the number of employees
        Integer id
                = employeeDao
                .getAllEmployees()
                .getEmployeeList()
                .size()
                + 1;

        employee.setId(id);

        employeeDao
                .addEmployee(employee);

        logger.info("Successfully added new employee");

        URI location
                = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(
                        employee.getId())
                .toUri();

        return ResponseEntity
                .created(location)
                .build();
    }
}

