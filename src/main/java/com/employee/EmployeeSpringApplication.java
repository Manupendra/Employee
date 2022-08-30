package com.employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeSpringApplication {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeSpringController.class);
    public static void main(String[] args) {
        logger.info("Server started");
        SpringApplication.run(EmployeeSpringApplication.class, args);
    }

}
