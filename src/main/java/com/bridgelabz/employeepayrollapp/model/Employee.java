package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@RequiredArgsConstructor
public class Employee {
    String name;
    String department;
    String gender;
    String salary;
    @Id
    @GeneratedValue

    int id;
    public Employee(int empId, EmployeeDTO employeeDTO) {
        this.id = empId;
        this.name = employeeDTO.name;
        this.department = employeeDTO.department;
        this.gender = employeeDTO.gender;
        this.salary = String.valueOf(employeeDTO.salary);
    }

}

