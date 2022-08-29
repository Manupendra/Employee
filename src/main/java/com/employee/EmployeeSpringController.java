package com.employee;

import java.net.URI;
import java.util.logging.Logger;

import com.employee.*;

import org.springframework.beans
        .factory.annotation.Autowired;
import org.springframework.http
        .ResponseEntity;
import org.springframework.web.bind
        .annotation.GetMapping;
import org.springframework.web.bind
        .annotation.PostMapping;
import org.springframework.web.bind
        .annotation.RequestBody;
import org.springframework.web.bind
        .annotation.RequestMapping;
import org.springframework.web.bind
        .annotation.RestController;
import org.springframework.web.servlet
        .support.ServletUriComponentsBuilder;


@RestController
@RequestMapping(path = "/employees")
public class EmployeeSpringController {

    Logger logger = Logger.getLogger(EmployeeSpringController.class.getName());
    @Autowired
    private EmployeeDAO employeeDao;

    // Implementing a GET method
    // to get the list of all
    // the employees
    @GetMapping(
            path = "/",
            produces = "application/json")

    public Employees getEmployees()
    {
        logger.info("GET Response: " + employeeDao.getAllEmployees());
        return employeeDao
                .getAllEmployees();

    }


    // Create a POST method
    // to add an employee
    // to the list
    @PostMapping(
            path = "/",
            consumes = "application/json",
            produces = "application/json")

    public ResponseEntity<Object> addEmployee(
            @RequestBody Employee employee)
    {

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

