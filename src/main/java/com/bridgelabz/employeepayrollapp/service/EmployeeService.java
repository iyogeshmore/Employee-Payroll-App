package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements iEmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getEmployeeData() {
        return employeeRepository.findAll();
    }
    @Override
    public Employee  getEmployeePayrollDataById(int empId) {
        return employeeRepository.findById(empId).orElse(null);
    }
    @Override
    public Employee createEmployeePayrollData(EmployeeDTO employeeDTO){
        Employee empData = new Employee(employeeDTO);
        return employeeRepository.save(empData);

    }
    @Override
    public Employee updateEmployeePayrollData(int empId, EmployeeDTO employeeDTO){
        Employee empData = this.getEmployeePayrollDataById(empId);
        empData.updateEmployee(employeeDTO);
        return  employeeRepository.save(empData);
    }
    @Override
    public String deleteEmployeePayrollData(int empID) {
        employeeRepository.deleteById(empID);
        return "Data Deleted";
    }
    @Override
    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeRepository.findEmployeeByDepartment(department);
    }
}