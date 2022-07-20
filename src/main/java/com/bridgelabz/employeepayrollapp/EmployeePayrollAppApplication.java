package com.bridgelabz.employeepayrollapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
@SpringBootApplication
public class EmployeePayrollAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployeePayrollAppApplication.class, args);
        System.out.println("Welcome To The Employee Payroll App");
    }

}
