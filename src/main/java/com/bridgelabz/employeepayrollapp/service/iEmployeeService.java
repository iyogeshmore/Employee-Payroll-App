package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;

import java.util.List;

public interface iEmployeeService {
    List<Employee> getEmployeeData();

    Employee getEmployeePayrollDataById(int empId);

    Employee createEmployeePayrollData(EmployeeDTO employeeDTO);

    Employee updateEmployeePayrollData(EmployeeDTO employeeDTO);
}