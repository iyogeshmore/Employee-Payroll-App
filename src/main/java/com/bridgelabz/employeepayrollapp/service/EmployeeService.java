package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements iEmployeeService{
    @Override
    public List<Employee> getEmployeeData() {
        List<Employee> empDataList = new ArrayList<>();
        empDataList.add(new Employee(1, new EmployeeDTO("Yogesh", "male", "Engg.", 35000)));
        return empDataList;
    }
    @Override
    public Employee getEmployeePayrollDataById(int empId) {
        Employee  empData= null;
        empData= new Employee (1, new EmployeeDTO("Yogesh", "male", "Engg", 35000));
        return empData;
    }
    @Override
    public Employee createEmployeePayrollData(EmployeeDTO employeeDTO){
        Employee empData= null;
        empData= new Employee(1, employeeDTO);
        return empData;
    }
    @Override
    public Employee updateEmployeePayrollData(EmployeeDTO employeeDTO) {
        Employee empData= null;
        empData = new Employee(1, employeeDTO);
        return empData;
    }

    public void deleteEmployeePayrollData(int empID) {
    }
}