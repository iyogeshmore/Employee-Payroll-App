package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements iEmployeeService{
    private List<Employee> employeeList = new ArrayList<>();
    @Override
    public List<Employee> getEmployeeData() {
        return employeeList;
    }
    @Override
    public Employee getEmployeePayrollDataById(int empId) {
        return employeeList.get(empId-1);
    }
    @Override
    public Employee createEmployeePayrollData(EmployeeDTO employeeDTO){
        Employee empData= null;
        empData= new Employee(employeeList.size()+1, employeeDTO);
        employeeList.add(empData);
        return empData;
    }
    @Override
    public Employee updateEmployeePayrollData(int empId, EmployeeDTO employeeDTO) {
        Employee empData = this.getEmployeePayrollDataById(empId);
        empData.setName(employeeDTO.name);
        empData.setSalary(String.valueOf(employeeDTO.salary));
        employeeList.set(empId - 1, empData);
        return empData;
    }
    @Override
    public void deleteEmployeePayrollData(int empID) {
        employeeList.remove(empID-1);
    }
}