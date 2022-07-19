package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements iEmployeeService{
    @Autowired
    EmployeeRepository repository;
    private List<Employee> employeeList = new ArrayList<>();
    @Override
    public List<Employee> getEmployeeData() {
        return employeeList;
    }
    @Override
    public Employee getEmployeePayrollDataById(int empId) {
        return employeeList.stream()
                .filter(empData -> empData.getId() == empId)
                .findFirst()
                .orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
    }
    @Override
    public Employee createEmployeePayrollData(EmployeeDTO employeeDTO){
        Employee empData= new Employee(employeeList.size()+1, employeeDTO);
        employeeList.add(empData);
        return repository.save(empData);
    }
    @Override
    public void deleteEmployeePayrollData(int empID) {
        employeeList.remove(empID-1);
    }

    @Override
    public Employee updateEmployeePayrollData(int empId, EmployeeDTO employeeDTO){
        Employee empData = this.getEmployeePayrollDataById(empId);
        empData.setName(employeeDTO.name);
        empData.setDepartment(employeeDTO.department);
        empData.setGender(employeeDTO.gender);
        empData.setSalary(String.valueOf(employeeDTO.salary));
        employeeList.set(empId - 1, empData);
        return empData;
    }
}